// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class VariableRandomDeclarationsDerived4 extends VariableRandomDeclarations {

    private VariableRandomDeclarations VariableRandomDeclarations;
    private ConstDeclList ConstDeclList;

    public VariableRandomDeclarationsDerived4 (VariableRandomDeclarations VariableRandomDeclarations, ConstDeclList ConstDeclList) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public VariableRandomDeclarations getVariableRandomDeclarations() {
        return VariableRandomDeclarations;
    }

    public void setVariableRandomDeclarations(VariableRandomDeclarations VariableRandomDeclarations) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableRandomDeclarationsDerived4(\n");

        if(VariableRandomDeclarations!=null)
            buffer.append(VariableRandomDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableRandomDeclarationsDerived4]");
        return buffer.toString();
    }
}
