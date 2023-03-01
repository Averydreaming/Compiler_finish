package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class PrimaryExprNode extends ExprNode
{
    public int atom_type;
    public String s;

    public PrimaryExprNode(position pos, int _atom_type, String s)
    {
        super(pos);
        this.atom_type=_atom_type;
        this.s=s;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
