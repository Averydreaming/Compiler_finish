package Codegen.IR;

import java.io.*;

import Codegen.IR.IRBlock.IRBlock;
import Codegen.IR.IRBlock.IRFunction;
import Codegen.IR.IRBlock.IRGlobal;
import Codegen.IR.IRInst.*;
public class IRPrinter implements IR.IRVisitor {
    public PrintStream printer;
    public IRPrinter(PrintStream printer) {
        this.printer =printer;
    }
    @Override public void visit(IRBinaryExprInst it) {}
    @Override public void visit(IRBranchInst it) {}
    @Override public void visit(IRCallInst it) {}
    @Override public void visit(IRCmpInst it) {}
    @Override public void visit(IRGetInst it) {}
    @Override public void visit(IRStoreInst it) {}
    @Override public void visit(IRRetInst it) {}
    @Override public void visit(IRMoveInst it) {}
    @Override public void visit(IRLoadInst it) {}
    @Override public void visit(IRJumpInst it) {}

    public void visit(IRGlobal it) {
        it.global_class.forEach(i -> printer.println(i.declare()));
        it.global_string.forEach(i -> printer.println(i.declare()));
        it.global_variable.forEach(i -> printer.println(i.declare()));
        it.global_function.forEach(i -> {if (i.builtin_flag) printer.println(i.declare(true));});
        it.global_function.forEach(i -> {if (!i.builtin_flag) visit(i);});
    }

    public void visit(IRFunction it) {
        printer.println(it.declare(false));
        printer.println("{");
        it.blocks.forEach(i -> visit(i));
        printer.println("}");
    }

    public void visit(IRBlock block) {
        printer.println(block.toString());
        block.Insts.forEach(i -> {printer.println("\t" + i.toString());});
    }
}
