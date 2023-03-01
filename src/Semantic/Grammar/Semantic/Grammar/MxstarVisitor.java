// Generated from C:/Users/31072/Desktop/K/Semantic/Grammar\Mxstar.g4 by ANTLR 4.10.1
package Semantic.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxstarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxstarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxstarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxstarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxstarParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxstarParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#lambdaFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaFunc(MxstarParser.LambdaFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#funcVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncVarDef(MxstarParser.FuncVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxstarParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#constructFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructFuncDef(MxstarParser.ConstructFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#oneVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneVarDef(MxstarParser.OneVarDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartstmt(MxstarParser.PartstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefstmt(MxstarParser.VarDefstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(MxstarParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(MxstarParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(MxstarParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstmt(MxstarParser.ReturnstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuestmt(MxstarParser.ContinuestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstmt(MxstarParser.BreakstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprstmt(MxstarParser.ExprstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code semistmt}
	 * labeled alternative in {@link MxstarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemistmt(MxstarParser.SemistmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(MxstarParser.PartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncexpr(MxstarParser.FuncexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixexpr(MxstarParser.PrefixexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryexpr(MxstarParser.PrimaryexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewexpr(MxstarParser.NewexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixexpr(MxstarParser.SuffixexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaexpr(MxstarParser.LambdaexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryexpr(MxstarParser.BinaryexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignexpr(MxstarParser.AssignexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprinexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprinexpr(MxstarParser.ExprinexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrexpr(MxstarParser.ArrexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classexpr}
	 * labeled alternative in {@link MxstarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassexpr(MxstarParser.ClassexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxstarParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(MxstarParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#newType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewType(MxstarParser.NewTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicType(MxstarParser.BasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxstarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MxstarParser.PrimaryContext ctx);
}