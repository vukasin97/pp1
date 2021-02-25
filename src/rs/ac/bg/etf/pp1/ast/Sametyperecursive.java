// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class Sametyperecursive extends Sametype {

    private String varName;
    private Sametype Sametype;

    public Sametyperecursive (String varName, Sametype Sametype) {
        this.varName=varName;
        this.Sametype=Sametype;
        if(Sametype!=null) Sametype.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public Sametype getSametype() {
        return Sametype;
    }

    public void setSametype(Sametype Sametype) {
        this.Sametype=Sametype;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Sametype!=null) Sametype.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Sametype!=null) Sametype.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Sametype!=null) Sametype.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Sametyperecursive(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(Sametype!=null)
            buffer.append(Sametype.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Sametyperecursive]");
        return buffer.toString();
    }
}
