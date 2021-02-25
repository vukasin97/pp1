// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclNumber extends ConstDeclList {

    private Type Type;
    private SametypeConstantsNumber SametypeConstantsNumber;

    public ConstDeclNumber (Type Type, SametypeConstantsNumber SametypeConstantsNumber) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.SametypeConstantsNumber=SametypeConstantsNumber;
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public SametypeConstantsNumber getSametypeConstantsNumber() {
        return SametypeConstantsNumber;
    }

    public void setSametypeConstantsNumber(SametypeConstantsNumber SametypeConstantsNumber) {
        this.SametypeConstantsNumber=SametypeConstantsNumber;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclNumber(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SametypeConstantsNumber!=null)
            buffer.append(SametypeConstantsNumber.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclNumber]");
        return buffer.toString();
    }
}
