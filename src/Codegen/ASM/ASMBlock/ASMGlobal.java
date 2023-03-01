package Codegen.ASM.ASMBlock;

import java.util.ArrayList;

import Codegen.ASM.ASMValue.ASMGlobalDefine;

public class ASMGlobal {
    public ArrayList<ASMFunction> global_functions = new ArrayList<>();
    public ArrayList<ASMGlobalDefine> global_variables = new ArrayList<>();
}
