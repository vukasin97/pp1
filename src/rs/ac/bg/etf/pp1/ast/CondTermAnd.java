// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class CondTermAnd extends CondTerm {

    private CondFactInTerm CondFactInTerm;
    private CondTerm CondTerm;

    public CondTermAnd (CondFactInTerm CondFactInTerm, CondTerm CondTerm) {
        this.CondFactInTerm=CondFactInTerm;
        if(CondFactInTerm!=null) CondFactInTerm.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondFactInTerm getCondFactInTerm() {
        return CondFactInTerm;
    }

    public void setCondFactInTerm(CondFactInTerm CondFactInTerm) {
        this.CondFactInTerm=CondFactInTerm;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactInTerm!=null) CondFactInTerm.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactInTerm!=null) CondFactInTerm.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactInTerm!=null) CondFactInTerm.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermAnd(\n");

        if(CondFactInTerm!=null)
            buffer.append(CondFactInTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermAnd]");
        return buffer.toString();
    }
}
