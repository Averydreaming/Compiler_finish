package Semantic.Frontend;
import Semantic.AST.ASTVisitor;
import Semantic.AST.Node.*;
import Utils.position;
import Utils.error.SemanticError;
//deal global scope
public class SymbolCollector extends ASTVisitor
{
    public Global_Scope global_scope;
    public ClassDefNode current_class;

    public SymbolCollector(Global_Scope global_scope)
    {
        this.global_scope=global_scope;

        global_scope.insert_type("int", new ClassDefNode(new position(), "int"));
        global_scope.insert_type("bool", new ClassDefNode(new position(), "bool"));
        global_scope.insert_type("void", new ClassDefNode(new position(), "void"));
        //string
        ClassDefNode tmp=new ClassDefNode(new position(), "string");
        {
            tmp.function_list.add(new FuncDefNode(new position(), 0, "int", "length", null, true));
        }
        {
            FuncDefNode x=new FuncDefNode(new position(), 0, "string", "substring", null, true);
            x.variable_list.add(new FuncVarDefNode(new position(), "int", 0, new OneVarDefStmtNode(new position(), "left", null)));
            x.variable_list.add(new FuncVarDefNode(new position(), "int", 0, new OneVarDefStmtNode(new position(), "right", null)));
            tmp.function_list.add(x);
        }
        {
            tmp.function_list.add(new FuncDefNode(new position(), 0, "int", "parseInt", null, true));
            FuncDefNode x=new FuncDefNode(new position(), 0, "int", "ord", null, true);
            FuncVarDefNode pos=new FuncVarDefNode(new position(), "int", 0, new OneVarDefStmtNode(new position(), "pos", null));
            x.variable_list.add(pos);
            tmp.function_list.add(x);
        }
        
        current_class=tmp;
        tmp.accept(this);
        current_class=null;


        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "void", "print", null);
            f.variable_list.add(new FuncVarDefNode(new position(), "string", 0, new OneVarDefStmtNode(new position(), "str", null)));
            f.accept(this);
        }
        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "void", "println", null);
            f.variable_list.add(new FuncVarDefNode(new position(), "string", 0, new OneVarDefStmtNode(new position(), "str", null)));
            f.accept(this);
        }
        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "void", "printInt", null);
            f.variable_list.add(new FuncVarDefNode(new position(), "int", 0, new OneVarDefStmtNode(new position(), "n", null)));
            f.accept(this);
        }
        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "void", "printlnInt", null);
            f.variable_list.add(new FuncVarDefNode(new position(), "int", 0, new OneVarDefStmtNode(new position(), "n", null)));
            f.accept(this);
        }
        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "string", "getString", null, true);
            f.accept(this);
        }
        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "int", "getInt", null, true);
            f.accept(this);
        }
        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "string", "toString", null, true);
            f.variable_list.add(new FuncVarDefNode(new position(), "int", 0, new OneVarDefStmtNode(new position(), "i", null)));
            f.accept(this);
        }

        {
            FuncDefNode f=new FuncDefNode(new position(), 0, "int", "__builtin_size", null);
            f.accept(this);
        }
        
    }

    @Override public void visit(RootNode it) {
        it.class_list.forEach(i -> i.accept(this));
        it.function_list.forEach(i -> i.accept(this));   
    }

    @Override public void visit(ClassDefNode it) {
        if (it.id.equals("main")) throw new SemanticError(it.pos, "Wrong ClassDef");
        if (global_scope.find_type(it.id)) throw new SemanticError(it.pos, "Class symbol has been defined");
        global_scope.insert_type(it.id, it);
        current_class=it;
        it.variable_list.forEach(i -> i.accept(this));
        it.function_list.forEach(i -> i.accept(this));
        current_class=null;
    }

    @Override public void visit(FuncDefNode it) {
        if (current_class ==null) {
            if (global_scope.find_func(it.id)) throw new SemanticError(it.pos, "Function symbol has been defined");
            global_scope.insert_func(it.id, it);
        } else {
            it.belong_class=current_class;
            if (current_class.function_map.containsKey(it.id)) throw new SemanticError(it.pos, "Function symbol in class has been defined");
            if (it.id.equals(current_class.id)) {
                if (it.return_type !=null) throw new SemanticError(it.pos, "Wrong Constructor"); else it.return_type=current_class.id;
            }
            current_class.function_map.put(it.id, it);
        }
    }

    @Override  public void visit(OneVarDefStmtNode it) {
        if (current_class.variable_map.containsKey(it.id)) throw new SemanticError(it.pos, "Invalid Define");
        current_class.variable_map.put(it.id, it);
    }

    @Override public void visit(VarDefStmtNode it) {
        it.variable_list.forEach(i ->{ i.type=it.type; i.dim=it.dim; i.accept( this);});
    }
}
