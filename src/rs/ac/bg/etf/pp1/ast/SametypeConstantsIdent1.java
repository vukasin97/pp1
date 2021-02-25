// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class SametypeConstantsIdent1 extends SametypeConstantsIdent {

    private String constantIdent;
    private String C1;
    private SametypeConstantsIdent SametypeConstantsIdent;

    public SametypeConstantsIdent1 (String constantIdent, String C1, SametypeConstantsIdent SametypeConstantsIdent) {
        this.constantIdent=constantIdent;
        this.C1=C1;
        this.SametypeConstantsIdent=SametypeConstantsIdent;
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.setParent(this);
    }

    public String getConstantIdent() {
        return constantIdent;
    }

    public void setConstantIdent(String constantIdent) {
        this.constantIdent=constantIdent;
    }

    public String getC1() {
        return C1;
    }

    public void setC1(String C1) {
        this.C1=C1;
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
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SametypeConstantsIdent!=null) SametypeConstantsIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SametypeConstantsIdent1(\n");

        buffer.append(" "+tab+constantIdent);
        buffer.append("\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        if(SametypeConstantsIdent!=null)
            buffer.append(SametypeConstantsIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SametypeConstantsIdent1]");
        return buffer.toString();
    }
}
