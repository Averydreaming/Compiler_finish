package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMValue.ASMImmediate;
import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

//
public class ASMLiInst extends ASMInst {
    public ASMRegister rd;
    public ASMImmediate imm;
    public ASMLiInst(ASMRegister _rd, ASMImmediate _imm) {
        super();
        rd=_rd;
        imm=_imm;
        write_reg.add(_rd);
    }

    public String toString() {
        return "li\t\t" + rd.toString() + ", " + imm.toString();
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rd == vir) { rd = phy;}
    }


}
