// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class TermRightRepetition1 extends Term {

    private TermRight TermRight;

    public TermRightRepetition1 (TermRight TermRight) {
        this.TermRight=TermRight;
        if(TermRight!=null) TermRight.setParent(this);
    }

    public TermRight getTermRight() {
        return TermRight;
    }

    public void setTermRight(TermRight TermRight) {
        this.TermRight=TermRight;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermRight!=null) TermRight.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermRight!=null) TermRight.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermRight!=null) TermRight.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermRightRepetition1(\n");

        if(TermRight!=null)
            buffer.append(TermRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermRightRepetition1]");
        return buffer.toString();
    }
}
