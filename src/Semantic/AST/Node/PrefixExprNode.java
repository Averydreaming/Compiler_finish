package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class PrefixExprNode extends ExprNode
{
    public String op;
    public ExprNode src;
    public PrefixExprNode(position _pos,String _op,ExprNode _src)
    {
        super(_pos);
        this.op=_op;
        this.src=_src;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
