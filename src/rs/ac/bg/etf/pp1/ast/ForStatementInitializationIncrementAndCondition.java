// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ForStatementInitializationIncrementAndCondition extends Statement {

    private For For;
    private ForInitialization ForInitialization;
    private ForCondition ForCondition;
    private ForIteration ForIteration;
    private Statement Statement;

    public ForStatementInitializationIncrementAndCondition (For For, ForInitialization ForInitialization, ForCondition ForCondition, ForIteration ForIteration, Statement Statement) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.ForInitialization=ForInitialization;
        if(ForInitialization!=null) ForInitialization.setParent(this);
        this.ForCondition=ForCondition;
        if(ForCondition!=null) ForCondition.setParent(this);
        this.ForIteration=ForIteration;
        if(ForIteration!=null) ForIteration.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public ForInitialization getForInitialization() {
        return ForInitialization;
    }

    public void setForInitialization(ForInitialization ForInitialization) {
        this.ForInitialization=ForInitialization;
    }

    public ForCondition getForCondition() {
        return ForCondition;
    }

    public void setForCondition(ForCondition ForCondition) {
        this.ForCondition=ForCondition;
    }

    public ForIteration getForIteration() {
        return ForIteration;
    }

    public void setForIteration(ForIteration ForIteration) {
        this.ForIteration=ForIteration;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(For!=null) For.accept(visitor);
        if(ForInitialization!=null) ForInitialization.accept(visitor);
        if(ForCondition!=null) ForCondition.accept(visitor);
        if(ForIteration!=null) ForIteration.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(ForInitialization!=null) ForInitialization.traverseTopDown(visitor);
        if(ForCondition!=null) ForCondition.traverseTopDown(visitor);
        if(ForIteration!=null) ForIteration.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(ForInitialization!=null) ForInitialization.traverseBottomUp(visitor);
        if(ForCondition!=null) ForCondition.traverseBottomUp(visitor);
        if(ForIteration!=null) ForIteration.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStatementInitializationIncrementAndCondition(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForInitialization!=null)
            buffer.append(ForInitialization.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForCondition!=null)
            buffer.append(ForCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForIteration!=null)
            buffer.append(ForIteration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStatementInitializationIncrementAndCondition]");
        return buffer.toString();
    }
}
