package Codegen.IR.IRValue;

import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.IR.IRType.IRType;

abstract public class Entity {
    public IRType type;
    public ASMRegister val = null;
    public Entity (IRType type)
    {
        this.type = type;
    }
    public String toString()
    {
        return null;
    }
}
