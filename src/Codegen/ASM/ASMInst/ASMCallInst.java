package Codegen.ASM.ASMInst;

import Codegen.ASM.ASMBlock.ASMFunction;
import Codegen.ASM.ASMValue.ASMPhysicalRegister;

public class ASMCallInst extends ASMInst {
    public ASMFunction func;
    public ASMCallInst(ASMFunction func) {
        super();
        this.func = func;
    }

    public String toString() {
        return "call\t" + (func.toString().equals("__builtin_malloc") ? "malloc" : func.toString());
    }
}
