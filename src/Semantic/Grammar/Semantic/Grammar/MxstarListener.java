// Generated from C:/Users/31072/Desktop/K/Semantic/Grammar\Mxstar.g4 by ANTLR 4.10.1
package Semantic.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxstarParser}.
 */
public interface MxstarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxstarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxstarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxstarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxstarParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxstarParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxstarParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxstarParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#lambdaFunc}.
	 * @param ctx the parse tree
	 */
	void enterLambdaFunc(MxstarParser.LambdaFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#lambdaFunc}.
	 * @param ctx the parse tree
	 */
	void exitLambdaFunc(MxstarParser.LambdaFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#funcVarDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncVarDef(MxstarParser.FuncVarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#funcVarDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncVarDef(MxstarParser.FuncVarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxstarParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxstarParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#constructFuncDef}.
	 * @param ctx the parse tree
	 */
	void enterConstructFuncDef(MxstarParser.ConstructFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#constructFuncDef}.
	 * @param ctx the parse tree
	 */
	void exitConstructFuncDef(MxstarParser.ConstructFuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#oneVarDef}.
	 * @param ctx the parse tree
	 */
	void enterOneVarDef(MxstarParser.OneVarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#oneVarDef}.
	 * @param ctx the parse tree
	 */
	void exitOneVarDef(MxstarParser.OneVarDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code partstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPartstmt(MxstarParser.PartstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code partstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPartstmt(MxstarParser.PartstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDefstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDefstmt(MxstarParser.VarDefstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDefstmt(MxstarParser.VarDefstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(MxstarParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(MxstarParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(MxstarParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(MxstarParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(MxstarParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(MxstarParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnstmt(MxstarParser.ReturnstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnstmt(MxstarParser.ReturnstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinuestmt(MxstarParser.ContinuestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinuestmt(MxstarParser.ContinuestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakstmt(MxstarParser.BreakstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakstmt(MxstarParser.BreakstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprstmt(MxstarParser.ExprstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprstmt(MxstarParser.ExprstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code semistmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSemistmt(MxstarParser.SemistmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code semistmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSemistmt(MxstarParser.SemistmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(MxstarParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(MxstarParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncexpr(MxstarParser.FuncexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncexpr(MxstarParser.FuncexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixexpr(MxstarParser.PrefixexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixexpr(MxstarParser.PrefixexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryexpr(MxstarParser.PrimaryexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryexpr(MxstarParser.PrimaryexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewexpr(MxstarParser.NewexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewexpr(MxstarParser.NewexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuffixexpr(MxstarParser.SuffixexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuffixexpr(MxstarParser.SuffixexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaexpr(MxstarParser.LambdaexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaexpr(MxstarParser.LambdaexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryexpr(MxstarParser.BinaryexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryexpr(MxstarParser.BinaryexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignexpr(MxstarParser.AssignexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignexpr(MxstarParser.AssignexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprinexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprinexpr(MxstarParser.ExprinexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprinexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprinexpr(MxstarParser.ExprinexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrexpr(MxstarParser.ArrexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrexpr(MxstarParser.ArrexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterClassexpr(MxstarParser.ClassexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitClassexpr(MxstarParser.ClassexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxstarParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxstarParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(MxstarParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(MxstarParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#newType}.
	 * @param ctx the parse tree
	 */
	void enterNewType(MxstarParser.NewTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#newType}.
	 * @param ctx the parse tree
	 */
	void exitNewType(MxstarParser.NewTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(MxstarParser.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(MxstarParser.BasicTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxstarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MxstarParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxstarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MxstarParser.PrimaryContext ctx);
}