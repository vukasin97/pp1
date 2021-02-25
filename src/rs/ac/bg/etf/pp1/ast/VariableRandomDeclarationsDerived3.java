// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class VariableRandomDeclarationsDerived3 extends VariableRandomDeclarations {

    private VariableRandomDeclarations VariableRandomDeclarations;
    private ClassDeclList ClassDeclList;

    public VariableRandomDeclarationsDerived3 (VariableRandomDeclarations VariableRandomDeclarations, ClassDeclList ClassDeclList) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.setParent(this);
        this.ClassDeclList=ClassDeclList;
        if(ClassDeclList!=null) ClassDeclList.setParent(this);
    }

    public VariableRandomDeclarations getVariableRandomDeclarations() {
        return VariableRandomDeclarations;
    }

    public void setVariableRandomDeclarations(VariableRandomDeclarations VariableRandomDeclarations) {
        this.VariableRandomDeclarations=VariableRandomDeclarations;
    }

    public ClassDeclList getClassDeclList() {
        return ClassDeclList;
    }

    public void setClassDeclList(ClassDeclList ClassDeclList) {
        this.ClassDeclList=ClassDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.accept(visitor);
        if(ClassDeclList!=null) ClassDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseTopDown(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableRandomDeclarations!=null) VariableRandomDeclarations.traverseBottomUp(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableRandomDeclarationsDerived3(\n");

        if(VariableRandomDeclarations!=null)
            buffer.append(VariableRandomDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclList!=null)
            buffer.append(ClassDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableRandomDeclarationsDerived3]");
        return buffer.toString();
    }
}
