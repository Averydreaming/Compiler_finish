package Codegen.IR.IRValue;

import Codegen.ASM.ASMValue.ASMGlobalDefine;
import Codegen.IR.IRType.IRPointerType;
import Codegen.IR.IRType.IRType;

public class Register extends Entity {
    public int num;
    public boolean is_global;
    public String id;
    public Constant init_val = null;
    public ASMGlobalDefine address;

    public Register(IRType type, boolean is_global, String id, int num) {
        super(type);
        this.num = num;
        this.is_global = is_global;
        this.id = id;
    }
    @Override public String toString()
    {
        return  (is_global ? "@" : "%") + id + "_"  + num;
    }
    public String declare() {
        String ans = toString() + " = global ";
        IRPointerType pre_type = (IRPointerType)type;
        pre_type = new IRPointerType(pre_type.dim - 1, pre_type.basic_type);
        ans += pre_type.toString() + " " + init_val.toString();
        return ans;
    }
}
