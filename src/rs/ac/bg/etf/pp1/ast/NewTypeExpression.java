// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class NewTypeExpression extends Factor {

    private Type Type;
    private ExprInNewArray ExprInNewArray;

    public NewTypeExpression (Type Type, ExprInNewArray ExprInNewArray) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprInNewArray=ExprInNewArray;
        if(ExprInNewArray!=null) ExprInNewArray.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprInNewArray getExprInNewArray() {
        return ExprInNewArray;
    }

    public void setExprInNewArray(ExprInNewArray ExprInNewArray) {
        this.ExprInNewArray=ExprInNewArray;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprInNewArray!=null) ExprInNewArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprInNewArray!=null) ExprInNewArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprInNewArray!=null) ExprInNewArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewTypeExpression(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprInNewArray!=null)
            buffer.append(ExprInNewArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewTypeExpression]");
        return buffer.toString();
    }
}
