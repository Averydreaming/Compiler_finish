package Semantic.AST;

import Semantic.AST.Node.*;

public class ASTVisitor 
{
    public void visit(RootNode it) {}
    public void visit(ClassDefNode it) {}
    public void visit(FuncDefNode it) {}
    public void visit(FuncVarDefNode it) {}
    public void visit(OneVarDefStmtNode it) {}
    public void visit(ArrExprNode it) {}
    public void visit(AssignExprNode it) {}
    public void visit(BinaryExprNode it) {}
    public void visit(BracketExprNode it) {}
    public void visit(BreakStmtNode it) {}
    public void visit(ContinueStmtNode it) {}
    public void visit(ExprStmtNode it) {}
    public void visit(ForStmtNode it) {}
    public void visit(IfStmtNode it) {}
    public void visit(ReturnStmtNode it) {}
    public void visit(SemiStmtNode it) {}
    public void visit(PartStmtNode it) {}
    public void visit(VarDefStmtNode it) {}
    public void visit(WhileStmtNode it) {}

    public void visit(FuncExprNode it) {}
    public void visit(LambdaExprNode it) {}
    public void visit(NewExprNode it) {}
    public void visit(ClassExprNode it) {}
    public void visit(PrefixExprNode it) {}
    public void visit(PrimaryExprNode it) {}
    public void visit(SuffixExprNode it) {}
}
