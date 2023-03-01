package Codegen.IR.IRType;

public class IRPointerType extends IRType
{
    public int dim;
    public IRType basic_type;
    public String s;

    public IRPointerType(int dim, IRType basic_type) {
        super("", 32);
        if (basic_type instanceof IRPointerType) {
            this.dim = ((IRPointerType)basic_type).dim + dim;
            this.basic_type = ((IRPointerType)basic_type).basic_type;
        } else {
            this.dim = dim;
            this.basic_type = basic_type;
        }
        s = this.basic_type.toString();
        for (int i = 0; i < this.dim; i++) s += "*";
    }

    @Override public String toString() 
    {
        return s;
    }
}
