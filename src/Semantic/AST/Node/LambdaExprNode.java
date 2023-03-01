package Semantic.AST.Node;

import java.util.ArrayList;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class LambdaExprNode extends ExprNode
{
    public ArrayList<FuncVarDefNode> variable_list = new ArrayList<>();
    public ArrayList<ExprNode> para = new ArrayList<>();
    public StmtNode st;

    public LambdaExprNode (position pos, StmtNode st)
    {
        super(pos);
        this.st = st;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
