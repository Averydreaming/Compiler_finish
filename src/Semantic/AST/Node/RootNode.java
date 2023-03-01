package Semantic.AST.Node;

import java.util.ArrayList;
import Semantic.AST.ASTVisitor;
import Utils.position;

public class RootNode extends ASTNode
{
    public ArrayList<FuncDefNode> function_list = new ArrayList<>();
    public ArrayList<VarDefStmtNode> variable_list = new ArrayList<>();
    public ArrayList<ClassDefNode> class_list = new ArrayList<>();

    public RootNode(position _pos)
    {
        super(_pos);
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
