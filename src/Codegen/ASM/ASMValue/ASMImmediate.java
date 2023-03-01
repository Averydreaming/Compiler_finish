package Codegen.ASM.ASMValue;

public class ASMImmediate extends ASMValue {
    public int val;
    public ASMImmediate(int val) {
        super();
        this.val = val;
    }

    public String toString()
    {
        return Integer.toString(val);
    }
}
