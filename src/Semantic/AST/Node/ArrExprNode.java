package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class ArrExprNode extends ExprNode {
    public ExprNode base, offset;
    public ArrExprNode(position pos, ExprNode base, ExprNode offset)
    {
        super(pos);
        this.base = base;
        this.offset = offset;
    }

    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
