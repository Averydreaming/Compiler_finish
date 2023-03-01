package Codegen.IR.IRInst;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRValue.Entity;
public class IRRetInst extends IRInst {
    public Entity val;
    public IRRetInst(Entity val) {
        super();
        this.val = val;
    }
    public String toString()
    {
        return "ret " + val.toString();
    }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
