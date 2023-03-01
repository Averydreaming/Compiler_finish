package Codegen.IR.IRInst;
import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRValue.Entity;
public class IRStoreInst extends IRInst {
    public Entity ptr, val;
    public IRStoreInst(Entity ptr, Entity val) {
        super();
        this.ptr = ptr;
        this.val = val;
    }
    public String toString()
    {
        return "store " + val.toString() + ", " + ptr.toString();
    }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
