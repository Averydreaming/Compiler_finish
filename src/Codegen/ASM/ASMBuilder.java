package Codegen.ASM;
import java.util.ArrayList;
import Codegen.ASM.ASMBlock.*;
import Codegen.ASM.ASMInst.*;
import Codegen.ASM.ASMValue.*;
import Codegen.IR.IRBlock.*;
import Codegen.IR.IRInst.*;
import Codegen.IR.IRType.*;
import Codegen.IR.IRValue.*;
public class ASMBuilder {
    public ASMBlock current_ASM_Block;
    public ASMFunction current_ASM_function;
    public ASMGlobal ASM_global;

    public ASMBuilder() { this.ASM_global=new ASMGlobal();}
    public ASMRegister IRType_To_ASMRegister(Entity tmp) {
        if (tmp.val != null) return tmp.val;
        ASMRegister ans=ASMPhysicalRegister.phy_regs.get("zero");
        if (tmp instanceof Constant) {
            int val=((Constant)tmp).val;
            if (tmp.type instanceof IRIntType) {
                if (val != 0) {
                    ans=new ASMVirtualRegister("const_int");
                    ASMImmediate imm=new ASMImmediate(val);
                    if (-2048 <= val && val < 2048) current_ASM_Block.Insts.add(new ASMBinaryInst("addi", ans, ASMPhysicalRegister.phy_regs.get("zero"), imm));
                    else current_ASM_Block.Insts.add(new ASMLiInst(ans, imm));
                } else ans=ASMPhysicalRegister.phy_regs.get("zero");
            }

            if (tmp.type instanceof IRBoolType) {
                if (val != 0) {
                    ans=new ASMVirtualRegister("const_bool");
                    current_ASM_Block.Insts.add(new ASMBinaryInst("addi", ans, ASMPhysicalRegister.phy_regs.get("zero"), new ASMImmediate(1)));
                } else ans=ASMPhysicalRegister.phy_regs.get("zero");
            }
        } else ans=new ASMVirtualRegister(((Register)tmp).id);
        return tmp.val=ans;
    }
//处理全局变量 这些都是在堆里存着的
    public void visit(IRGlobal it) {
        it.global_string.forEach(i -> {
            ASMGlobalDefine tmp=new ASMGlobalDefine("str_" + i.num);
            ASM_global.global_variables.add(tmp);
            i.address=tmp;
            tmp.type="string";
            tmp.s=i.s;
        });
        it.global_variable.forEach(i -> {
            ASMGlobalDefine tmp=new ASMGlobalDefine(i.id);
            ASM_global.global_variables.add(tmp);
            i.address=tmp;
            IRPointerType type=(IRPointerType) i.type;
            if (type.dim == 1) {if (type.basic_type instanceof IRIntType)  tmp.type="int";else tmp.type="bool";}  else tmp.type="int";
            tmp.val=i.init_val.val;
        });
        it.global_function.forEach(i -> i.func=new ASMFunction(i.name));
        it.global_function.forEach(i -> {
            if (!i.builtin_flag) {
                ASM_global.global_functions.add(i.func);
                i.accept(this);
            }
        });
    }
//只有8个寄存器可以放参数和局部变量 处理 ra
    public void visit(IRFunction it) {
        current_ASM_function=it.func;
        it.blocks.forEach(i -> {
            i.block=new ASMBlock("." + i.tag);
            current_ASM_function.blocks.add(i.block);
        });
        current_ASM_Block=it.blocks.get(0).block;
        ASMVirtualRegister ra_store=new ASMVirtualRegister("ra_store");
        current_ASM_function.ra=ra_store;
        current_ASM_Block.Insts.add(new ASMMvInst(ra_store, ASMPhysicalRegister.phy_regs.get("ra")));

        for (var i=0; i < 32; i++)
            if (ASMPhysicalRegister.type_list.get(i) == 1) {
                ASMVirtualRegister callee_store=new ASMVirtualRegister(ASMPhysicalRegister.name_list.get(i) + "_save");
                current_ASM_function.callees.add(callee_store);
                current_ASM_Block.Insts.add(new ASMMvInst(callee_store, ASMPhysicalRegister.phy_regs.get(ASMPhysicalRegister.name_list.get(i))));
            } else current_ASM_function.callees.add(null);

        for (int i=0; i < Integer.min(8, it.para.size()); i++) current_ASM_Block.Insts.add(new ASMMvInst(IRType_To_ASMRegister(it.para.get(i)), ASMPhysicalRegister.phy_regs.get("a" + i)));
        
        for (int i=8; i < it.para.size(); i++) {
            ASMVirtualRegister reg=(ASMVirtualRegister)IRType_To_ASMRegister(it.para.get(i));
            current_ASM_function.para.add(reg.address);
            current_ASM_Block.Insts.add(new ASMLoadInst("lw", reg, reg.address));
        }

        it.blocks.forEach(i -> i.accept(this));
    }

    public void visit(IRBlock it) {
        current_ASM_Block=it.block;
        it.Insts.forEach(i -> i.accept(this));
        current_ASM_Block=null;
    }
    //Inst

    void Deal_Binary_Constant(String op,ASMRegister rd, ASMRegister rs1, int val) {
        if (-2048 <= val && val < 2048) current_ASM_Block.Insts.add(new ASMBinaryInst(op+"i", rd, rs1, new ASMImmediate((val))));
        else {
            current_ASM_Block.Insts.add(new ASMLiInst(rd, new ASMImmediate(val)));
            current_ASM_Block.Insts.add(new ASMBinaryInst(op, rd, rd, rs1));
        }
    }

    public void visit(IRBinaryExprInst it) {
        ASMRegister src1=IRType_To_ASMRegister(it.src1);
        ASMRegister dest=IRType_To_ASMRegister(it.dest);
        if (it.op.equals("add")) {
            if (it.src2 instanceof Constant) { int val=((Constant) it.src2).val; Deal_Binary_Constant("add", dest, src1, val); }
            else  current_ASM_Block.Insts.add(new ASMBinaryInst("add", dest, src1, IRType_To_ASMRegister(it.src2)));
        }
        if (it.op.equals("sub")) {
            if (it.src2 instanceof Constant) { int val=((Constant) it.src2).val; Deal_Binary_Constant("add", dest, src1, -val);}
            else  current_ASM_Block.Insts.add(new ASMBinaryInst("sub", dest, src1, IRType_To_ASMRegister(it.src2)));
        }
        if (it.op.equals("mul")) {current_ASM_Block.Insts.add(new ASMBinaryInst("mul", dest, src1, IRType_To_ASMRegister(it.src2)));}
        if (it.op.equals("sdiv")) {current_ASM_Block.Insts.add(new ASMBinaryInst("div", dest, src1, IRType_To_ASMRegister(it.src2)));}
        if (it.op.equals("srem")) {current_ASM_Block.Insts.add(new ASMBinaryInst("rem", dest, src1, IRType_To_ASMRegister(it.src2)));}
        if (it.op.equals("shl")) {
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                current_ASM_Block.Insts.add(new ASMBinaryInst("slli", dest, src1, new ASMImmediate((val))));
            } else current_ASM_Block.Insts.add(new ASMBinaryInst("sll", dest, src1, IRType_To_ASMRegister(it.src2)));
        }
        if (it.op.equals("ashr")) {
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                current_ASM_Block.Insts.add(new ASMBinaryInst("srai", dest, src1, new ASMImmediate((val))));
            } else  current_ASM_Block.Insts.add(new ASMBinaryInst("sra", dest, src1, IRType_To_ASMRegister(it.src2)));
        }
        if (it.op.equals("and")) {
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                Deal_Binary_Constant("and", dest, src1, val);
            } else current_ASM_Block.Insts.add(new ASMBinaryInst("and", dest, src1, IRType_To_ASMRegister(it.src2)));
        }

        if (it.op.equals("or")){
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                Deal_Binary_Constant("or", dest, src1, val);
            } else current_ASM_Block.Insts.add(new ASMBinaryInst("or", dest, src1, IRType_To_ASMRegister(it.src2)));
        }

        if (it.op.equals("xor")) {
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                Deal_Binary_Constant("xor", dest, src1, val);
            } else current_ASM_Block.Insts.add(new ASMBinaryInst("xor", dest, src1, IRType_To_ASMRegister(it.src2)));
        }
    }

    public void visit(IRBranchInst it) {
        current_ASM_Block.Insts.add(new ASMBranchInst("beqz", IRType_To_ASMRegister(it.cond), null, it.false_block.block));
        current_ASM_Block.Insts.add(new ASMJumpInst(it.true_block.block));
    }

    public void visit(IRCallInst it) {
        for (int i=0; i < Integer.min(8, it.para.size()); i++)  current_ASM_Block.Insts.add(new ASMMvInst(ASMPhysicalRegister.phy_regs.get("a" + i), IRType_To_ASMRegister(it.para.get(i))));
        ArrayList<ASMAddress> tmp=new ArrayList<>();
        for (int i=8; i < it.para.size(); i++) {
            ASMAddress para_address=new ASMAddress();
            tmp.add(para_address);
            current_ASM_Block.Insts.add(new ASMStoreInst("sw", IRType_To_ASMRegister(it.para.get(i)), para_address));
        }
        current_ASM_function.call_func_para_rest.add(tmp);
        current_ASM_Block.Insts.add(new ASMCallInst(it.func.func));
        if (it.dest != null) current_ASM_Block.Insts.add(new ASMMvInst(IRType_To_ASMRegister(it.dest), ASMPhysicalRegister.phy_regs.get("a0")));
    }

    public void visit(IRCmpInst it) {
        ASMRegister src1=IRType_To_ASMRegister(it.src1);
        ASMRegister ans=IRType_To_ASMRegister(it.dest);
        ASMVirtualRegister tmp=new ASMVirtualRegister("cmp_tmp");
        if (it.op.equals("eq")) {
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                Deal_Binary_Constant("add", tmp, src1, -val);
            } else current_ASM_Block.Insts.add(new ASMBinaryInst("sub", tmp, src1, IRType_To_ASMRegister(it.src2)));
            current_ASM_Block.Insts.add(new ASMCmpInst("seqz", ans, tmp));
        }
        if (it.op.equals("ne")) {
            if (it.src2 instanceof Constant) {
                int val=((Constant) it.src2).val;
                Deal_Binary_Constant("add",tmp,src1,-val);
            } else current_ASM_Block.Insts.add(new ASMBinaryInst("sub", tmp, src1, IRType_To_ASMRegister(it.src2)));
            current_ASM_Block.Insts.add(new ASMCmpInst("snez", ans, tmp));
        }
        if (it.op.equals("sge")) {
            ASMRegister src2=IRType_To_ASMRegister(it.src2);
            current_ASM_Block.Insts.add(new ASMBinaryInst("slt", tmp, src1, src2));
            current_ASM_Block.Insts.add(new ASMBinaryInst("xori", ans, tmp, new ASMImmediate(1)));
        }
        if (it.op.equals("sgt")) {
            ASMRegister src2=IRType_To_ASMRegister(it.src2);
            current_ASM_Block.Insts.add(new ASMBinaryInst("slt", ans, src2, src1));
        }
        if (it.op.equals("sle")) {
            ASMRegister src2=IRType_To_ASMRegister(it.src2);
            current_ASM_Block.Insts.add(new ASMBinaryInst("slt", tmp, src2, src1));
            current_ASM_Block.Insts.add(new ASMBinaryInst("xori", ans, tmp, new ASMImmediate(1)));
        }
        if (it.op.equals("slt")) {
            ASMRegister src2=IRType_To_ASMRegister(it.src2);
            current_ASM_Block.Insts.add(new ASMBinaryInst("slt", ans, src1, src2));
        }
    }

    public void visit(IRGetInst it) {
        ASMRegister ans=IRType_To_ASMRegister(it.dest);
        if (it.ptr instanceof Register && ((Register)it.ptr).is_global) {
            current_ASM_Block.Insts.add(new ASMLaInst(ans, ((Register)it.ptr).address));
            return;
        }
        if (it.ptr instanceof StringConstant) {
            current_ASM_Block.Insts.add(new ASMLaInst(ans, ((StringConstant)it.ptr).address));
            return;
        }
        ASMRegister ptr=IRType_To_ASMRegister(it.ptr);
        if (!it.is_class) {
            if (it.offset instanceof Constant) {
                int val=4 * ((Constant)it.offset).val;
                if (-2048 <= val && val < 2048) current_ASM_Block.Insts.add(new ASMBinaryInst("addi", ans, ptr, new ASMImmediate(val)));
                else current_ASM_Block.Insts.add(new ASMBinaryInst("add", ans, ptr, IRType_To_ASMRegister(new Constant(new IRIntType(), val))));
            } else {
                ASMRegister tmp=new ASMVirtualRegister("get_ele_tmp");
                current_ASM_Block.Insts.add(new ASMBinaryInst("slli", tmp, IRType_To_ASMRegister(it.offset), new ASMImmediate(2)));
                current_ASM_Block.Insts.add(new ASMBinaryInst("add", ans, ptr, tmp));
            }
        } else {
            int offset=((Constant)it.offset).val;
            int val=((IRClassType)((IRPointerType)it.ptr.type).basic_type).get_offset(offset);
            if (-2048 <= val && val < 2048)  current_ASM_Block.Insts.add(new ASMBinaryInst("addi", ans, ptr, new ASMImmediate(val)));
                else current_ASM_Block.Insts.add(new ASMBinaryInst("add", ans, ptr, IRType_To_ASMRegister(new Constant(new IRIntType(), val))));
        }
    }

    public void visit(IRJumpInst it) { current_ASM_Block.Insts.add(new ASMJumpInst(it.destination_block.block)); }

    public void visit(IRLoadInst it) {
        ASMRegister ans=IRType_To_ASMRegister(it.dest);
        ASMRegister addr;
        if (it.ptr instanceof Register && ((Register)it.ptr).is_global) {
            addr=new ASMVirtualRegister("ASM_global_addr");
            current_ASM_Block.Insts.add(new ASMLaInst(addr, ((Register)it.ptr).address));
        } else addr=IRType_To_ASMRegister(it.ptr);

        if (it.type.name.equals("bool")) current_ASM_Block.Insts.add(new ASMLoadInst("lb", ans, new ASMAddress(addr, new ASMImmediate(0))));
                                    else current_ASM_Block.Insts.add(new ASMLoadInst("lw", ans, new ASMAddress(addr, new ASMImmediate(0))));
    }

    public void visit(IRStoreInst it) {
        ASMRegister val=IRType_To_ASMRegister(it.val);
        ASMRegister tmp_address;
        if (it.ptr instanceof Register && ((Register)it.ptr).is_global) {
            tmp_address=new ASMVirtualRegister("ASM_global_addr");
            current_ASM_Block.Insts.add(new ASMLaInst(tmp_address, ((Register)it.ptr).address));
        } else tmp_address=IRType_To_ASMRegister(it.ptr);
            
        if (it.val.type.name.equals("bool"))  current_ASM_Block.Insts.add(new ASMStoreInst("sb", val, new ASMAddress(tmp_address,new ASMImmediate(0))));
                                         else current_ASM_Block.Insts.add(new ASMStoreInst("sw", val, new ASMAddress(tmp_address,new ASMImmediate(0))));
    }

    public void visit(IRMoveInst it) { current_ASM_Block.Insts.add(new ASMMvInst(IRType_To_ASMRegister(it.dest), IRType_To_ASMRegister(it.src))); }

    public void visit(IRRetInst it) {
        if (!it.val.type.toString().equals("void")) current_ASM_Block.Insts.add(new ASMMvInst(ASMPhysicalRegister.phy_regs.get("a0"), IRType_To_ASMRegister(it.val)));
        current_ASM_Block.Insts.add(new ASMMvInst(ASMPhysicalRegister.phy_regs.get("ra"), current_ASM_function.ra));
        for (var i=0; i < 32; i++)  if (ASMPhysicalRegister.type_list.get(i) == 1)  current_ASM_Block.Insts.add(new ASMMvInst(ASMPhysicalRegister.phy_regs.get(ASMPhysicalRegister.name_list.get(i)), current_ASM_function.callees.get(i)));
        current_ASM_Block.Insts.add(new ASMRetInst());
    }

    public void visit(IRInst it) {}
}
