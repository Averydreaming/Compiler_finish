package Codegen.ASM;

import java.io.*;

import Codegen.ASM.ASMBlock.ASMBlock;
import Codegen.ASM.ASMBlock.ASMFunction;
import Codegen.ASM.ASMBlock.ASMGlobal;
import Codegen.IR.IRBlock.IRBlock;
import Codegen.IR.IRBlock.IRFunction;
import Codegen.IR.IRBlock.IRGlobal;
import Codegen.IR.IRInst.*;

public class ASMPrinter implements IR.IRVisitor {
    public PrintStream printer;
    public ASMPrinter(PrintStream printer) {
        this.printer=printer;
    }

    public void visit(ASMGlobal it) {
        printer.println("\t.text");
        printer.println("");
        it.global_functions.forEach(i -> visit(i));

        printer.println("");
        printer.println("\t.section\t.sdata,\"aw\",@progbits");

        it.global_variables.forEach(i -> {
            if (!(i.type.equals("string"))) {
                printer.println("\t.global\t" + i.name);
                printer.println("\t.p2align\t2");
            }
            printer.println("\t" + i.name + ":");
            printer.println("\t" + i.toString());
        });
    }

    public void visit(ASMFunction it) {
        printer.println("\t.globl\t" +it.name);
        printer.println("\t.p2align\t2");
        printer.println(it.toString() + ":");
        it.blocks.forEach(i -> visit(i));

    }

    public void visit(ASMBlock it) {
        printer.println(it.toString() + ":");
        it.Insts.forEach(i -> {
            printer.println("\t" + i.toString());
        });
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
    @Override public void visit(IRGlobal it) {}
    @Override public void visit(IRFunction it) {}
    @Override public void visit(IRBlock it) {

    }
}
