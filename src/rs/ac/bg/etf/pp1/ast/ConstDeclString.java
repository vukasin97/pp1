// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclString extends ConstDeclList {

    private Type Type;
    private SametypeConstantsIdent SametypeConstantsIdent;

    public ConstDeclString (Type Type, SametypeConstantsIdent SametypeConstantsIdent) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.SametypeConstantsIdent=SametypeConstantsIdent;
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public SametypeConstantsIdent getSametypeConstantsIdent() {
        return SametypeConstantsIdent;
    }

    public void setSametypeConstantsIdent(SametypeConstantsIdent SametypeConstantsIdent) {
        this.SametypeConstantsIdent=SametypeConstantsIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclString(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SametypeConstantsIdent!=null)
            buffer.append(SametypeConstantsIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclString]");
        return buffer.toString();
    }
}
