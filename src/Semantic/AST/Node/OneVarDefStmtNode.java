package Semantic.AST.Node;

import Codegen.IR.IRValue.Entity;
import Codegen.IR.IRValue.Register;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class OneVarDefStmtNode extends ASTNode
{
    public String id;

    public String type;
    public int dim;
    public ExprNode init_val;

    public ClassDefNode belong_class= null;
    public Integer offset_in_class= 0;

    // IR
    public Entity val = null;
    public Register ptr = null;

    public OneVarDefStmtNode(position pos, String id, ExprNode init_val)
    {
        super(pos);
        this.id = id;
        this.init_val = init_val;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
