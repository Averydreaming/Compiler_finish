package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMValue.ASMAddress;
import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

public class ASMStoreInst extends ASMInst {
    
    public String op;
    public ASMRegister rs;
    public ASMAddress address;

    public ASMStoreInst(String _op, ASMRegister _rs, ASMAddress _address) {
        super();
        op=_op;
        rs=_rs;
        address=_address;
        read_reg.add(_rs);
        read_reg.add(_address.base);
    }

    public String toString()
    {
        return op+"\t\t"+rs.toString()+", "+address.toString();
    }

    public void change(ASMVirtualRegister vir, ASMRegister phy) {
        if (rs == vir) rs = phy;
        if (address.base == vir) address.base = phy;
    }

}
