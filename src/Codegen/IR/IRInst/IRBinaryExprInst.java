package Codegen.IR.IRInst;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRValue.Entity;

public class IRBinaryExprInst extends IRInst {
    public Entity dest;
    public String op;
    public Entity src1, src2;
    public IRBinaryExprInst(Entity _dest, String _op, Entity _src1, Entity _src2) {
        super();
        dest = _dest;
        op = _op;
        src1 = _src1;
        src2 = _src2;
    }

    @Override public String toString() {return dest.toString() + " = " + op + " " + this.src1.toString() + ", " + this.src2.toString();}

    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
/*
example: %mod_int_3 = add %w_val_1, 2
 */