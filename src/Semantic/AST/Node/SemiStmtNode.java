package Semantic.AST.Node;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class SemiStmtNode extends StmtNode
{
    public SemiStmtNode(position pos)
    {
        super(pos);
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
