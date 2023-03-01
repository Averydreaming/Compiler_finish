package Codegen.ASM;

import java.util.ArrayList;
import java.util.HashMap;

import Codegen.ASM.ASMBlock.*;
import Codegen.ASM.ASMInst.*;
import Codegen.ASM.ASMValue.*;
public class RegAlloc {
    public RegAlloc(ASMGlobal global) {
        for (var global_function:global.global_functions) {
            //计算栈空间
            int offset=0;
            for (var tmp:global_function.call_func_para_rest) {
                offset=Integer.max(offset,tmp.size());
                for (int i=0; i<tmp.size(); i++)
                    tmp.get(i).offset=new ASMImmediate(i << 2);
            }//确定这个函数call的函数里多余的参数变量的最大位移 ，因为这些变量需要在本函数里面处理
            offset<<=2;
            for (var current_block : global_function.blocks) {
                for (var current_Inst : current_block.Insts) {
                    for (var tmp: current_Inst.read_reg)
                        if (tmp instanceof ASMVirtualRegister) {
                            if (((ASMVirtualRegister)tmp).address.offset == null) { ((ASMVirtualRegister)tmp).address.offset = new ASMImmediate(offset); offset += 4; }
                        }
                    for (var tmp: current_Inst.write_reg)
                        if (tmp instanceof ASMVirtualRegister) {
                            if (((ASMVirtualRegister)tmp).address.offset == null) { ((ASMVirtualRegister)tmp).address.offset = new ASMImmediate(offset); offset += 4; }
                        }
                }
            }//函数里没有确定位移的虚拟变量确定位置 方便 load store //确定栈总共需要多少空间
            for (int i = 0; i<global_function.para.size(); i++) { global_function.para.get(i).offset=new ASMImmediate(offset + i * 4);} //函数参数需要的栈空间


            //虚拟内存转换为物理内存
            for (var current_block :global_function.blocks) {
                ArrayList<ASMInst> current_Block_Insts=new ArrayList<>();

                if (current_block == global_function.blocks.get(0)) {
                    if (offset < 2048) current_Block_Insts.add(new ASMBinaryInst("addi", new ASMPhysicalRegister("sp"), new ASMPhysicalRegister("sp"), new ASMImmediate(-offset)));
                    else {
                        current_Block_Insts.add(new ASMLiInst(new ASMPhysicalRegister("s0"), new ASMImmediate(offset)));
                        current_Block_Insts.add(new ASMBinaryInst("sub", new ASMPhysicalRegister("sp"), new ASMPhysicalRegister("sp"), new ASMPhysicalRegister("s0")));
                    }
                }//sp 处理sp指针

                for (var current_inst :current_block.Insts) {  //处理每条指令中的虚拟寄存器  虚拟寄存器load/store到s_i中 //s_i是在栈里的
                    
                    HashMap<ASMVirtualRegister, ASMPhysicalRegister> mp = new HashMap<>();
                    int physical_reg_tot = 0;
                    for (var current_virtual_reg : current_inst.read_reg)
                        if (current_virtual_reg instanceof ASMVirtualRegister) {
                            ASMVirtualRegister tmp_vir = (ASMVirtualRegister)current_virtual_reg;
                            ASMPhysicalRegister tmp_phy;
                            if (mp.containsKey(tmp_vir)) tmp_phy = mp.get(tmp_vir);
                            else mp.put(tmp_vir, tmp_phy = new ASMPhysicalRegister("s" + physical_reg_tot));
                            physical_reg_tot++;
                            current_inst.change((ASMVirtualRegister)current_virtual_reg, tmp_phy);
                            if (tmp_vir.address.offset.val < 2048) current_Block_Insts.add(new ASMLoadInst("lw", tmp_phy, tmp_vir.address));
                            else {
                                ASMPhysicalRegister addr = new ASMPhysicalRegister("s" + physical_reg_tot);
                                physical_reg_tot++;
                                current_Block_Insts.add(new ASMLiInst(addr, tmp_vir.address.offset));
                                current_Block_Insts.add(new ASMBinaryInst("add", addr, tmp_vir.address.base, addr));
                                current_Block_Insts.add(new ASMLoadInst("lw", tmp_phy, new ASMAddress(addr, new ASMImmediate(0))));
                            }
                        }
                    
                    
                    if (current_inst instanceof ASMRetInst) {
                        if (offset < 2048) current_Block_Insts.add(new ASMBinaryInst("addi", new ASMPhysicalRegister("sp"), new ASMPhysicalRegister("sp"), new ASMImmediate(offset)));
                        else {
                            current_Block_Insts.add(new ASMLiInst(new ASMPhysicalRegister("s0"), new ASMImmediate(offset)));
                            current_Block_Insts.add(new ASMBinaryInst("add", new ASMPhysicalRegister("sp"), new ASMPhysicalRegister("sp"), new ASMPhysicalRegister("s0")));
                        }
                    }//处理sp指针
                    
                    current_Block_Insts.add(current_inst);//加入当前指令
                    
                    for (var current_virtual_reg:current_inst.write_reg)
                        if (current_virtual_reg instanceof ASMVirtualRegister) {
                            ASMVirtualRegister tmp_vir = (ASMVirtualRegister)current_virtual_reg;
                            ASMPhysicalRegister tmp_phy;
                            if (mp.containsKey(tmp_vir))  tmp_phy = mp.get(tmp_vir);
                            else mp.put(tmp_vir, tmp_phy = new ASMPhysicalRegister("s" + physical_reg_tot));
                            physical_reg_tot++;
                            current_inst.change((ASMVirtualRegister)current_virtual_reg, tmp_phy);
                            if (tmp_vir.address.offset.val < 2048) current_Block_Insts.add(new ASMStoreInst("sw", tmp_phy, tmp_vir.address));
                            else {
                                ASMPhysicalRegister addr = new ASMPhysicalRegister("s" + physical_reg_tot);
                                physical_reg_tot++;
                                current_Block_Insts.add(new ASMLiInst(addr, tmp_vir.address.offset));
                                current_Block_Insts.add(new ASMBinaryInst("add", addr, tmp_vir.address.base, addr));
                                current_Block_Insts.add(new ASMStoreInst("sw", tmp_phy, new ASMAddress(addr, new ASMImmediate(0))));
                            }
                        }
                
                }
                
                current_block.Insts = current_Block_Insts;
            }
        }
    }
}
