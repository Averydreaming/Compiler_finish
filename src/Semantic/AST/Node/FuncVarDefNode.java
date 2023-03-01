package Semantic.AST.Node;

import Codegen.IR.IRValue.Register;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class FuncVarDefNode extends ASTNode
{
    public String type;
    public int dim;
    public OneVarDefStmtNode func_var;
    public Register val;

    public FuncVarDefNode(position pos, String type, int dim, OneVarDefStmtNode func_var)
    {
        super(pos);
        this.type = type;
        this.dim = dim;
        this.func_var = func_var;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
