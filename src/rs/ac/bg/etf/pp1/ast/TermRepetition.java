// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class TermRepetition extends TermRight {

    private TermRight TermRight;
    private MulopLeft MulopLeft;
    private Factor Factor;

    public TermRepetition (TermRight TermRight, MulopLeft MulopLeft, Factor Factor) {
        this.TermRight=TermRight;
        if(TermRight!=null) TermRight.setParent(this);
        this.MulopLeft=MulopLeft;
        if(MulopLeft!=null) MulopLeft.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public TermRight getTermRight() {
        return TermRight;
    }

    public void setTermRight(TermRight TermRight) {
        this.TermRight=TermRight;
    }

    public MulopLeft getMulopLeft() {
        return MulopLeft;
    }

    public void setMulopLeft(MulopLeft MulopLeft) {
        this.MulopLeft=MulopLeft;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermRight!=null) TermRight.accept(visitor);
        if(MulopLeft!=null) MulopLeft.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermRight!=null) TermRight.traverseTopDown(visitor);
        if(MulopLeft!=null) MulopLeft.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermRight!=null) TermRight.traverseBottomUp(visitor);
        if(MulopLeft!=null) MulopLeft.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermRepetition(\n");

        if(TermRight!=null)
            buffer.append(TermRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulopLeft!=null)
            buffer.append(MulopLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermRepetition]");
        return buffer.toString();
    }
}
