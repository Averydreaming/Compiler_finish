package Codegen.IR.IRType;

import java.util.ArrayList;

public class IRClassType extends IRType {
    public ArrayList<IRType> variable_list=new ArrayList<>();
    public IRClassType(String name)
    {
        super(name, 0);
    }

    public String toString() {
        return "%" + name;
    }
    @Override public int get_size() {
        int sz=0;
        for (int i=0; i<variable_list.size(); i++) sz=sz+variable_list.get(i).get_size();
        return sz;
    }
    public String declare() {
        String s=toString();
        s+="=type { ";
        for (int i=0; i<variable_list.size(); i++)
            s+=variable_list.get(i).toString() + ((i != variable_list.size() - 1) ? ", " : "");
        s+=" }";
        return s;
    }

    public int get_offset(int pos) {
        int ans=0;
        for (int i=0; i<pos; i++) { ans+=variable_list.get(i).get_size(); }
        return ans;
    }
}
