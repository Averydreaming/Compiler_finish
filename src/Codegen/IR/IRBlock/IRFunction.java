package Codegen.IR.IRBlock;

import java.util.ArrayList;

import Codegen.ASM.ASMBlock.ASMFunction;
import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRType.IRType;
import Codegen.IR.IRValue.Entity;
import Codegen.IR.IRValue.Register;

public class IRFunction
{
    public ArrayList<IRBlock> blocks= new ArrayList<>();
    public ArrayList<Entity> para=new ArrayList<>();
    public String name;
    public IRType return_type;
    public Register this_ptr=null;
    public Boolean builtin_flag=false;
    // Codegen
    public ASMFunction func=null;

    public IRFunction(IRType return_type, String name, boolean flag) {
        this.return_type=return_type;
        this.name=name;
        this.builtin_flag=flag;
    }

    public String toString() {
        String s=return_type.toString() + " @" + name;
        s += "(";
        for (int i=0; i < para.size(); i++) s += para.get(i).type.toString() + " " + para.get(i).toString() + (i == para.size() - 1 ? "" : ", ");
        s += ")";
        return s;
    }

    public String declare(boolean type)
    {
        String s=type ? "declare " : "define ";
        s += return_type.toString() + " @";
        s += name + "(";
        for (int i=0; i < para.size(); i++)
            s += para.get(i).type.toString() + " " 
              + para.get(i).toString() 
              + (i != para.size() - 1 ? ", " : "");
        s += ")";
        return s;
    }

    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
