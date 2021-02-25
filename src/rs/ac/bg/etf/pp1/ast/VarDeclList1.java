// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList1 extends VarDeclList {

    private Type Type;
    private Sametype Sametype;

    public VarDeclList1 (Type Type, Sametype Sametype) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Sametype=Sametype;
        if(Sametype!=null) Sametype.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Sametype getSametype() {
        return Sametype;
    }

    public void setSametype(Sametype Sametype) {
        this.Sametype=Sametype;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Sametype!=null) Sametype.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Sametype!=null) Sametype.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Sametype!=null) Sametype.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Sametype!=null)
            buffer.append(Sametype.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList1]");
        return buffer.toString();
    }
}
