// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class VariableRandomDeclarationsDerived1 extends VariableRandomDeclarations {

    private VariableRandomDeclarations VariableRandomDeclarations;
    private VarDeclList VarDeclList;

    public VariableRandomDeclarationsDerived1 (VariableRandomDeclarations VariableRandomDeclarations, VarDeclList VarDeclList) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public VariableRandomDeclarations getVariableRandomDeclarations() {
        return VariableRandomDeclarations;
    }

    public void setVariableRandomDeclarations(VariableRandomDeclarations VariableRandomDeclarations) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableRandomDeclarationsDerived1(\n");

        if(VariableRandomDeclarations!=null)
            buffer.append(VariableRandomDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableRandomDeclarationsDerived1]");
        return buffer.toString();
    }
}
