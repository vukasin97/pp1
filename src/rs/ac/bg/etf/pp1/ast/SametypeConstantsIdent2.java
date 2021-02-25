// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class SametypeConstantsIdent2 extends SametypeConstantsIdent {

    private String constantIdent;
    private String C1;

    public SametypeConstantsIdent2 (String constantIdent, String C1) {
        this.constantIdent=constantIdent;
        this.C1=C1;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SametypeConstantsIdent2(\n");

        buffer.append(" "+tab+constantIdent);
        buffer.append("\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SametypeConstantsIdent2]");
        return buffer.toString();
    }
}
