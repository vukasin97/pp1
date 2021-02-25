// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class PrintStmt extends Matched {

    private Print Print;

    public PrintStmt (Print Print) {
        this.Print=Print;
        if(Print!=null) Print.setParent(this);
    }

    public Print getPrint() {
        return Print;
    }

    public void setPrint(Print Print) {
        this.Print=Print;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Print!=null) Print.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Print!=null) Print.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Print!=null) Print.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStmt(\n");

        if(Print!=null)
            buffer.append(Print.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStmt]");
        return buffer.toString();
    }
}
