package Semantic.Frontend;

import java.util.ArrayList;

import Semantic.AST.ASTVisitor;
import Semantic.AST.Node.*;
import Utils.position;
import Utils.error.SemanticError;

public class SemanticChecker extends ASTVisitor
{
    public Global_Scope global_scope;
    public Scope current_scope;
    public ClassDefNode current_class=null;
    public ArrayList<FuncDefNode> current_func=new ArrayList<>();
    public int dep=0;
    public SemanticChecker(Global_Scope _global_scope) {
        global_scope=_global_scope;
        current_scope=new Scope(null);
    }
    public FuncDefNode current_func() {
        return current_func.get(current_func.size() - 1);
    }
    boolean cmp(position a, position b) {//a在b前面
        return a.row!=b.row ? a.row < b.row : a.col < b.col;
    }

    public void visit(RootNode it)
    {
        it.variable_list.forEach(i -> i.accept(this));
        it.class_list.forEach(i -> i.accept(this));
        boolean flag=false;
        //判断main函数
        for (var tmp:it.function_list) {
            if (tmp.id.equals("main")) {
                if (flag) throw new SemanticError(tmp.pos, "Invalid main()!");
                flag=true;
                if (!tmp.return_type.equals("int")) throw new SemanticError(tmp.pos, "Invalid main()!");
                if (tmp.variable_list.size()!=0)  throw new SemanticError(tmp.pos, "Invalid main()!");
            }
        }
        if (!flag) throw new SemanticError(it.pos, "Invalid main()!");
        it.function_list.forEach(i -> i.accept(this));
    }

    public void visit(VarDefStmtNode it) {
        if (global_scope.get_type(it.type)==null) throw new SemanticError(it.pos, "Invalid VarDef!");
        for (var i : it.variable_list) {
            i.accept(this);
            i.type=it.type;
            i.dim=it.dim;
        }
    }
    
    public void visit(OneVarDefStmtNode it) {
        if (global_scope.find_type(it.id)) throw new SemanticError(it.pos, "Invalid VarDef!");// 类不可以与变量重名
        if (current_scope.get_var(it.id, false)!=null) throw new SemanticError(it.pos, "Invalid VarDef!");//同一定义域重复定义
        if (it.init_val!= null) it.init_val.accept(this);
        current_scope.insert_var(it.id, it);
        if (current_class!=null && current_func.size()==0) {
            it.belong_class=current_class;
            it.offset_in_class=current_class.now_offset++; //在类中的地址
        }
    }

    public void visit(ClassDefNode it) {
        current_class=it;
        current_scope=new Scope(current_scope);
        it.variable_list.forEach(i -> i.accept(this));
        it.function_list.forEach(i -> i.accept(this));
        current_scope=current_scope.parent_scope;
        current_class=null;
    }

    public void visit(FuncDefNode it) {
        if (global_scope.get_type(it.return_type)==null) throw new SemanticError(it.pos, "Invalid FuncDef");
        current_scope=new Scope(current_scope);
        current_func.add(it);
        it.variable_list.forEach(i -> i.accept(this));  
        if (it.stmt!=null) it.stmt.accept(this);
        if (!it.return_type.equals("void") && !it.id.equals("main") && !it.is_returned) {
            if (current_class==null || !current_class.id.equals(current_func().id)) throw new SemanticError(it.pos, "Function has no return");
        }
        it.is_returned=false;
        it.belong_class=current_class;
        if (current_class!=null && current_class.id.equals(current_func().id))  current_class.construction=it;
        current_func.remove(current_func.size() - 1);
        current_scope=current_scope.parent_scope;
    }

    public void visit(FuncVarDefNode it) {
        if (global_scope.get_type(it.type)==null) throw new SemanticError(it.pos, "Invalid FunVarDef!");
        it.func_var.accept(this);
        it.func_var.type=it.type;
        it.func_var.dim=it.dim;
    }

    public void visit(PartStmtNode it) {
        current_scope=new Scope(current_scope);
        it.stmt_list.forEach(i -> i.accept(this));
        current_scope=current_scope.parent_scope;
    }

    public void visit(IfStmtNode it) {
        it.if_condition_expr.accept(this);
        if (!it.if_condition_expr.type.equals("bool")) throw new SemanticError(it.if_condition_expr.pos, "Invalid IfStmt");
        current_scope=new Scope(current_scope);
        it.true_stmt.accept(this);
        current_scope=current_scope.parent_scope;
        if (it.false_stmt!=null) {
            current_scope=new Scope(current_scope);
            it.false_stmt.accept(this);
            current_scope=current_scope.parent_scope;
        }
    }
    public void visit(ForStmtNode it) {
        current_scope=new Scope(current_scope);
        dep++;
        if (it.var!=null) it.var.accept(this);
        if (it.init_expr!=null) it.init_expr.accept(this);
        if (it.for_condition_expr!=null) { it.for_condition_expr.accept(this);if (!it.for_condition_expr.type.equals("bool")) throw new SemanticError(it.pos, "Invalid ForStmt");}
        if (it.step_expr!= null) it.step_expr.accept(this);
        it.body.accept(this);
        dep--;
        current_scope=current_scope.parent_scope;
    }
    public void visit(WhileStmtNode it)
    {
        current_scope=new Scope(current_scope);
        dep++;
        it.while_condition_expr.accept(this);
        it.body.accept(this);
        dep--;
        current_scope=current_scope.parent_scope;
    }
    public void visit(ReturnStmtNode it) {
        if (it.expr!=null) {
            it.expr.accept(this);
            if (current_func().return_type!=null) {
                if (current_class!=null && current_func().id.equals(current_class.id))  throw new SemanticError(it.pos, "Invalid return");
                if (!it.expr.type.equals("null") && !it.expr.type.equals(current_func().return_type))  throw new SemanticError(it.pos, "Invalid return");
                if (!it.expr.type.equals("null") && it.expr.dim!=current_func().dim)  throw new SemanticError(it.pos, "Invalid return");
            } else {
                current_func().return_type=it.expr.type;
                current_func().dim=it.expr.dim;
            }
        }
        else {
            if (current_func().return_type!=null) {
                if (!current_func().return_type.equals("void")) {
                    if (current_class==null || !current_class.id.equals(current_func().id)) throw new SemanticError(it.pos, "Invalid return");
                }
            } else current_func().return_type="null";
        }
        current_func().is_returned=true;
    }

    public void visit(ContinueStmtNode it) { if (dep==0) throw new SemanticError(it.pos, "Invalid continue");}
    public void visit(BreakStmtNode it) { if (dep==0) throw new SemanticError(it.pos, "Invalid break");}
    public void visit(ExprStmtNode it) {it.expr.accept(this);}
    public void visit(SemiStmtNode it) {}


    public void visit(PrimaryExprNode it) {
        if (it.atom_type== 0) { //id
            OneVarDefStmtNode tmp_var=current_scope.get_var(it.s, true);
            if (tmp_var!=null && cmp(it.pos, tmp_var.pos)) tmp_var=null;//定义在变量后
            if (current_class!=null) {
                OneVarDefStmtNode var_in_class=current_class.variable_map.containsKey(it.s) ? current_class.variable_map.get(it.s) : null;
                if (tmp_var==null) tmp_var=var_in_class; else if (var_in_class!=null && cmp(tmp_var.pos, current_class.pos)) tmp_var=var_in_class;
            }
            it.var_symbol=tmp_var;//处理了局部变量

            FuncDefNode tmp_func=global_scope.get_func(it.s);
            if (current_class!=null && current_class.function_map.containsKey(it.s)) tmp_func=current_class.function_map.get(it.s);

            ClassDefNode tmp_class=global_scope.get_type(it.s);

            if (tmp_var!=null && tmp_func!=null) {//变量和函数可能重名
                it.type=tmp_var.type;
                it.dim=tmp_var.dim;
                it.is_left_val=true;
                it.func_symbol=tmp_func;
            } else if (tmp_var!=null) {
                it.type=tmp_var.type;
                it.dim=tmp_var.dim;
                it.is_left_val=true;
            } else if (tmp_class!=null) {
                it.type=tmp_class.id;
                it.tobe_left_val=true;
                it.class_symbol=tmp_class;
            } else if (tmp_func!=null) {
                it.type=tmp_func.return_type;
                it.func_symbol=tmp_func;
            } else throw new SemanticError(it.pos, "Invalid ID");
        }
        if (it.atom_type==1)  it.type="int";
        if (it.atom_type==2)  it.type="null";
        if (it.atom_type==3) {
            if (current_class==null) throw new SemanticError(it.pos, "Invalid This");
            it.type=current_class.id;
        }
        if (it.atom_type==4 || it.atom_type==5) it.type="bool";
        if (it.atom_type==6) it.type="string";
    }



    public void visit(ArrExprNode it) {
        it.base.accept(this);
        if (!it.base.is_left_val)
            if (it.base.class_symbol!=null || it.base.func_symbol!=null) throw new SemanticError(it.base.pos, "Invalid ArrayExpr");
        if (it.base.tobe_left_val)  throw new SemanticError(it.base.pos, "Invalid ArrayExpr");
        if (it.base.dim==0) throw new SemanticError(it.base.pos, "Invalid ArrayExpr");
        it.offset.accept(this);
        if (!it.offset.type.equals("int") || it.offset.dim!=0)  throw new SemanticError(it.base.pos, "Invalid ArrayExpr");
        it.type=it.base.type;
        it.dim=it.base.dim - 1;
        it.is_left_val=it.base.is_left_val;
    }

    public void visit(BracketExprNode it) {
        it.expr.accept(this);
        it.type=it.expr.type;
        it.dim=it.expr.dim;
        it.is_left_val=it.expr.is_left_val;
        if (it.expr.tobe_left_val) it.is_left_val=true;
        else {
            if (it.expr.class_symbol!=null) throw new SemanticError(it.pos, "Invalid BracketExpr");
            if (!it.expr.is_left_val && it.expr.func_symbol!=null) throw new SemanticError(it.pos, "Invalid BracketExpr");
        }
    }


    public void visit(NewExprNode it) {
        it.new_type=global_scope.get_type(it.type);
        if (it.new_type== null) throw new SemanticError(it.pos, "Invalid new");
        for (var i : it.expr) {
            i.accept(this);
            if ((!i.is_left_val && i.func_symbol!=null) || i.class_symbol!=null || i.dim!=0 || !i.type.equals("int"))
                throw new SemanticError(i.pos, "array size is not int");//!
        }
        it.tobe_left_val=true;
    }


    public void visit(FuncExprNode it) {
        it.obj.accept(this);
        if (it.obj.class_symbol==null && it.obj.func_symbol==null) throw new SemanticError(it.pos, "Invalid FuncExpr");

        FuncDefNode func;
        if (it.obj.class_symbol!=null) func=it.obj.class_symbol.function_list.get(0);else func=it.obj.func_symbol;
        if (func.variable_list.size()!=it.para.size()) throw new SemanticError(it.pos, "Invalid FuncExpr");

        it.func=func;
        it.para.forEach(i -> i.accept(this));
        for (var i=0; i < func.variable_list.size(); i++) {
            if (it.para.get(i).class_symbol!=null) throw new SemanticError(it.para.get(i).pos, "Invalid FuncExpr");
            if (!it.para.get(i).is_left_val && it.para.get(i).func_symbol!=null) throw new SemanticError(it.para.get(i).pos, "Invalid FuncExpr");
            if (!it.para.get(i).type.equals("null") && !func.variable_list.get(i).type.equals(it.para.get(i).type)) throw new SemanticError(it.pos, "Invalid FuncExpr");
            if (!it.para.get(i).type.equals("null") && func.variable_list.get(i).dim!=it.para.get(i).dim) throw new SemanticError(it.pos, "Invalid FuncExpr");
        }

        if (it.obj.class_symbol!=null) {
            it.type=it.obj.class_symbol.id;
            it.is_left_val=true;
        } else {
            it.type=it.obj.func_symbol.return_type;
            it.dim=it.obj.func_symbol.dim;
        }
    }

    public void visit(ClassExprNode it) {//a.b 也可以构成 a.b()
        it.obj.accept(this);
        if (it.obj.class_symbol!=null || (!it.obj.is_left_val && it.obj.func_symbol!=null)) throw new SemanticError(it.pos, "Invalid ClassExpr");
        ClassDefNode cls=global_scope.get_type(it.obj.type);
        if (it.obj.dim==0) {
            if (cls.variable_map.containsKey(it.id)) {
                it.var_symbol=cls.variable_map.get(it.id);
                it.type=it.var_symbol.type;
                it.dim=it.var_symbol.dim;
                it.is_left_val=true;
            } else if (cls.function_map.containsKey(it.id)) {
                it.func_symbol=cls.function_map.get(it.id);
                it.type=it.func_symbol.return_type;
                it.dim=it.func_symbol.dim;
            } else throw new SemanticError(it.pos, "Invalid ClassExpr");
        } else if (it.id.equals("size")) {
            it.func_symbol=global_scope.get_func("__builtin_size");
            it.type="int";
        } else throw new SemanticError(it.pos, "Invalid ClassExpr");
    }

    public void visit(PrefixExprNode it) {
        it.src.accept(this);
        if (!it.src.type.equals("int") && !it.src.type.equals("bool")) throw new SemanticError(it.pos, "Invalid PrefixExpr");
        if (!it.op.equals("!") && !it.src.type.equals("int")) throw new SemanticError(it.pos, "Invalid PrefixExpr");
        if (it.op.equals("!") && !it.src.type.equals("bool")) throw new SemanticError(it.pos, "Invalid PrefixExpr");
        if (it.op.equals("++") || it.op.equals("--")) {
            if (!it.src.is_left_val) throw new SemanticError(it.pos, "Invalid PrefixExpr");
            it.is_left_val=true;
        }
        it.type=it.src.type;
        it.dim=it.src.dim;
    }

    public void visit(SuffixExprNode it) {
        it.src.accept(this);
        if (!it.src.is_left_val) throw new SemanticError(it.pos, "Invalid SuffixExpr");
        if (!it.src.type.equals("int")) throw new SemanticError(it.pos, "Invalid SuffixExpr");
        it.type="int";
        it.dim=it.src.dim;
    }

    public void visit(BinaryExprNode it) {
        it.src1.accept(this);
        if (it.src1.class_symbol!=null) throw new SemanticError(it.src1.pos, "Invalid BinaryExpr");
        if (!it.src1.is_left_val && it.src1.func_symbol!=null) throw new SemanticError(it.src1.pos, "Invalid BinaryExpr");
        it.src2.accept(this);
        if (it.src2.class_symbol!=null) throw new SemanticError(it.src2.pos, "Invalid BinaryExpr");
        if (!it.src2.is_left_val && it.src2.func_symbol!=null) throw new SemanticError(it.src2.pos, "Invalid BinaryExpr");
        if (it.op.equals("==") || it.op.equals("!=")) {
            if (!it.src1.type.equals(it.src2.type) && !it.src2.type.equals("null")) throw new SemanticError(it.pos, "Invalid BinaryExpr");
            if (it.src1.dim!=it.src2.dim && !it.src2.type.equals("null")) throw new SemanticError(it.pos, "Invalid BinaryExpr");

            it.type="bool";
        } else {
            if (!it.src1.type.equals(it.src2.type)) throw new SemanticError(it.pos, "Invalid BinaryExpr");
            if (it.src1.dim!=it.src2.dim) throw new SemanticError(it.pos, "Invalid BinaryExpr");
            if (it.src1.type.equals("bool")) {
                if (it.op.equals("<=") || it.op.equals(">=") || it.op.equals("<") || it.op.equals(">")) throw new SemanticError(it.pos,"Invalid BinaryExpr");
            } else if (it.src1.type.equals("string")) {
                if (!it.op.equals("+") && !it.op.equals("<=") && !it.op.equals(">=") && !it.op.equals("<") && !it.op.equals(">")) throw new SemanticError(it.pos, "Invalid BinaryExpr");
            } else if (!it.src1.type.equals("int")) throw new SemanticError(it.pos, "Invalid BinaryExpr");

            if (it.op.equals("<=") || it.op.equals(">=") || it.op.equals("<") || it.op.equals(">")) it.type="bool";else it.type=it.src1.type;
            it.dim=it.src1.dim;
        }
    }

    public void visit(AssignExprNode it) {
        it.src1.accept(this);
        it.src2.accept(this);
        if (!it.src1.is_left_val) throw new SemanticError(it.src1.pos, "Invalid AssignExpr");
        if (it.src2.class_symbol!=null) throw new SemanticError(it.src2.pos, "Invalid AssignExpr");
        if (!it.src2.is_left_val && it.src2.func_symbol!=null) throw new SemanticError(it.src2.pos, "Invalid AssignExpr");
        if (!it.src2.type.equals("null") && !it.src1.type.equals(it.src2.type)) throw new SemanticError(it.pos, "Invalid AssignExpr");
        if (!it.src2.type.equals("null") && it.src1.dim!=it.src2.dim) throw new SemanticError(it.pos, "Invalid AssignExpr");
        if (it.src1.dim==0) {
            if (it.src1.type.equals("int") && it.src2.type.equals("null")) throw new SemanticError(it.pos, "Invalid AssignExpr");
            if (it.src1.type.equals("bool") && it.src2.type.equals("null")) throw new SemanticError(it.pos, "Invalid AssignExpr");
            if (it.src1.type.equals("string") && it.src2.type.equals("null")) throw new SemanticError(it.pos, "Invalid AssignExpr");
            if (it.src1.type.equals("void") && it.src2.type.equals("null")) throw new SemanticError(it.pos, "Invalid AssignExpr");
        }
        it.type=it.src1.type;
        it.dim=it.src1.dim;
        it.is_left_val=true;
    }
    public void visit(LambdaExprNode it) {
        if (it.variable_list.size()!=it.para.size()) throw new SemanticError(it.pos, "Invalid Lambda");
        current_scope=new Scope(current_scope);
        it.variable_list.forEach(i -> i.accept(this));
        it.para.forEach(i -> i.accept(this));
        for (var i=0; i < it.variable_list.size(); i++)
        {
            if (it.para.get(i).class_symbol!=null) throw new SemanticError(it.para.get(i).pos, "Invalid Lambda");
            if (!it.para.get(i).is_left_val && it.para.get(i).func_symbol!=null) throw new SemanticError(it.para.get(i).pos, "Invalid Lambda");
            if (!it.para.get(i).type.equals("null") && !it.variable_list.get(i).type.equals(it.para.get(i).type)) throw new SemanticError(it.pos, "Invalid Lambda");
            if (!it.para.get(i).type.equals("null") && it.variable_list.get(i).dim!=it.para.get(i).dim) throw new SemanticError(it.pos, "Invalid Lambda");
        }
        FuncDefNode lambda=new FuncDefNode(it.pos, 0, null, "__lambda_" + it.pos.toString(), null);
        current_func.add(lambda);
        it.st.accept(this);
        if (!lambda.is_returned) throw new SemanticError(it.pos, "Invalid Lambda");
        it.type=lambda.return_type;
        it.dim=lambda.dim;
        current_func.remove(current_func.size() - 1);
        current_scope=current_scope.parent_scope;
    }
}