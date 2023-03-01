package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class ReturnStmtNode extends StmtNode
{
    public ExprNode expr;

    public ReturnStmtNode(position _pos, ExprNode _expr)
    {
        super(_pos);
        this.expr = _expr;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
