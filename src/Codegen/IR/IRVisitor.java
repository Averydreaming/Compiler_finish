package IR;

import Codegen.IR.IRBlock.IRBlock;
import Codegen.IR.IRBlock.IRFunction;
import Codegen.IR.IRBlock.IRGlobal;
import Codegen.IR.IRInst.*;

public interface IRVisitor {
    void visit(IRBinaryExprInst it);
    void visit(IRBranchInst it);
    void visit(IRCallInst it);
    void visit(IRCmpInst it);
    void visit(IRGetInst it);
    void visit(IRStoreInst it);
    void visit(IRRetInst it);
    void visit(IRMoveInst it);
    void visit(IRLoadInst it);
    void visit(IRJumpInst it);
    void visit(IRGlobal it);
    void visit(IRFunction it);
    void visit(IRBlock it);
}
