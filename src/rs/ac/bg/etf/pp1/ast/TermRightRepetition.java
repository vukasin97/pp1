// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class TermRightRepetition extends Term {

    private TermRight TermRight;
    private RightMulop1 RightMulop1;
    private Term Term;

    public TermRightRepetition (TermRight TermRight, RightMulop1 RightMulop1, Term Term) {
        this.TermRight=TermRight;
        if(TermRight!=null) TermRight.setParent(this);
        this.RightMulop1=RightMulop1;
        if(RightMulop1!=null) RightMulop1.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public TermRight getTermRight() {
        return TermRight;
    }

    public void setTermRight(TermRight TermRight) {
        this.TermRight=TermRight;
    }

    public RightMulop1 getRightMulop1() {
        return RightMulop1;
    }

    public void setRightMulop1(RightMulop1 RightMulop1) {
        this.RightMulop1=RightMulop1;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermRight!=null) TermRight.accept(visitor);
        if(RightMulop1!=null) RightMulop1.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermRight!=null) TermRight.traverseTopDown(visitor);
        if(RightMulop1!=null) RightMulop1.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermRight!=null) TermRight.traverseBottomUp(visitor);
        if(RightMulop1!=null) RightMulop1.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermRightRepetition(\n");

        if(TermRight!=null)
            buffer.append(TermRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightMulop1!=null)
            buffer.append(RightMulop1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermRightRepetition]");
        return buffer.toString();
    }
}
