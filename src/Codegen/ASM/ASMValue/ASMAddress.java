package Codegen.ASM.ASMValue;

public class ASMAddress {
    public ASMRegister base;
    public ASMImmediate offset;
    //在栈中的地址
    public ASMAddress() {
        base = ASMPhysicalRegister.phy_regs.get("sp");
        offset = null;
    }
    public ASMAddress(ASMRegister _base, ASMImmediate _offset) {
        base =_base;
        offset =_offset;
    }
    public String toString() {
        if (offset == null) return "wait";
        return offset.toString() + "(" + base.toString() + ")";
    }
}
