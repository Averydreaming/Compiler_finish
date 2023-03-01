package Codegen.IR.IRInst;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRValue.Entity;

public class IRCmpInst extends IRInst {
    public String op;
    public Entity dest, src1, src2;
    public IRCmpInst(Entity dest,String op, Entity _src1, Entity _src2) {
        super();
        this.dest = dest;
        this.op = op;
        this.src1 = _src1;
        this.src2 = _src2;
    }
    public String toString() {return dest.toString()+" = cmp " +op + " "+src1.toString() + ", " +src2.toString();}
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
