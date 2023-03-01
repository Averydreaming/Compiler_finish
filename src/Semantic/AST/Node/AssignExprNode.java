package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class AssignExprNode extends ExprNode {
    public ExprNode src1;
    public ExprNode src2;
    public AssignExprNode(position pos, ExprNode src1, ExprNode src2) {
        super(pos);
        this.src1=src1;
        this.src2=src2;
    }
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
