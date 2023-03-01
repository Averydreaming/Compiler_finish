package Codegen.ASM.ASMInst;
import Codegen.ASM.ASMBlock.ASMBlock;

public class ASMJumpInst extends ASMInst {
    public ASMBlock destination_block;
    public ASMJumpInst(ASMBlock _destination_block) {
        super();
        this.destination_block=_destination_block;
    }
    public String toString()
    {
        return "j\t\t" + destination_block.toString();
    }
}
