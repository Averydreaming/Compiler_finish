package Semantic.AST;

import Semantic.AST.Node.*;
import Semantic.Grammar.MxstarBaseVisitor;
import Semantic.Grammar.MxstarParser;
import Utils.position;

public class ASTBuilder extends MxstarBaseVisitor<ASTNode>
{
    public int get_dim(String type) {
        int cnt=0,dim= 0;
        for (int i = 0; i < type.length(); i++) {
            if (type.charAt(i) == '[') cnt++;
            if (type.charAt(i) == ']') {
                cnt--;
                if (cnt == 0) dim++;
            }
        }
        return dim;
    }
    public String String_to_type(String type) {
        String ans = "";
        for (int i = 0; i < type.length(); i++) {
            if (type.charAt(i) == '[') break;
            ans += type.charAt(i);
        }
        return ans;
    }
    @Override public ASTNode visitProgram(MxstarParser.ProgramContext ctx)
    {
        RootNode res= new RootNode(new position(ctx));

        if (ctx.funcDef() != null) ctx.funcDef().forEach(i -> res.function_list.add((FuncDefNode) visit(i)));
        if (ctx.classDef() != null) ctx.classDef().forEach(i -> res.class_list.add((ClassDefNode) visit(i)));
        if (ctx.varDef() != null) ctx.varDef().forEach(i -> res.variable_list.add((VarDefStmtNode) visit(i)));
        return res;
    }

    @Override public ASTNode visitClassDef(MxstarParser.ClassDefContext ctx)
    {
        ClassDefNode res = new ClassDefNode(new position(ctx), ctx.ID().getText());
        if (ctx.constructFuncDef() != null) {
            for (var i : ctx.constructFuncDef()) {
                FuncDefNode tmp = (FuncDefNode) visit(i);
                res.function_list.add(tmp);
            }
        } else {
            PartStmtNode stmtlist= new PartStmtNode(new position(ctx));
            FuncDefNode func = new FuncDefNode(new position(ctx), 0, ctx.ID().getText(), ctx.ID().getText(), stmtlist);
            res.function_list.add(func);
        }
        if (ctx.funcDef() != null)  ctx.funcDef().forEach(i -> res.function_list.add((FuncDefNode) visit(i)));
        if (ctx.varDef() != null)   ctx.varDef().forEach(i -> res.variable_list.add((VarDefStmtNode) visit(i)));

        return res;
    }
    @Override public ASTNode visitFuncDef(MxstarParser.FuncDefContext ctx) {
        StmtNode st = (StmtNode) visit(ctx.part());
        String return_type = ctx.returnType().getText();
        FuncDefNode res = new FuncDefNode(new position(ctx), get_dim(return_type), String_to_type(return_type), ctx.ID().getText(), st);
        if (ctx.funcVarDef() != null) ctx.funcVarDef().forEach(i -> res.variable_list.add((FuncVarDefNode) visit(i)));
        return res;
    }

    @Override public ASTNode visitConstructFuncDef(MxstarParser.ConstructFuncDefContext ctx) {
        StmtNode st = (StmtNode) visit(ctx.part());
        FuncDefNode res = new FuncDefNode(new position(ctx), 0, null, ctx.ID().getText(), st);
        if (ctx.funcVarDef() != null) ctx.funcVarDef().forEach(i -> res.variable_list.add((FuncVarDefNode) visit(i)));
        return res;
    }

    @Override public ASTNode visitFuncVarDef(MxstarParser.FuncVarDefContext ctx) {
        String type = ctx.varType().getText();
        OneVarDefStmtNode one_var = (OneVarDefStmtNode) visit(ctx.oneVarDef());
        FuncVarDefNode res = new FuncVarDefNode(new position(ctx), String_to_type(type), get_dim(type), one_var);
        return res;
    }

    @Override public ASTNode visitVarDef(MxstarParser.VarDefContext ctx) {
        String type = ctx.varType().getText();
        VarDefStmtNode res = new VarDefStmtNode(new position(ctx), String_to_type(type), get_dim(type));
        if (ctx.oneVarDef() != null) ctx.oneVarDef().forEach(i -> res.variable_list.add((OneVarDefStmtNode) visit(i)));
        return res;
    }

    @Override public ASTNode visitPart(MxstarParser.PartContext ctx) {
        PartStmtNode res = new PartStmtNode(new position(ctx));
        if (ctx.stmt() != null) ctx.stmt().forEach(i -> res.stmt_list.add((StmtNode) visit(i)));
        return res;
    }

    @Override public ASTNode visitPartstmt(MxstarParser.PartstmtContext ctx) {return (PartStmtNode) visit(ctx.part());}

    @Override public ASTNode visitIfstmt(MxstarParser.IfstmtContext ctx) {
        ExprNode cond = (ExprNode) visit(ctx.expr());
        StmtNode stmt1 = (StmtNode) visit(ctx.st1);
        StmtNode stmt2 = null;
        if (ctx.st2 != null) stmt2 = (StmtNode) visit(ctx.st2);
        IfStmtNode res = new IfStmtNode(new position(ctx), cond, stmt1, stmt2);
        return res;
    }    

    @Override public ASTNode visitReturnstmt(MxstarParser.ReturnstmtContext ctx) {
        ExprNode expr = null;
        if (ctx.expr() != null) expr = (ExprNode) visit(ctx.expr());
        ReturnStmtNode res = new ReturnStmtNode(new position(ctx), expr);
        return res;
    }

    @Override public ASTNode visitWhilestmt(MxstarParser.WhilestmtContext ctx) {
        if (ctx == null) return null;
        ExprNode cond = (ExprNode) visit(ctx.expr());
        StmtNode st = (StmtNode) visit(ctx.stmt());
        WhileStmtNode res = new WhileStmtNode(new position(ctx), cond, st);
        return res;
    }

    @Override public ASTNode visitForstmt(MxstarParser.ForstmtContext ctx)  {
        if (ctx == null) return null;
        VarDefStmtNode var = null;
        ExprNode init = null, cond = null, next = null;
        if (ctx.varDef() != null)
            var = (VarDefStmtNode) visit(ctx.varDef());
        if (ctx.init != null)  init = (ExprNode) visit(ctx.init);
        if (ctx.cond != null)  cond = (ExprNode) visit(ctx.cond);
        if (ctx.next != null)  next = (ExprNode) visit(ctx.next);
        StmtNode st = (StmtNode) visit(ctx.stmt());
        ForStmtNode res = new ForStmtNode(new position(ctx), var, init, cond, next, st);
        return res;
    }

    @Override public ASTNode visitBreakstmt(MxstarParser.BreakstmtContext ctx) { return new BreakStmtNode(new position(ctx));}
    @Override public ASTNode visitContinuestmt(MxstarParser.ContinuestmtContext ctx) {return new ContinueStmtNode(new position(ctx));}
    @Override public ASTNode visitVarDefstmt(MxstarParser.VarDefstmtContext ctx) {return (VarDefStmtNode) visit(ctx.varDef());}

    @Override public ASTNode visitExprstmt(MxstarParser.ExprstmtContext ctx) {return new ExprStmtNode(new position(ctx), (ExprNode) visit(ctx.expr()));}

    @Override public ASTNode visitSemistmt(MxstarParser.SemistmtContext ctx) {return new SemiStmtNode(new position(ctx));}

    @Override public ASTNode visitOneVarDef(MxstarParser.OneVarDefContext ctx) {
        ExprNode val = null;
        if (ctx.expr() != null) val = (ExprNode) visit(ctx.expr());
        OneVarDefStmtNode res = new OneVarDefStmtNode(new position(ctx), ctx.ID().getText(), val);
        return res;
    }

    @Override public ASTNode visitPrefixexpr(MxstarParser.PrefixexprContext ctx) {
        String op = ctx.op.getText();
        ExprNode obj = (ExprNode) visit(ctx.expr());
        PrefixExprNode res = new PrefixExprNode(new position(ctx), op, obj);
        return res;
    }

    @Override public ASTNode visitClassexpr(MxstarParser.ClassexprContext ctx) {
        String idt = ctx.ID().getText();
        ExprNode obj = (ExprNode) visit(ctx.expr());
        ClassExprNode res = new ClassExprNode(new position(ctx), obj, idt);
        return res;
    }    

    @Override public ASTNode visitNewexpr(MxstarParser.NewexprContext ctx) {
        String type = ctx.newType().getText();
        NewExprNode res = new NewExprNode(new position(ctx), String_to_type(type), get_dim(type));
        ctx.newType().expr().forEach(i -> res.expr.add((ExprNode) visit(i)));
        return res;
    }

    @Override public ASTNode visitAssignexpr(MxstarParser.AssignexprContext ctx) {
        ExprNode src1 = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));
        AssignExprNode res = new AssignExprNode(new position(ctx), src1, rhs);

        return res;
    }

    @Override public ASTNode visitBinaryexpr(MxstarParser.BinaryexprContext ctx)
    {
        String op = ctx.op.getText();
        ExprNode src1 = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));

        BinaryExprNode res = new BinaryExprNode(new position(ctx), op, src1, rhs);

        return res;
    }

    @Override public ASTNode visitSuffixexpr(MxstarParser.SuffixexprContext ctx) {
        String op = ctx.op.getText();
        ExprNode obj = (ExprNode) visit(ctx.expr());
        SuffixExprNode res = new SuffixExprNode(new position(ctx), op, obj);
        return res;
    }

    @Override public ASTNode visitPrimaryexpr(MxstarParser.PrimaryexprContext ctx) {
        int type = 0;
        if (ctx.primary().Number() != null) type = 1;
        else if (ctx.primary().Null() != null) type = 2;
        else if (ctx.primary().This() != null) type = 3;
        else if (ctx.primary().True() != null) type = 4;
        else if (ctx.primary().False() != null) type = 5;
        else if (ctx.primary().ConstString() != null) type = 6;
        PrimaryExprNode res = new PrimaryExprNode(new position(ctx), type, ctx.primary().getText());
        return res;
    }

    @Override public ASTNode visitExprinexpr(MxstarParser.ExprinexprContext ctx) {
        BracketExprNode res = new BracketExprNode(new position(ctx), (ExprNode) visit(ctx.expr()));
        return res;
    }

    @Override public ASTNode visitArrexpr(MxstarParser.ArrexprContext ctx) {
        ExprNode ptr = (ExprNode) visit(ctx.expr(0));
        ExprNode offset = (ExprNode) visit(ctx.expr(1));
        ArrExprNode res = new ArrExprNode(new position(ctx), ptr, offset);
        return res;
    }

    @Override public ASTNode visitFuncexpr(MxstarParser.FuncexprContext ctx) {
        ExprNode obj = (ExprNode) visit(ctx.expr(0));
        FuncExprNode res = new FuncExprNode(new position(ctx), obj);
        for (int i = 1; i < ctx.expr().size(); i++) res.para.add((ExprNode) visit(ctx.expr(i)));
        return res;
    }


    @Override public ASTNode visitLambdaFunc(MxstarParser.LambdaFuncContext ctx) {
        LambdaExprNode res = new LambdaExprNode(new position(ctx), (StmtNode) visit(ctx.part()));
        ctx.funcVarDef().forEach(i -> res.variable_list.add((FuncVarDefNode) visit(i)));
        ctx.expr().forEach(i -> res.para.add((ExprNode) visit(i)));
        return res;
    }
}