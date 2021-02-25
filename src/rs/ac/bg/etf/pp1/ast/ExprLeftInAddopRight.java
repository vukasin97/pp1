// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ExprLeftInAddopRight extends Expr {

    private ExprLeft ExprLeft;

    public ExprLeftInAddopRight (ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
        if(ExprLeft!=null) ExprLeft.setParent(this);
    }

    public ExprLeft getExprLeft() {
        return ExprLeft;
    }

    public void setExprLeft(ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprLeft!=null) ExprLeft.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprLeftInAddopRight(\n");

        if(ExprLeft!=null)
            buffer.append(ExprLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprLeftInAddopRight]");
        return buffer.toString();
    }
}
