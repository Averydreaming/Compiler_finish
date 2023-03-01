package Semantic.Frontend;

import java.util.HashMap;

import Semantic.AST.Node.ClassDefNode;
import Semantic.AST.Node.FuncDefNode;

public class Global_Scope
{
    public HashMap<String,FuncDefNode> func_map = new HashMap<>();
    public HashMap<String,ClassDefNode> type_map = new HashMap<>();// include int/bool/null/string/class name

    public boolean find_func(String id)
    {
        return func_map.containsKey(id);
    }
    public boolean find_type(String id)
    {
        return type_map.containsKey(id);
    }

    public FuncDefNode get_func(String id)
    {
        return func_map.containsKey(id) ? func_map.get(id) : null;
    }
    public ClassDefNode get_type(String id)
    {
        return type_map.containsKey(id) ? type_map.get(id) : null;
    }

    public void insert_func(String id, FuncDefNode func)
    {
        func_map.put(id, func);
    }
    public void insert_type(String id, ClassDefNode cls)
    {
        type_map.put(id, cls);
    }

}
