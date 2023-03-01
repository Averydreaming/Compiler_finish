package Codegen.IR.IRType;

public class IRStrType extends IRType {
    public int len;
    public IRStrType(int len) {
        super("", 32);
        this.len = len;
    }

    public String toString()
    {
        return "i8*";
    }
}
