package Semantic.AST.Node;

import java.util.ArrayList;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class FuncExprNode extends ExprNode
{
    public ExprNode obj;
    public ArrayList<ExprNode> para = new ArrayList<>();
    public FuncDefNode func = null;
    public FuncExprNode(position pos, ExprNode obj)
    {
        super(pos);
        this.obj = obj;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
