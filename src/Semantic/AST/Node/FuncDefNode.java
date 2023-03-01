package Semantic.AST.Node;

import java.util.ArrayList;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class FuncDefNode extends ASTNode
{
    public String return_type;
    public String id;
    public int dim;
    public ArrayList<FuncVarDefNode> variable_list = new ArrayList<>();
    public StmtNode stmt;
    public boolean is_returned = false;
    public ClassDefNode belong_class=null;

    public FuncDefNode(position pos, int dim, String return_type, String id, StmtNode st)
    {
        super(pos);
        this.dim = dim;
        this.return_type = return_type;
        this.id = id;
        this.stmt = st;
    }

    public FuncDefNode(position pos, int dim, String return_type, String id, StmtNode st, Boolean is_returned)
    {
        super(pos);
        this.dim = dim;
        this.return_type = return_type;
        this.id = id;
        this.stmt = st;
        this.is_returned = is_returned;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
