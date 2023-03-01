package Codegen.ASM.ASMInst;


import Codegen.ASM.ASMValue.ASMGlobalDefine;
import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;


public class ASMLaInst extends ASMInst {
    public ASMRegister rd;
    public ASMGlobalDefine rs;
    public ASMLaInst(ASMRegister _rd, ASMGlobalDefine _rs) {
        super();
        rd =_rd;
        rs =_rs;
        write_reg.add(_rd);
    }
    public String toString()
    {
        return "la\t\t" + rd.toString() + ", " + rs.name;
    }
    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rd == vir) { rd = phy; }
    }

}
