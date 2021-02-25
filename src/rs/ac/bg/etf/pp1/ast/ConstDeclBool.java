// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclBool extends ConstDeclList {

    private Type Type;
    private SametypeConstantsBool SametypeConstantsBool;

    public ConstDeclBool (Type Type, SametypeConstantsBool SametypeConstantsBool) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.SametypeConstantsBool=SametypeConstantsBool;
        if(SametypeConstantsBool!=null) SametypeConstantsBool.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public SametypeConstantsBool getSametypeConstantsBool() {
        return SametypeConstantsBool;
    }

    public void setSametypeConstantsBool(SametypeConstantsBool SametypeConstantsBool) {
        this.SametypeConstantsBool=SametypeConstantsBool;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(SametypeConstantsBool!=null) SametypeConstantsBool.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SametypeConstantsBool!=null) SametypeConstantsBool.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SametypeConstantsBool!=null) SametypeConstantsBool.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclBool(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SametypeConstantsBool!=null)
            buffer.append(SametypeConstantsBool.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclBool]");
        return buffer.toString();
    }
}
