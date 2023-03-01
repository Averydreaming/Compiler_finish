package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;
public class ASMMvInst extends ASMInst {
    public ASMRegister rd, rs;
    public ASMMvInst(ASMRegister _rd, ASMRegister _rs) {
        super();
        rd=_rd;
        rs=_rs;
        write_reg.add(_rd);
        read_reg.add(_rs);
    }
    public String toString()
    {
        return "mv\t\t"+rd.toString()+", "+rs.toString();
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rd == vir) { rd = phy; }
        if (rs == vir) { rs = phy; }
    }

}
