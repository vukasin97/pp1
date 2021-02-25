// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDot1 extends DesignatorDot {

    private DesignatorDot DesignatorDot;
    private Expr Expr;

    public DesignatorDot1 (DesignatorDot DesignatorDot, Expr Expr) {
        this.DesignatorDot=DesignatorDot;
        if(DesignatorDot!=null) DesignatorDot.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorDot getDesignatorDot() {
        return DesignatorDot;
    }

    public void setDesignatorDot(DesignatorDot DesignatorDot) {
        this.DesignatorDot=DesignatorDot;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorDot!=null) DesignatorDot.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorDot!=null) DesignatorDot.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorDot!=null) DesignatorDot.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDot1(\n");

        if(DesignatorDot!=null)
            buffer.append(DesignatorDot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDot1]");
        return buffer.toString();
    }
}
