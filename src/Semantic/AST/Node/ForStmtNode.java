package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class ForStmtNode extends StmtNode
{
    public ExprNode init_expr, for_condition_expr, step_expr;
    public VarDefStmtNode var;

    public StmtNode body;

    public ForStmtNode(position pos, VarDefStmtNode var, ExprNode init_expr, ExprNode for_condition_expr, ExprNode step_expr, StmtNode body)
    {
        super(pos);
        this.var = var;
        this.init_expr = init_expr;
        this.for_condition_expr = for_condition_expr;
        this.step_expr = step_expr;
        this.body = body;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
