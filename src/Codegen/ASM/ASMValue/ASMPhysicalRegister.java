package Codegen.ASM.ASMValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ASMPhysicalRegister extends ASMRegister {
    public static ArrayList<String> name_list = new ArrayList<>(Arrays.asList(
        "zero", "ra", "sp", "gp", "tp", "t0", "t1", "t2", "s0", "s1",
        "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
        "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11", "t3", "t4", "t5", "t6"
    ));
    public static ArrayList<Integer> type_list = new ArrayList<>(Arrays.asList(
        2, 0, 2, 2, 2, 0, 0, 0, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0
    ));
    public static HashMap<String,ASMPhysicalRegister> phy_regs = new HashMap<>();
    static { name_list.forEach(name -> phy_regs.put(name, new ASMPhysicalRegister(name)));}
    public String name;
    public ASMPhysicalRegister(String name) {
        super();
        this.name = name;
    }
    public String toString() {return name;}
}
