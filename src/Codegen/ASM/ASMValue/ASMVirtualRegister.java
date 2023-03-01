package Codegen.ASM.ASMValue;

public class ASMVirtualRegister extends ASMRegister {
    public String name;
    public ASMAddress address;
    public ASMVirtualRegister(String _name) {
        super();
        name = _name;
        address = new ASMAddress();
    }
    public String toString() 
    {
        return "(virtual)" + name;
    }
}
