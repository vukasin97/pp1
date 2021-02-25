// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ExprAddopRight extends Expr {

    private ExprLeft ExprLeft;
    private RightAddop1 RightAddop1;
    private Expr Expr;

    public ExprAddopRight (ExprLeft ExprLeft, RightAddop1 RightAddop1, Expr Expr) {
        this.ExprLeft=ExprLeft;
        if(ExprLeft!=null) ExprLeft.setParent(this);
        this.RightAddop1=RightAddop1;
        if(RightAddop1!=null) RightAddop1.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ExprLeft getExprLeft() {
        return ExprLeft;
    }

    public void setExprLeft(ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
    }

    public RightAddop1 getRightAddop1() {
        return RightAddop1;
    }

    public void setRightAddop1(RightAddop1 RightAddop1) {
        this.RightAddop1=RightAddop1;
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
        if(ExprLeft!=null) ExprLeft.accept(visitor);
        if(RightAddop1!=null) RightAddop1.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprLeft!=null) ExprLeft.traverseTopDown(visitor);
        if(RightAddop1!=null) RightAddop1.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.traverseBottomUp(visitor);
        if(RightAddop1!=null) RightAddop1.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprAddopRight(\n");

        if(ExprLeft!=null)
            buffer.append(ExprLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightAddop1!=null)
            buffer.append(RightAddop1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprAddopRight]");
        return buffer.toString();
    }
}
