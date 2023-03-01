package Codegen.IR.IRBlock;

import java.util.ArrayList;

import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRType.IRClassType;
import Codegen.IR.IRValue.StringConstant;
import Codegen.IR.IRValue.Register;

public class IRGlobal {
    public ArrayList<Register> global_variable = new ArrayList<>();
    public ArrayList<StringConstant> global_string= new ArrayList<>();
    public ArrayList<IRFunction> global_function= new ArrayList<>();
    public ArrayList<IRClassType> global_class= new ArrayList<>();
    public IRGlobal()
    {

    }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
