package Semantic.Frontend;

import java.util.HashMap;

import Semantic.AST.Node.OneVarDefStmtNode;

public class Scope 
{
    public HashMap<String,OneVarDefStmtNode> variable_map=new HashMap<>();
    public Scope parent_scope;

    public Scope(Scope parent_scope)  { this.parent_scope = parent_scope;}
    public void insert_var(String id,OneVarDefStmtNode var) {variable_map.put(id,var);}
    public OneVarDefStmtNode get_var(String id, boolean flag)
    {
        if (variable_map.containsKey(id))  return variable_map.get(id);
        if (flag && parent_scope != null)  return parent_scope.get_var(id,true);
        return null;
    }
}
