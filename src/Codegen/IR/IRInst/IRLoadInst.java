package Codegen.IR.IRInst;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRType.IRType;
import Codegen.IR.IRValue.Entity;

public class IRLoadInst extends IRInst {
    public IRType type;
    public Entity dest, ptr;
    public IRLoadInst(Entity dest, Entity ptr) {
        super();
        this.dest = dest;
        this.type = dest.type;
        this.ptr = ptr;
    }
    public String toString()
    {
        return dest.toString() + " = load " + ptr.toString();
    }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
