// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDot2 extends DesignatorDot {

    private DesignatorDot DesignatorDot;
    private String ident;

    public DesignatorDot2 (DesignatorDot DesignatorDot, String ident) {
        this.DesignatorDot=DesignatorDot;
        if(DesignatorDot!=null) DesignatorDot.setParent(this);
        this.ident=ident;
    }

    public DesignatorDot getDesignatorDot() {
        return DesignatorDot;
    }

    public void setDesignatorDot(DesignatorDot DesignatorDot) {
        this.DesignatorDot=DesignatorDot;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident=ident;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorDot!=null) DesignatorDot.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorDot!=null) DesignatorDot.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorDot!=null) DesignatorDot.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDot2(\n");

        if(DesignatorDot!=null)
            buffer.append(DesignatorDot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+ident);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDot2]");
        return buffer.toString();
    }
}
