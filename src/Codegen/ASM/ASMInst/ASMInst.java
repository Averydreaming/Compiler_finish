package Codegen.ASM.ASMInst;

import java.util.ArrayList;

import Codegen.ASM.ASMValue.ASMRegister;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

abstract public class ASMInst {
    public ArrayList<ASMRegister> read_reg = new ArrayList<>();
    public ArrayList<ASMRegister> write_reg = new ArrayList<>();
    public ASMInst() {}
    public void change(ASMVirtualRegister vir, ASMRegister phy) {}
    public String toString() {return null;}
}
