package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class WhileStmtNode extends StmtNode
{
    public ExprNode while_condition_expr;
    public StmtNode body;

    public WhileStmtNode(position _pos, ExprNode _while_condition_expr, StmtNode _body)
    {
        super(_pos);
        this.while_condition_expr=_while_condition_expr;
        this.body=_body;
    }

    public void accept(ASTVisitor visitor) 
    {
        visitor.visit(this);
    }
}
