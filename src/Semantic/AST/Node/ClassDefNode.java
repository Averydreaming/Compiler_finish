package Semantic.AST.Node;

import java.util.ArrayList;
import java.util.HashMap;

import Semantic.AST.ASTVisitor;
import Utils.position;

public class ClassDefNode extends ASTNode
{
    public String id;
    public ArrayList<FuncDefNode> function_list = new ArrayList<>();
    public ArrayList<VarDefStmtNode> variable_list = new ArrayList<>();
    public HashMap<String, FuncDefNode> function_map = new HashMap<>();
    public HashMap<String, OneVarDefStmtNode> variable_map = new HashMap<>();
    public Integer now_offset = 0;
    public FuncDefNode construction = null;

    public ClassDefNode(position pos, String _id)
    {
        super(pos);
        this.id=_id;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
