// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class SametypeConstants1 extends SametypeConstantsNumber {

    private String constantIdent;
    private Integer num;
    private SametypeConstantsNumber SametypeConstantsNumber;

    public SametypeConstants1 (String constantIdent, Integer num, SametypeConstantsNumber SametypeConstantsNumber) {
        this.constantIdent=constantIdent;
        this.num=num;
        this.SametypeConstantsNumber=SametypeConstantsNumber;
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.setParent(this);
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
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SametypeConstantsNumber!=null) SametypeConstantsNumber.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SametypeConstants1(\n");

        buffer.append(" "+tab+constantIdent);
        buffer.append("\n");

        buffer.append(" "+tab+num);
        buffer.append("\n");

        if(SametypeConstantsNumber!=null)
            buffer.append(SametypeConstantsNumber.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SametypeConstants1]");
        return buffer.toString();
    }
}
