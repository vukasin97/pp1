// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class SametypeConstantsBool1 extends SametypeConstantsBool {

    private String constantIdent;
    private String boolconst;
    private SametypeConstantsBool SametypeConstantsBool;

    public SametypeConstantsBool1 (String constantIdent, String boolconst, SametypeConstantsBool SametypeConstantsBool) {
        this.constantIdent=constantIdent;
        this.boolconst=boolconst;
        this.SametypeConstantsBool=SametypeConstantsBool;
        if(SametypeConstantsBool!=null) SametypeConstantsBool.setParent(this);
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
        if(SametypeConstantsBool!=null) SametypeConstantsBool.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SametypeConstantsBool!=null) SametypeConstantsBool.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SametypeConstantsBool!=null) SametypeConstantsBool.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SametypeConstantsBool1(\n");

        buffer.append(" "+tab+constantIdent);
        buffer.append("\n");

        buffer.append(" "+tab+boolconst);
        buffer.append("\n");

        if(SametypeConstantsBool!=null)
            buffer.append(SametypeConstantsBool.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SametypeConstantsBool1]");
        return buffer.toString();
    }
}
