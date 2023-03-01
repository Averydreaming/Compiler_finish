package Codegen.ASM.ASMValue;
//global define
public class ASMGlobalDefine extends ASMValue{
    public String name, s;
    public String type;
    public int val = 0;
    public ASMGlobalDefine(String name) {
        super();
        this.name = name;
        this.type = "void";
    }
    public String toString() {
            if (type.equals("bool"))        { return ".byte\t" + val + " ".repeat(23) + "# " + (val == 1); }
            else if (type.equals("int"))    { return ".word\t" + Integer.toUnsignedLong(val) + " ".repeat(24 - Integer.toUnsignedString(val).length()) + "# " + val; }
            else if (type.equals("string")) { return ".asciz\t\"" + s.replace("\\", "\\\\").replace("\n", "\\n").replace("\"", "\\\"") + "\""; }
            else if (type.equals("void"))   { return null;}
            return null;
    }
}
