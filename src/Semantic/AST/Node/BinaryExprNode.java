package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class BinaryExprNode extends ExprNode {
    public ExprNode src1, src2;
    public String op;
    public BinaryExprNode(position pos, String op, ExprNode src1, ExprNode src2) {
        super(pos);
        this.op = op;
        this.src1 = src1;
        this.src2 = src2;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
