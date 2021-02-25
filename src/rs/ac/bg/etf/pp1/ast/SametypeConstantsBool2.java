// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class SametypeConstantsBool2 extends SametypeConstantsBool {

    private String constantIdent;
    private String boolconst;

    public SametypeConstantsBool2 (String constantIdent, String boolconst) {
        this.constantIdent=constantIdent;
        this.boolconst=boolconst;
    }

    public String getConstantIdent() {
        return constantIdent;
    }

    public void setConstantIdent(String constantIdent) {
        this.constantIdent=constantIdent;
    }

    public String getBoolconst() {
        return boolconst;
    }

    public void setBoolconst(String boolconst) {
        this.boolconst=boolconst;
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
        buffer.append("SametypeConstantsBool2(\n");

        buffer.append(" "+tab+constantIdent);
        buffer.append("\n");

        buffer.append(" "+tab+boolconst);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SametypeConstantsBool2]");
        return buffer.toString();
    }
}
