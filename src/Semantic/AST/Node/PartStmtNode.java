package Semantic.AST.Node;

import java.util.ArrayList;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class PartStmtNode extends StmtNode
{
    public ArrayList<StmtNode> stmt_list= new ArrayList<>();

    public PartStmtNode(position pos)
    {
        super(pos);
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
