package Semantic.AST.Node;

import java.util.ArrayList;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class VarDefStmtNode extends StmtNode
{
    public String type;
    public int dim;
    public ArrayList<OneVarDefStmtNode> variable_list = new ArrayList<>();
    public VarDefStmtNode(position _pos, String _type, int _dim)
    {
        super(_pos);
        this.type=_type;
        this.dim=_dim;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
