package Semantic.AST.Node;

import Codegen.IR.IRValue.Entity;
import Utils.position;

public abstract class ExprNode extends ASTNode {
    public String type;
    public int dim;
    public boolean is_left_val;
    public boolean tobe_left_val;
    public FuncDefNode func_symbol;
    public ClassDefNode class_symbol;
    public Entity val, ptr=null;
    public OneVarDefStmtNode var_symbol=null;

    public ExprNode(position pos) {
        super(pos);
        this.type=null;
        this.dim=0;
        this.is_left_val=false;
        this.func_symbol=null;
        this.class_symbol=null;
        this.tobe_left_val=false;
        this.val=null;
    }
}
