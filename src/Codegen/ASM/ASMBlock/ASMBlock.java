package Codegen.ASM.ASMBlock;
import java.util.ArrayList;
import Codegen.ASM.ASMInst.ASMInst;

public class ASMBlock {
    public String name ;
    public ArrayList<ASMInst> Insts = new ArrayList<>();
    public ASMBlock(String _name) { name = _name; }
    public String toString()
    {
        return name;
    }
}