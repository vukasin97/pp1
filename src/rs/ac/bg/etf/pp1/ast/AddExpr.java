// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class AddExpr extends ExprLeft {

    private ExprLeft ExprLeft;
    private AddopLeft AddopLeft;
    private Term Term;

    public AddExpr (ExprLeft ExprLeft, AddopLeft AddopLeft, Term Term) {
        this.ExprLeft=ExprLeft;
        if(ExprLeft!=null) ExprLeft.setParent(this);
        this.AddopLeft=AddopLeft;
        if(AddopLeft!=null) AddopLeft.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public ExprLeft getExprLeft() {
        return ExprLeft;
    }

    public void setExprLeft(ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
    }

    public AddopLeft getAddopLeft() {
        return AddopLeft;
    }

    public void setAddopLeft(AddopLeft AddopLeft) {
        this.AddopLeft=AddopLeft;
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
        if(ExprLeft!=null) ExprLeft.accept(visitor);
        if(AddopLeft!=null) AddopLeft.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprLeft!=null) ExprLeft.traverseTopDown(visitor);
        if(AddopLeft!=null) AddopLeft.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.traverseBottomUp(visitor);
        if(AddopLeft!=null) AddopLeft.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddExpr(\n");

        if(ExprLeft!=null)
            buffer.append(ExprLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopLeft!=null)
            buffer.append(AddopLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddExpr]");
        return buffer.toString();
    }
}
