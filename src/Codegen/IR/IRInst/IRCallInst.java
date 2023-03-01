package Codegen.IR.IRInst;

import java.util.ArrayList;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRBlock.IRFunction;
import Codegen.IR.IRValue.Entity;

public class IRCallInst extends IRInst {
    public Entity dest = null;
    public IRFunction func = null;
    public ArrayList<Entity> para = new ArrayList<>();
    public IRCallInst(Entity dest, IRFunction func) {
        super();
        assert func != null;
        this.dest = dest;
        this.func = func;
    }

    @Override public String toString()
    {
        String s;
        if (dest != null && !func.return_type.name.equals("void"))
            s = dest.toString() + " = call ";
        else
            s = "call ";
        s += "@" + func.name;
        s += "(";
        for (int i = 0; i < para.size(); i++)
        {
            s += para.get(i).toString() 
            + (i == para.size() - 1 ? "" : ", ");
        }
        s += ")";
        return s;
    }

    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
