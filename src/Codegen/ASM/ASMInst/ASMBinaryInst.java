package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMValue;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

public class ASMBinaryInst extends ASMInst {
    public String op;
    public ASMRegister rd, rs1;
    public ASMValue rs2;

    public ASMBinaryInst(String op, ASMRegister rd, ASMRegister rs1, ASMValue rs2) {
        super();
        this.op = op;
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        write_reg.add(rd);
        read_reg.add(rs1);
        if (rs2 instanceof ASMRegister) read_reg.add((ASMRegister) rs2);
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rd == vir)  { rd = phy; }
        if (rs1 == vir) { rs1 = phy; }
        if (rs2 == vir) { rs2 = phy; }
    }

    public String toString() {
        return op + "\t" + rd.toString() + ", " + rs1.toString() + ", " + rs2.toString();
    }
}
