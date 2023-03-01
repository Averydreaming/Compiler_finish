package Codegen.IR.IRInst;
import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRType.IRPointerType;
import Codegen.IR.IRValue.Entity;

public class IRGetInst extends IRInst {
    public Entity dest, ptr;
    public Entity offset;
    public Boolean is_class = false;
    public IRGetInst(Entity dest, Entity ptr, Entity offset, Boolean is_class) {
        super();
        this.dest = dest;
        this.ptr = ptr;
        this.offset = offset;
        this.is_class = is_class;
        assert ptr.type instanceof IRPointerType;
    }
    public String toString() { return dest.toString() + " = get " + ptr.toString() + ", " + offset.toString(); }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
