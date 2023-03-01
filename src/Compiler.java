import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import Codegen.IR.IRPrinter;
import Semantic.Frontend.*;
import Semantic.AST.ASTBuilder;
import Semantic.AST.Node.RootNode;
import Semantic.Grammar.MxstarLexer;
import Semantic.Grammar.MxstarParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import Codegen.ASM.ASMBuilder;
import Codegen.ASM.ASMPrinter;
import Codegen.ASM.RegAlloc;
import Codegen.IR.IRBuilder;
import Utils.*;

import org.antlr.v4.runtime.CharStreams;

import Utils.MxStarErrorListener;


public class Compiler {
    public static void main(String[] args) throws Exception {
       // String name = "C:\\Users\\31072\\Desktop\\Compiler-2021-testcases\\codegen\\e3.mx";
       // InputStream input = new FileInputStream(name);
       // PrintStream iroutput = new PrintStream("test.ll");
        PrintStream asmoutput = new PrintStream("output.s");
        InputStream input = System.in;

        try {
            MxstarLexer lexer = new MxstarLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxStarErrorListener());

            MxstarParser parser = new MxstarParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxStarErrorListener());
            ParseTree parse_tree_root = parser.program();

            ASTBuilder ast_builder = new ASTBuilder();
            RootNode ast_root = (RootNode)ast_builder.visit(parse_tree_root);

            Global_Scope symbols = new Global_Scope();
            new SymbolCollector(symbols).visit(ast_root);
            new SemanticChecker(symbols).visit(ast_root);

            IRBuilder ir_builder = new IRBuilder();
            ir_builder.visit(ast_root);
           // IRPrinter irPrinter = new IRPrinter(iroutput);
           // irPrinter.visit(ir_builder.global);
            ASMBuilder asm_builder = new ASMBuilder();
            asm_builder.visit(ir_builder.global);
            new RegAlloc(asm_builder.ASM_global);
            ASMPrinter asmPrinter = new ASMPrinter(asmoutput);
            asmPrinter.visit(asm_builder.ASM_global);
            new BuiltinASMPrinter("builtin.s");
        }
        catch (Error err) {
            System.err.println(err.toString());
            throw new RuntimeException();
        }
    }
}
