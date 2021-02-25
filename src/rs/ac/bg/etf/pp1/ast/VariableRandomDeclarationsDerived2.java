// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class VariableRandomDeclarationsDerived2 extends VariableRandomDeclarations {

    private VariableRandomDeclarations VariableRandomDeclarations;
    private AbstractClassDeclList AbstractClassDeclList;

    public VariableRandomDeclarationsDerived2 (VariableRandomDeclarations VariableRandomDeclarations, AbstractClassDeclList AbstractClassDeclList) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.setParent(this);
        this.AbstractClassDeclList=AbstractClassDeclList;
        if(AbstractClassDeclList!=null) AbstractClassDeclList.setParent(this);
    }

    public VariableRandomDeclarations getVariableRandomDeclarations() {
        return VariableRandomDeclarations;
    }

    public void setVariableRandomDeclarations(VariableRandomDeclarations VariableRandomDeclarations) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
    }

    public AbstractClassDeclList getAbstractClassDeclList() {
        return AbstractClassDeclList;
    }

    public void setAbstractClassDeclList(AbstractClassDeclList AbstractClassDeclList) {
        this.AbstractClassDeclList=AbstractClassDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.accept(visitor);
        if(AbstractClassDeclList!=null) AbstractClassDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseTopDown(visitor);
        if(AbstractClassDeclList!=null) AbstractClassDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseBottomUp(visitor);
        if(AbstractClassDeclList!=null) AbstractClassDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableRandomDeclarationsDerived2(\n");

        if(VariableRandomDeclarations!=null)
            buffer.append(VariableRandomDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractClassDeclList!=null)
            buffer.append(AbstractClassDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableRandomDeclarationsDerived2]");
        return buffer.toString();
    }
}
