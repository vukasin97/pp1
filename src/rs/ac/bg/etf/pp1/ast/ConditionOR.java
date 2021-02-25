// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ConditionOR extends Condition {

    private ConditionORStart ConditionORStart;
    private Condition Condition;

    public ConditionOR (ConditionORStart ConditionORStart, Condition Condition) {
        this.ConditionORStart=ConditionORStart;
        if(ConditionORStart!=null) ConditionORStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public ConditionORStart getConditionORStart() {
        return ConditionORStart;
    }

    public void setConditionORStart(ConditionORStart ConditionORStart) {
        this.ConditionORStart=ConditionORStart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionORStart!=null) ConditionORStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionORStart!=null) ConditionORStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionORStart!=null) ConditionORStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionOR(\n");

        if(ConditionORStart!=null)
            buffer.append(ConditionORStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionOR]");
        return buffer.toString();
    }
}
