package Codegen.IR.IRValue;

import Codegen.IR.IRType.IRPointerType;
import Codegen.IR.IRType.IRType;

public class Constant extends Entity {
    public int val;
    public Constant(IRType type, int val) {
        super(type);
        this.val = val;
    }
    @Override public String toString() {
        if (type instanceof IRPointerType) return "null";
        if (type.name.equals("void")) return "";
        return Integer.toString(val);
    }
}
