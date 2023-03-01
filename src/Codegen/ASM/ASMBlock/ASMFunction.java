package Codegen.ASM.ASMBlock;

import java.util.ArrayList;

import Codegen.ASM.ASMValue.ASMAddress;
import Codegen.ASM.ASMValue.ASMVirtualRegister;

public class ASMFunction {
    public String name;
    public ArrayList<ASMBlock> blocks = new ArrayList<>();  
    public ASMVirtualRegister ra = null;
    public ArrayList<ASMVirtualRegister> callees = new ArrayList<>();
    public ArrayList<ASMAddress> para = new ArrayList<>();
    public ArrayList<ArrayList<ASMAddress> > call_func_para_rest = new ArrayList<>();
    public ASMFunction(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return name;
    }
}
