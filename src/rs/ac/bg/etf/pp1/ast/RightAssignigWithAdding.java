// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:43


package rs.ac.bg.etf.pp1.ast;

public class RightAssignigWithAdding extends AssignOp {

    private AddopRight AddopRight;

    public RightAssignigWithAdding (AddopRight AddopRight) {
        this.AddopRight=AddopRight;
        if(AddopRight!=null) AddopRight.setParent(this);
    }

    public AddopRight getAddopRight() {
        return AddopRight;
    }

    public void setAddopRight(AddopRight AddopRight) {
        this.AddopRight=AddopRight;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopRight!=null) AddopRight.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopRight!=null) AddopRight.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopRight!=null) AddopRight.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RightAssignigWithAdding(\n");

        if(AddopRight!=null)
            buffer.append(AddopRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RightAssignigWithAdding]");
        return buffer.toString();
    }
}
