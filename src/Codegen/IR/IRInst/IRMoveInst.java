package Codegen.IR.IRInst;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRValue.Entity;

public class IRMoveInst extends IRInst {
    public Entity dest, src;
    public IRMoveInst(Entity dest, Entity src) {
        super();
        this.dest = dest;
        this.src = src;
    }
    public String toString()
    {
        return "move " + dest.toString() + ", " + src.toString();
    }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
