// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class SametypeConstants2 extends SametypeConstantsNumber {

    private String constantIdent;
    private Integer num;

    public SametypeConstants2 (String constantIdent, Integer num) {
        this.constantIdent=constantIdent;
        this.num=num;
    }

    public String getConstantIdent() {
        return constantIdent;
    }

    public void setConstantIdent(String constantIdent) {
        this.constantIdent=constantIdent;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num=num;
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
        buffer.append("SametypeConstants2(\n");

        buffer.append(" "+tab+constantIdent);
        buffer.append("\n");

        buffer.append(" "+tab+num);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SametypeConstants2]");
        return buffer.toString();
    }
}
