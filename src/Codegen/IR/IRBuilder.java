package Codegen.IR;

import java.util.HashMap;
import java.util.Stack;

import Codegen.IR.IRBlock.IRBlock;
import Codegen.IR.IRBlock.IRFunction;
import Codegen.IR.IRBlock.IRGlobal;
import Codegen.IR.IRInst.*;
import Codegen.IR.IRType.*;
import Codegen.IR.IRValue.*;
import Semantic.AST.ASTVisitor;
import Semantic.AST.Node.*;
//所有值都有val 只有左值有ptr ptr是为了解决数组问题
public class IRBuilder extends ASTVisitor {
    public IRBlock current_block=null;
    public IRFunction current_function=null;
    public IRClassType current_class=null;
    public HashMap<String, IRType> type_map=new HashMap<>();
    public HashMap<String, IRFunction> func_map=new HashMap<>();

    public IRGlobal global;
    public HashMap<String, StringConstant> const_string=new HashMap<>();
    public Stack<IRBlock> Break_destination_stack=new Stack<>();
    public Stack<IRBlock> Continue_destination_stack=new Stack<>();
    public int reg_tot=0, str_cnt=0;
    
    public IRBuilder()
    {
        this.global=new IRGlobal();
    }

    String Define_func_name(FuncDefNode it) {
        String func_name="";
        if (it.belong_class!=null) {
            if (!it.belong_class.id.equals("string"))
                func_name=it.belong_class.id + ".";
            else
                func_name="__builtin_";
        }
        func_name += it.id;
        return func_name;
    }
    void init_IRType() {
        type_map.put("void", new IRVoidType());
        type_map.put("null", new IRPointerType(1, new IRVoidType()));
        type_map.put("bool", new IRBoolType());
        type_map.put("int", new IRIntType());
        type_map.put("string", new IRPointerType(1, new IRCharType()));
    }
    void init_func() {
        {
            IRFunction tmp_func=new IRFunction(type_map.get("void"),"__builtin_print",true);
            tmp_func.para.add(new Register(type_map.get("string"),false,"s", 0)); 
            func_map.put("print",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("void"),"__builtin_println",true);
            tmp_func.para.add(new Register(type_map.get("string"),false, "s", 0)); 
            func_map.put("println",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("void"),"__builtin_printInt",true);
            tmp_func.para.add(new Register(type_map.get("int"), false, "int", 0)); 
            func_map.put("printInt",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("void"), "__builtin_printlnInt",true);
            tmp_func.para.add(new Register(type_map.get("int"), false, "int", 0)); 
            func_map.put("printlnInt",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("int"), "__builtin_getInt",true);
            func_map.put("getInt",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("string"), "__builtin_getString",true);
            func_map.put("getString",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("string"), "__builtin_toString",true);
            tmp_func.para.add(new Register(type_map.get("int"), false, "x", 0));
            func_map.put("toString",tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("string"), "__builtin_malloc",true);
            tmp_func.para.add(new Register(type_map.get("int"), false, "size", 0));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("string"), "__builtin_str_add",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("bool"), "__builtin_str_eq",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("bool"), "__builtin_str_ne",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("bool"), "__builtin_str_gt",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("bool"), "__builtin_str_ge",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("bool"), "__builtin_str_lt",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("bool"), "__builtin_str_le",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "src1", 0));
            tmp_func.para.add(new Register(type_map.get("string"), false, "src2", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("int"), "__builtin_length",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "this", 0));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("string"), "__builtin_substring",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "this", 0));
            tmp_func.para.add(new Register(type_map.get("int"), false, "left", 1));
            tmp_func.para.add(new Register(type_map.get("int"), false, "right", 2));
            func_map.put(tmp_func.name,tmp_func);  global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("int"), "__builtin_parseInt",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "this", 0));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction tmp_func=new IRFunction(type_map.get("int"), "__builtin_ord",true);
            tmp_func.para.add(new Register(type_map.get("string"), false, "this", 0));
            tmp_func.para.add(new Register(type_map.get("int"), false, "pos", 1));
            func_map.put(tmp_func.name,tmp_func); global.global_function.add(tmp_func);
        }
        {
            IRFunction init_func=new IRFunction(type_map.get("void"), "__builtin_init",false);
            func_map.put("__builtin_init", init_func); global.global_function.add(init_func);
        }
    }

    public void visit(RootNode it) {
        init_IRType();
        //处理class 每个class建一个IRPointerType
        it.class_list.forEach(i -> {
            IRClassType tmp=new IRClassType(i.id);
            IRPointerType tmp_ptr=new IRPointerType(1,tmp);
            type_map.put(i.id,tmp_ptr);
            global.global_class.add(tmp);
        });
        //处理class里面是variable
        it.class_list.forEach(i->{
            IRClassType tmp=(IRClassType) ((IRPointerType) type_map.get(i.id)).basic_type;
            i.variable_list.forEach(j->{
                j.variable_list.forEach(k->{
                    IRType x=type_map.get(k.type);
                    if (k.dim!=0) x=new IRPointerType(k.dim,x);
                    tmp.variable_list.add(x);
                });
            });
        });
        init_func();
        //处理class里面是function，且给class的每个function 增加一个this参数
        it.class_list.forEach( i->{
            i.function_list.forEach(j -> {
                IRType x=type_map.get(j.return_type);
                if (j.dim!=0) x=new IRPointerType(j.dim,x);
                String tmp_name=Define_func_name(j);
                IRFunction tmp_func=new IRFunction(x, tmp_name,false);
                tmp_func.this_ptr=new Register(type_map.get(i.id), false, "this_ptr", reg_tot++); //给函数了一个register
                func_map.put(tmp_name, tmp_func);
                global.global_function.add(tmp_func);
            });
        });

        it.function_list.forEach(i -> {
            IRType tmp=type_map.get(i.return_type);
            if (i.dim!=0) tmp=new IRPointerType(i.dim,tmp);
            String func_name=Define_func_name(i);
            IRFunction tmp_func=new IRFunction(tmp, func_name,false);
            func_map.put(func_name, tmp_func);
            global.global_function.add(tmp_func);
        });

        current_function=func_map.get("__builtin_init");
        current_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        current_function.blocks.add(current_block);
        it.variable_list.forEach(i -> i.accept(this));//vardef
        current_block.Insts.add(new IRRetInst(new Constant(current_function.return_type, 0)));
        it.class_list.forEach(i -> i.accept(this));
        it.function_list.forEach(i -> {
            i.accept(this);
            it.variable_list.forEach(j -> j.variable_list.forEach(k -> k.val=null));
        });
    }


    public void visit(VarDefStmtNode it) {
        it.variable_list.forEach(i -> i.accept(this));
    }

    public void visit(OneVarDefStmtNode it) {
        IRType current_type=type_map.get(it.type);
        if (it.dim!=0) current_type=new IRPointerType(it.dim, current_type);
        Entity init_val=null;
        if (it.init_val!=null) { it.init_val.accept(this); init_val=it.init_val.val;}
        if (current_function.name.equals("__builtin_init")) {// 处理全局变量
            it.ptr=new Register(new IRPointerType(1, current_type), true, it.id, reg_tot++);
            if (init_val!=null) {
                if (init_val instanceof Constant) it.ptr.init_val=(Constant) init_val;
                else {
                    it.ptr.init_val=new Constant(current_type, 0);
                    current_block.Insts.add(new IRStoreInst(it.ptr, init_val));
                }
            } else it.ptr.init_val=new Constant(current_type, 0);
            global.global_variable.add(it.ptr);
        } else if (current_function!=null) {
            it.val=new Register(current_type, false, it.id, reg_tot++);
            if (init_val!=null) current_block.Insts.add(new IRMoveInst(it.val, init_val));//局部变量用move
        }
    }

    public void visit(ClassDefNode it) {
        current_class=(IRClassType) ((IRPointerType) type_map.get(it.id)).basic_type;
        it.function_list.forEach(i -> i.accept(this));
        current_class=null;
    }

    public void visit(FuncDefNode it) {
        current_function=func_map.get(Define_func_name(it));
        current_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        current_function.blocks.add(current_block);
        if (it.id.equals("main")) { current_block.Insts.add(new IRCallInst(null, func_map.get("__builtin_init"))); }
        if (current_class!=null) current_function.para.add(current_function.this_ptr);//para里加入this参数
        it.variable_list.forEach(i -> {
            i.accept(this);
            current_function.para.add(i.val);
        });
        if (it.stmt!=null) it.stmt.accept(this);
        if (!current_block.is_returned) current_block.Insts.add(new IRRetInst(new Constant(current_function.return_type, 0)));
        current_block=null;
        current_function=null;
    }

    public void visit(FuncVarDefNode it) {
        IRType type=type_map.get(it.func_var.type);
        if (it.dim!=0) type=new IRPointerType(it.dim, type);
        it.val=new Register(type, false, it.func_var.id + "_val", reg_tot++);

        it.func_var.val=it.val;
        it.func_var.ptr=null;
    }


    public void visit(PartStmtNode it) {
        it.stmt_list.forEach(i -> i.accept(this));
    }

    public void visit(SemiStmtNode it) {}

    public void visit(IfStmtNode it) {
        IRBlock  true_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        IRBlock false_block=new IRBlock(current_function.name + "_" + (current_function.blocks.size()+1));
        IRBlock  exit_block=new IRBlock(current_function.name + "_" + (current_function.blocks.size()+2));
        current_function.blocks.add(true_block);
        current_function.blocks.add(false_block);
        current_function.blocks.add(exit_block);
        it.if_condition_expr.accept(this);
        current_block.Insts.add(new IRBranchInst(it.if_condition_expr.val, true_block, false_block));
        current_block=true_block;
        it.true_stmt.accept(this);
        current_block.Insts.add(new IRJumpInst(exit_block));
        current_block=false_block;
        if (it.false_stmt!= null) it.false_stmt.accept(this);
        current_block.Insts.add(new IRJumpInst(exit_block));
        current_block=exit_block;
    }
    public void visit(ForStmtNode it) {
        IRBlock loopbody_block=new IRBlock(current_function.name+ "_" + current_function.blocks.size());
        IRBlock condition_block=new IRBlock(current_function.name+ "_"+(current_function.blocks.size()+1));
        IRBlock step_block=new IRBlock(current_function.name + "_" + (current_function.blocks.size()+2));
        IRBlock exit_block=new IRBlock(current_function.name + "_" + (current_function.blocks.size()+3));
        current_function.blocks.add(loopbody_block);
        current_function.blocks.add(condition_block);
        current_function.blocks.add(step_block);
        current_function.blocks.add(exit_block);
        Break_destination_stack.push(exit_block);
        Continue_destination_stack.push(step_block);
        if (it.init_expr != null) it.init_expr.accept(this);
        current_block.Insts.add(new IRJumpInst(condition_block));
        current_block=loopbody_block;
        if (it.body != null)  it.body.accept(this);
        current_block.Insts.add(new IRJumpInst(step_block));
        current_block=condition_block;
        if (it.for_condition_expr != null) {
            it.for_condition_expr.accept(this);
            current_block.Insts.add(new IRBranchInst(it.for_condition_expr.val, loopbody_block, exit_block));
        }
        else current_block.Insts.add(new IRJumpInst(loopbody_block));
        current_block=step_block;
        if (it.step_expr != null)  it.step_expr.accept(this);
        current_block.Insts.add(new IRJumpInst(condition_block));
        current_block=exit_block;
        Break_destination_stack.pop();
        Continue_destination_stack.pop();
    }

    public void visit(WhileStmtNode it) {
        IRBlock condition_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        IRBlock loopbody_block=new IRBlock(current_function.name + "_" + (current_function.blocks.size()+1));
        IRBlock exit_block=new IRBlock(current_function.name + "_" + (current_function.blocks.size()+2));
        current_function.blocks.add(condition_block);
        current_function.blocks.add(loopbody_block);
        current_function.blocks.add(exit_block);
        Break_destination_stack.push(exit_block);
        Continue_destination_stack.push(condition_block);
        current_block.Insts.add(new IRJumpInst(condition_block));
        current_block=condition_block;
        it.while_condition_expr.accept(this);
        current_block.Insts.add(new IRBranchInst(it.while_condition_expr.val,loopbody_block,exit_block));
        current_block =loopbody_block;
        it.body.accept(this);
        current_block.Insts.add(new IRJumpInst(condition_block));
        current_block=exit_block;
        Break_destination_stack.pop();
        Continue_destination_stack.pop();
    }

    public void visit(ReturnStmtNode it) {
        current_block.is_returned=true;
        if (it.expr!=null) {
            it.expr.accept(this);
            it.expr.val.type=current_function.return_type;
            current_block.Insts.add(new IRRetInst(it.expr.val));
        } else current_block.Insts.add(new IRRetInst(new Constant(type_map.get("void"), 0)));

        current_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        current_function.blocks.add(current_block);
    }
    public void visit(ContinueStmtNode it) {
        current_block.Insts.add(new IRJumpInst(Continue_destination_stack.peek()));
        current_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        current_function.blocks.add(current_block);
    }
    public void visit(BreakStmtNode it) {
        current_block.Insts.add(new IRJumpInst(Break_destination_stack.peek()));
        current_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
        current_function.blocks.add(current_block);
    }

    public void visit(ExprStmtNode it) {
        it.expr.accept(this);
    }


    public void visit(BracketExprNode it) {
        it.expr.accept(this);
        it.val=it.expr.val;
        it.ptr=it.expr.ptr;
        it.var_symbol=it.expr.var_symbol;//主要为了处理不在class里面的局部变量
    }
/*
 public ExprNode obj;
    public ArrayList<ExprNode> para = new ArrayList<>();
    public FuncDefNode func = null;

 */
    public void visit(FuncExprNode it) {
        it.obj.accept(this);
        if (!it.func.id.equals("__builtin_size")) {
            it.para.forEach(i -> i.accept(this));
            IRFunction tmp_func=func_map.get(Define_func_name(it.func));
            IRType tmp_type=type_map.get(it.type);
            if (it.dim!=0) tmp_type=new IRPointerType(it.dim,tmp_type);
            it.val=new Register(tmp_type, false, "call_current_val", reg_tot++);
            IRCallInst call=new IRCallInst(it.val,tmp_func);
            if (it.func.belong_class!=null) {
                Register this_val;
                if (it.obj instanceof ClassExprNode) this_val=(Register) ((ClassExprNode) it.obj).obj.val; //a.b()
                else this_val=current_function.this_ptr;//在class a 里面 b()
                call.para.add(this_val);
            }
            current_block.Insts.add(call);
            it.para.forEach(i -> call.para.add(i.val));
        } else {
            Register tmp_ptr=(Register)((ClassExprNode) it.obj).obj.val;
            it.ptr=new Register(new IRPointerType(1, new IRIntType()), false, "len_ptr", reg_tot++);
            current_block.Insts.add(new IRGetInst(it.ptr, tmp_ptr, new Constant(new IRIntType(), -1), false));
            it.val=new Register(new IRIntType(), false, "len_val", reg_tot++);
            current_block.Insts.add(new IRLoadInst(it.val, it.ptr));
        }
    }

    public void visit(ClassExprNode it) { //a.b
        it.obj.accept(this);
        if (it.func_symbol!=null) return;
        IRType tmp=type_map.get(it.type);
        if (it.dim!=0) tmp=new IRPointerType(it.dim,tmp);
        it.ptr=new Register(new IRPointerType(1,tmp), false, "obj_current_ptr", reg_tot++);
        current_block.Insts.add(new IRGetInst(it.ptr, it.obj.val, new Constant(new IRIntType(), it.var_symbol.offset_in_class), true));
        it.val=new Register(tmp,false, "obj_current_val", reg_tot++);
        current_block.Insts.add(new IRLoadInst(it.val, it.ptr));
    }

    Register get_new_array(int current_dim, NewExprNode it) {
        IRType type=type_map.get(it.type);
        //先申请这一维每一个的pointer
        Register current_array_dim_len=new Register(new IRIntType(), false, "array_len", reg_tot++);
        current_block.Insts.add(new IRBinaryExprInst(current_array_dim_len, "mul", it.expr.get(current_dim).val, new Constant(new IRIntType(), 4)));
        current_block.Insts.add(new IRBinaryExprInst(current_array_dim_len, "add", current_array_dim_len, new Constant(new IRIntType(), 4)));//计算要malloc多少个
        IRFunction malloc=func_map.get("__builtin_malloc");
        Register front=new Register(new IRPointerType(1, new IRCharType()), false, "front", reg_tot++);
        IRCallInst call_Inst=new IRCallInst(front, malloc);
        call_Inst.para.add(current_array_dim_len);
        current_block.Insts.add(call_Inst);

        current_block.Insts.add(new IRStoreInst(front, it.expr.get(current_dim).val));//第一个存大小
        current_block.Insts.add(new IRGetInst(front, front, new Constant(new IRIntType(), 1), false));

        if (current_dim==it.expr.size() - 1) return front;

        Register offset=new Register(new IRIntType(), false, "offset", reg_tot++);
        current_block.Insts.add(new IRMoveInst(offset, new Constant(new IRIntType(), 0)));

        IRBlock cond_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());current_function.blocks.add(cond_block);
        IRBlock body_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());current_function.blocks.add(body_block);
        IRBlock new_block=new IRBlock(current_function.name + "_" + current_function.blocks.size()); current_function.blocks.add(new_block);

        current_block.Insts.add(new IRJumpInst(body_block));

        current_block=body_block;
        Register current_pos=new Register(new IRPointerType(it.dim - current_dim, type), false, "current_pos", reg_tot++);
        current_block.Insts.add(new IRGetInst(current_pos, front, offset, false));
        current_block.Insts.add(new IRStoreInst(current_pos, get_new_array(current_dim + 1, it)));
        current_block.Insts.add(new IRJumpInst(cond_block));

        current_block=cond_block;
        current_block.Insts.add(new IRBinaryExprInst(offset,"add", offset, new Constant(new IRIntType(), 1)));
        Register flag=new Register(new IRBoolType(), false, "flag", reg_tot++);
        current_block.Insts.add(new IRCmpInst(flag, "eq", offset, it.expr.get(current_dim).val));
        current_block.Insts.add(new IRBranchInst(flag, new_block, body_block));

        current_block=new_block;

        return front;
    }

    public void visit(NewExprNode it) {
        it.expr.forEach(i -> i.accept(this));
        if (it.expr.size() > 0) it.val=get_new_array(0, it);
        else {
            IRType type=type_map.get(it.type);
            int size=((IRPointerType)type).basic_type.get_size();
            it.val=new Register(type, false, "class_val", reg_tot++);
            IRFunction malloc=func_map.get("__builtin_malloc");
            IRCallInst call=new IRCallInst(it.val, malloc);
            call.para.add(new Constant(new IRIntType(), size));
            current_block.Insts.add(call);
            if (it.new_type.construction!=null) {
                IRFunction func=func_map.get(Define_func_name(it.new_type.construction));
                IRCallInst call_cons=new IRCallInst(null, func);
                call_cons.para.add(it.val);
                current_block.Insts.add(call_cons);
            }
        }
    }

    public void visit(BinaryExprNode it) {
        boolean flag=it.op.equals("||") || it.op.equals("&&");
        IRType type=type_map.get(it.type);
        if (it.dim!=0) type=new IRPointerType(it.dim, type);

        if (!flag) {
            it.src1.accept(this);
            it.src2.accept(this);
            Entity lval=it.src1.val, rval=it.src2.val;
            IRType str=type_map.get("string");

            if (lval instanceof Constant && rval instanceof Constant) {
                switch (it.op) {
                    case "+" :  it.val=new Constant(type, ((Constant)lval).val + ((Constant)rval).val); break;
                    case "-" :  it.val=new Constant(type, ((Constant)lval).val - ((Constant)rval).val); break;
                    case "*" :  it.val=new Constant(type, ((Constant)lval).val * ((Constant)rval).val); break;
                    case "/" :  if (((Constant)rval).val!=0) it.val=new Constant(type, ((Constant)lval).val / ((Constant)rval).val); else  it.val=new Constant(type, 0); break;
                    case "%" :  if (((Constant)rval).val!=0) it.val=new Constant(type, ((Constant)lval).val % ((Constant)rval).val); else  it.val=new Constant(type, 0);break;
                    case "<<":  it.val=new Constant(type, ((Constant)lval).val << ((Constant)rval).val); break;
                    case ">>":  it.val=new Constant(type, ((Constant)lval).val >> ((Constant)rval).val); break;
                    case "&" :  it.val=new Constant(type, ((Constant)lval).val & ((Constant)rval).val); break;
                    case "|" :  it.val=new Constant(type, ((Constant)lval).val | ((Constant)rval).val); break;
                    case "^" :  it.val=new Constant(type, ((Constant)lval).val ^ ((Constant)rval).val); break;
                    case "==":  it.val=new Constant(type, ((Constant)lval).val==((Constant)rval).val ? 1 : 0); break;
                    case "!=":  it.val=new Constant(type, ((Constant)lval).val!=((Constant)rval).val ? 1 : 0); break;
                    case ">" :  it.val=new Constant(type, ((Constant)lval).val > ((Constant)rval).val ? 1 : 0); break;
                    case ">=":  it.val=new Constant(type, ((Constant)lval).val >= ((Constant)rval).val ? 1 : 0); break;
                    case "<" :  it.val=new Constant(type, ((Constant)lval).val < ((Constant)rval).val ?1 : 0); break;
                    case "<=":  it.val=new Constant(type, ((Constant)lval).val <= ((Constant)rval).val?1 : 0); break;
                }
            } else if (type.equals(str)) {
                switch (it.op) {
                    case "+" :
                        IRFunction string_add_func= func_map.get("__builtin_str_add");
                        it.val=new Register(type, false, "add_str", reg_tot++);
                        IRCallInst callInst= new IRCallInst(it.val,string_add_func);
                        callInst.para.add(lval);
                        callInst.para.add(rval);
                        current_block.Insts.add(callInst);
                        break;
                }
            } else if (lval.type.equals(str)) {
                IRFunction string_cmp_func=null;
                switch (it.op) {
                    case "==":
                        string_cmp_func=func_map.get("__builtin_str_eq");
                        it.val=new Register(type, false, "eq_str", reg_tot++);
                        break;
                    case "!=":
                        string_cmp_func=func_map.get("__builtin_str_ne");
                        it.val=new Register(type, false, "ne_str", reg_tot++);
                        break;
                    case ">" :
                        string_cmp_func=func_map.get("__builtin_str_gt");
                        it.val=new Register(type, false, "gt_str", reg_tot++);
                        break;
                    case ">=":
                        string_cmp_func=func_map.get("__builtin_str_ge");
                        it.val=new Register(type, false, "ge_str", reg_tot++);
                        break;
                    case "<" :
                        string_cmp_func=func_map.get("__builtin_str_lt");
                        it.val=new Register(type, false, "lt_str", reg_tot++);
                        break;
                    case "<=":
                        string_cmp_func=func_map.get("__builtin_str_le");
                        it.val=new Register(type, false, "le_str", reg_tot++);
                        break;
                }
                IRCallInst call_Inst= new IRCallInst(it.val, string_cmp_func);
                call_Inst.para.add(lval);
                call_Inst.para.add(rval);
                current_block.Insts.add(call_Inst);
            }
            else {
                if (it.op.equals("+") || it.op.equals("&") ||it.op.equals("|") || it.op.equals("^")) {
                    if (lval instanceof Constant)
                    {
                        Entity tmp=lval;
                        lval=rval;
                        rval=tmp;
                    }
                }
                switch (it.op) {
                    case "+" :  it.val=new Register(type, false, "add_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "add", lval, rval));break;
                    case "-" :  it.val=new Register(type, false, "sub_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "sub", lval, rval));break;
                    case "*" :  it.val=new Register(type, false, "mul_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "mul", lval, rval));break;
                    case "/" :  it.val=new Register(type, false, "div_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "sdiv", lval, rval));break;
                    case "%" :  it.val=new Register(type, false, "mod_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "srem", lval, rval));break;
                    case "<<":  it.val=new Register(type, false, "shl_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "shl", lval, rval));break;
                    case ">>":  it.val=new Register(type, false, "shr_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "ashr", lval, rval));break;
                    case "&" :  it.val=new Register(type, false, "and_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "and", lval, rval));break;
                    case "|" :  it.val=new Register(type, false, "or_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "or", lval, rval));break;
                    case "^" :  it.val=new Register(type, false, "xor_int", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "xor", lval, rval));break;
                    case "==":  it.val=new Register(type, false, "eq_bool", reg_tot++); current_block.Insts.add(new IRCmpInst(it.val, "eq", lval, rval));break;
                    case "!=":  it.val=new Register(type, false, "ne_bool", reg_tot++); current_block.Insts.add(new IRCmpInst(it.val, "ne", lval, rval));break;
                    case ">" :  it.val=new Register(type, false, "gt_int", reg_tot++); current_block.Insts.add(new IRCmpInst(it.val, "sgt", lval, rval));break;
                    case ">=":  it.val=new Register(type, false, "ge_int", reg_tot++); current_block.Insts.add(new IRCmpInst(it.val, "sge", lval, rval));break;
                    case "<" :  it.val=new Register(type, false, "lt_int", reg_tot++); current_block.Insts.add(new IRCmpInst(it.val, "slt", lval, rval));break;
                    case "<=":  it.val=new Register(type, false, "le_int", reg_tot++); current_block.Insts.add(new IRCmpInst(it.val, "sle", lval, rval));break;
                }

            }
        } else {
            it.src1.accept(this);
            IRBlock src2_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
            current_function.blocks.add(src2_block);
            IRBlock next_block=new IRBlock(current_function.name + "_" + current_function.blocks.size());
            current_function.blocks.add(next_block);
            Entity lval=it.src1.val;
            if (it.op.equals("&&")) {
                if (lval instanceof Constant) {
                    if (((Constant)lval).val==1) {
                        current_block.Insts.add(new IRJumpInst(src2_block));
                        current_block=src2_block;
                        it.src2.accept(this);
                        it.val=it.src2.val;
                    } else it.val=lval;
                    current_block.Insts.add(new IRJumpInst(next_block));
                } else {
                    it.val=new Register(type, false, "phi_and", reg_tot++);
                    IRBlock mid_block_1=new IRBlock(current_function.name + "_" + current_function.blocks.size());
                    current_function.blocks.add(mid_block_1);
                    current_block.Insts.add(new IRBranchInst(lval, src2_block, mid_block_1));
                    mid_block_1.Insts.add(new IRMoveInst(it.val, new Constant(type, 0)));
                    mid_block_1.Insts.add(new IRJumpInst(next_block));

                    current_block=src2_block;
                    it.src2.accept(this);
                    IRBlock mid_block_2=new IRBlock(current_function.name + "_" + current_function.blocks.size());
                    current_function.blocks.add(mid_block_2);
                    current_block.Insts.add(new IRJumpInst(mid_block_2));
                    mid_block_2.Insts.add(new IRMoveInst(it.val, it.src2.val));
                    mid_block_2.Insts.add(new IRJumpInst(next_block));
                }
            } else {
                if (lval instanceof Constant) {
                    if (((Constant)lval).val==0) {
                        current_block.Insts.add(new IRJumpInst(src2_block));
                        current_block=src2_block;
                        it.src2.accept(this);
                        it.val=it.src2.val;
                    } else it.val=lval;
                    current_block.Insts.add(new IRJumpInst(next_block));
                }
                else {
                    it.val=new Register(type, false, "phi_or", reg_tot++);
                    IRBlock mid_block_1=new IRBlock(current_function.name + "_" + current_function.blocks.size());
                    current_function.blocks.add(mid_block_1);
                    current_block.Insts.add(new IRBranchInst(lval, mid_block_1, src2_block));
                    mid_block_1.Insts.add(new IRMoveInst(it.val, new Constant(type, 1)));
                    mid_block_1.Insts.add(new IRJumpInst(next_block));

                    current_block=src2_block;
                    it.src2.accept(this);
                    IRBlock mid_block_2=new IRBlock(current_function.name + "_" + current_function.blocks.size());
                    current_function.blocks.add(mid_block_2);
                    current_block.Insts.add(new IRJumpInst(mid_block_2));
                    mid_block_2.Insts.add(new IRMoveInst(it.val, it.src2.val));
                    mid_block_2.Insts.add(new IRJumpInst(next_block));
                }
            }
            current_block=next_block;
        }
    }
    public void visit(AssignExprNode it) {
        it.src1.accept(this);
        it.src2.accept(this);
        it.var_symbol=it.src1.var_symbol;
        it.val=it.src2.val;
        it.ptr=it.src1.ptr;
        if (it.ptr!=null) current_block.Insts.add(new IRStoreInst(it.ptr, it.val));
        else if (it.var_symbol!=null) current_block.Insts.add(new IRMoveInst(it.var_symbol.val, it.val));
    }

    public void visit(PrefixExprNode it) {
        it.src.accept(this);
        it.var_symbol=it.src.var_symbol;
        Entity val=it.src.val;
        IRType type=type_map.get(it.type);
        switch (it.op){
            case "++" :
                if (val instanceof Constant)  it.val=new Constant(type, ((Constant)val).val + 1);
                else {it.val=new Register(type, false, "prefix_add", reg_tot++);current_block.Insts.add(new IRBinaryExprInst(it.val, "add", val, new Constant(type, 1)));}
                it.ptr=it.src.ptr;
                if (it.ptr!=null) current_block.Insts.add(new IRStoreInst(it.ptr, it.val)); else if (it.var_symbol!=null) current_block.Insts.add(new IRMoveInst(it.var_symbol.val, it.val));
                break;
            case "--" :
                if (val instanceof Constant) it.val=new Constant(type, ((Constant)val).val - 1);
                    else { it.val=new Register(type, false, "prefix_sub", reg_tot++);current_block.Insts.add(new IRBinaryExprInst(it.val, "sub", val, new Constant(type, 1)));}
                it.ptr=it.src.ptr;
                if (it.ptr!=null) current_block.Insts.add(new IRStoreInst(it.ptr, it.val)); else if (it.var_symbol!=null) current_block.Insts.add(new IRMoveInst(it.var_symbol.val, it.val));
                break;
            case "+" :
                it.val=val;
                break;
            case "-" :
                if (val instanceof Constant) it.val=new Constant(type, -((Constant)val).val);
                else { it.val=new Register(type, false, "prefix_zero_sub", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val, "sub", new Constant(type, 0), val)); }
                break;
            case "~" :
                if (val instanceof Constant) it.val=new Constant(type, ~((Constant)val).val);
                else { it.val=new Register(type, false, "prefix_xor", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val,"xor", new Constant(type, -1), val));}
                break;
            case "!" :
                if (val instanceof Constant) it.val=new Constant(type, ((Constant)val).val!=0 ? 1 : 0);
                else { it.val=new Register(type, false, "prefix_not_bool", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(it.val,"xor", new Constant(type, 1), val));}
                break;
        }
    }

    public void visit(SuffixExprNode it) {
        it.src.accept(this);
        it.val=it.src.val;
        IRType type=type_map.get(it.type);
        Entity val=null;
        if (it.src.ptr!=null) {
            switch (it.op) {
                case "++" : if (it.val instanceof Constant) val=new Constant(type, ((Constant)it.val).val + 1);
                            else {  val=new Register(type, false, "suffix_add", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(val,"add", it.val, new Constant(type, 1)));}
                            break;
                case "--" : if (it.val instanceof Constant) val=new Constant(type, ((Constant)it.val).val - 1);
                            else {  val=new Register(type, false, "suffix_sub", reg_tot++); current_block.Insts.add(new IRBinaryExprInst(val,"sub", it.val, new Constant(type, 1)));}
                            break;
            }
            current_block.Insts.add(new IRStoreInst(it.src.ptr, val));
        } else {
            switch (it.op) {
                case "++" :
                    if (it.val instanceof Constant) { val=new Constant(type, ((Constant)it.val).val);((Constant)it.val).val++;}
                    else {
                        val=new Register(type, false, "suffix_add", reg_tot++);
                        current_block.Insts.add(new IRMoveInst(val, it.val));
                        current_block.Insts.add(new IRBinaryExprInst(it.val,"add", it.val, new Constant(type, 1)));
                    }
                    if (it.src.var_symbol!=null) current_block.Insts.add(new IRMoveInst(it.src.var_symbol.val, it.val));
                    it.val=val;
                    break;

                case "--" :
                    if (it.val instanceof Constant) {val=new Constant(type, ((Constant)it.val).val);((Constant)it.val).val--;}
                    else {
                        val=new Register(type, false, "pre_sub", reg_tot++);
                        current_block.Insts.add((new IRMoveInst(val, it.val)));
                        current_block.Insts.add(new IRBinaryExprInst(it.val, "sub", it.val, new Constant(type, 1)));
                    }
                    if (it.src.var_symbol!=null) current_block.Insts.add(new IRMoveInst(it.src.var_symbol.val, it.val));
                    it.val=val;
                    break;
            }
        }
    }

    public void visit(PrimaryExprNode it) {
        if (it.atom_type==0) {
            if (it.func_symbol!=null) return;
            OneVarDefStmtNode tmp_var=it.var_symbol;
            IRType current_type=type_map.get(tmp_var.type);
            if (tmp_var.dim!=0) current_type=new IRPointerType(tmp_var.dim, current_type);
            if (tmp_var.belong_class!=null) {
                Entity _this=current_function.this_ptr;
                tmp_var.ptr=new Register(new IRPointerType(1, current_type), false, it.s + "_ptr", reg_tot++);
                current_block.Insts.add(new IRGetInst(tmp_var.ptr, _this, new Constant(new IRIntType(), tmp_var.offset_in_class), true));
                tmp_var.val=new Register(current_type, false, it.s + "_val", reg_tot++);
            }
            if (tmp_var.val==null) tmp_var.val=new Register(current_type, false, it.s + "_val", reg_tot++);
            it.ptr=tmp_var.ptr;
            it.val=tmp_var.val;
            if (it.ptr!=null) current_block.Insts.add(new IRLoadInst(it.val, it.ptr));
        }
        if (it.atom_type==1)  it.val=new Constant(type_map.get("int"), Integer.valueOf(it.s));
        if (it.atom_type==2)  it.val=new Constant(type_map.get("null"), 0);
        if (it.atom_type==3)  it.val=current_function.this_ptr;
        if (it.atom_type==4)  it.val=new Constant(type_map.get("bool"), 1);
        if (it.atom_type==5)  it.val=new Constant(type_map.get("bool"), 0);
        if (it.atom_type==6) {
            it.s=it.s.replace("\\\\", "\\");
            it.s=it.s.replace("\\n", "\n");
            it.s=it.s.replace("\\\"", "\"");
            it.s=it.s + "\0";
            StringConstant str;
            if (const_string.containsKey(it.s)) str=const_string.get(it.s);
            else {
                str=new StringConstant(it.s, new IRPointerType(1, new IRStrType(it.s.length() - 2)), str_cnt++);
                global.global_string.add(str);
                const_string.put(it.s, str);
            }
            it.val=new Register(new IRPointerType(1, new IRCharType()), false, "string_to_char", reg_tot++);
            current_block.Insts.add(new IRGetInst(it.val, str, new Constant(new IRIntType(), 0), true));
        }
    }

    public void visit(ArrExprNode it) {
        it.base.accept(this);
        it.offset.accept(this);
        IRType type=type_map.get(it.type);
        it.ptr=new Register(new IRPointerType(it.dim + 1, type), false, "current_ptr", reg_tot++);
        current_block.Insts.add(new IRGetInst(it.ptr, it.base.val, it.offset.val, false));
        if (it.dim==0) it.val=new Register(type, false, "current_val_last", reg_tot++);
        else it.val=new Register(new IRPointerType(it.dim, type), false, "current_val_mid", reg_tot++);
        current_block.Insts.add(new IRLoadInst(it.val, it.ptr));
    }


}
