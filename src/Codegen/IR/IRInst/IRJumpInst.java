package Codegen.IR.IRInst;
import Codegen.ASM.ASMBuilder;
import Codegen.IR.IRBlock.IRBlock;
public class IRJumpInst extends IRInst {
    public IRBlock destination_block;
    public IRJumpInst(IRBlock dest_block) {
        super();
        this.destination_block = dest_block;
    }
    public String toString()
    {
        return "jp " + destination_block.tag;
    }
    public void accept(ASMBuilder visitor)
    {
        visitor.visit(this);
    }
}
