package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

public class ASMCmpInst extends ASMInst {
    public String op;
    public ASMRegister rd, rs;

    public ASMCmpInst(String op, ASMRegister rd, ASMRegister rs) {
        super();
        this.op = op;
        this.rd = rd;
        this.rs = rs;
        read_reg.add(rs);
        write_reg.add(rd);
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rd == vir) {rd = phy;}
        if (rs == vir) {rs = phy;}
    }

    public String toString()
    {
        return op + "\t" + rd.toString() + ", " + rs.toString();
    }
}
