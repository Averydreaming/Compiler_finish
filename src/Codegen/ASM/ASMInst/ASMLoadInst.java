package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMValue.ASMAddress;
import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

public class ASMLoadInst extends ASMInst {
    public String op;
    public ASMRegister rd;
    public ASMAddress address;
    public ASMLoadInst(String _op, ASMRegister _rd, ASMAddress _address) {
        super();
        op=_op;
        rd=_rd;
        address=_address;
        write_reg.add(_rd);
        read_reg.add(_address.base);
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rd == vir) { rd = phy; }
        if (address.base == vir) { address.base = phy; }
    }

    public String toString() {
        return op.toString() + "\t\t" + rd.toString() + ", " + address.toString();
    }
}
