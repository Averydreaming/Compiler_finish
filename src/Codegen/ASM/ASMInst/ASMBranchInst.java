package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMBlock.ASMBlock;
import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

public class ASMBranchInst extends ASMInst {

    public String op;
    public ASMRegister rs1, rs2;
    public ASMBlock dest_block;
    public ASMBranchInst(String op, ASMRegister rs1, ASMRegister rs2, ASMBlock dest_block) {
        super();
        this.op = op;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.dest_block = dest_block;
        read_reg.add(rs1);
        read_reg.add(rs2);
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rs1 == vir) rs1 = phy;
        if (rs2 == vir) rs2 = phy;
    }

    public String toString() { return op+ "\t" + rs1.toString() + ", " + (rs2 != null ? rs2.toString() + ", " : "") + dest_block.toString(); }
}
