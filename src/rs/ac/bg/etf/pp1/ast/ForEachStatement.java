// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ForEachStatement extends Statement {

    private ForEachStart ForEachStart;
    private ForEachIdent ForEachIdent;
    private ForEachDesignator ForEachDesignator;
    private Statement Statement;

    public ForEachStatement (ForEachStart ForEachStart, ForEachIdent ForEachIdent, ForEachDesignator ForEachDesignator, Statement Statement) {
        this.ForEachStart=ForEachStart;
        if(ForEachStart!=null) ForEachStart.setParent(this);
        this.ForEachIdent=ForEachIdent;
        if(ForEachIdent!=null) ForEachIdent.setParent(this);
        this.ForEachDesignator=ForEachDesignator;
        if(ForEachDesignator!=null) ForEachDesignator.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForEachStart getForEachStart() {
        return ForEachStart;
    }

    public void setForEachStart(ForEachStart ForEachStart) {
        this.ForEachStart=ForEachStart;
    }

    public ForEachIdent getForEachIdent() {
        return ForEachIdent;
    }

    public void setForEachIdent(ForEachIdent ForEachIdent) {
        this.ForEachIdent=ForEachIdent;
    }

    public ForEachDesignator getForEachDesignator() {
        return ForEachDesignator;
    }

    public void setForEachDesignator(ForEachDesignator ForEachDesignator) {
        this.ForEachDesignator=ForEachDesignator;
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
        if(ForEachStart!=null) ForEachStart.accept(visitor);
        if(ForEachIdent!=null) ForEachIdent.accept(visitor);
        if(ForEachDesignator!=null) ForEachDesignator.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForEachStart!=null) ForEachStart.traverseTopDown(visitor);
        if(ForEachIdent!=null) ForEachIdent.traverseTopDown(visitor);
        if(ForEachDesignator!=null) ForEachDesignator.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForEachStart!=null) ForEachStart.traverseBottomUp(visitor);
        if(ForEachIdent!=null) ForEachIdent.traverseBottomUp(visitor);
        if(ForEachDesignator!=null) ForEachDesignator.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForEachStatement(\n");

        if(ForEachStart!=null)
            buffer.append(ForEachStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForEachIdent!=null)
            buffer.append(ForEachIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForEachDesignator!=null)
            buffer.append(ForEachDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForEachStatement]");
        return buffer.toString();
    }
}
