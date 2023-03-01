package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class IfStmtNode extends StmtNode
{
    public ExprNode if_condition_expr;
    public StmtNode true_stmt, false_stmt = null;

    public IfStmtNode(position pos, ExprNode condition, StmtNode true_stmt, StmtNode false_stmt)
    {
        super(pos);
        this.if_condition_expr = condition;
        this.true_stmt = true_stmt;
        this.false_stmt = false_stmt;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
