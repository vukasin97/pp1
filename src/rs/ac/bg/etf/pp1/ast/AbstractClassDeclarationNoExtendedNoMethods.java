// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDeclarationNoExtendedNoMethods extends AbstractClassDeclList {

    private AbstractClassStartDefinition AbstractClassStartDefinition;
    private ClassVarDecl ClassVarDecl;

    public AbstractClassDeclarationNoExtendedNoMethods (AbstractClassStartDefinition AbstractClassStartDefinition, ClassVarDecl ClassVarDecl) {
        this.AbstractClassStartDefinition=AbstractClassStartDefinition;
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.setParent(this);
        this.ClassVarDecl=ClassVarDecl;
        if(ClassVarDecl!=null) ClassVarDecl.setParent(this);
    }

    public AbstractClassStartDefinition getAbstractClassStartDefinition() {
        return AbstractClassStartDefinition;
    }

    public void setAbstractClassStartDefinition(AbstractClassStartDefinition AbstractClassStartDefinition) {
        this.AbstractClassStartDefinition=AbstractClassStartDefinition;
    }

    public ClassVarDecl getClassVarDecl() {
        return ClassVarDecl;
    }

    public void setClassVarDecl(ClassVarDecl ClassVarDecl) {
        this.ClassVarDecl=ClassVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.accept(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.traverseTopDown(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.traverseBottomUp(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDeclarationNoExtendedNoMethods(\n");

        if(AbstractClassStartDefinition!=null)
            buffer.append(AbstractClassStartDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDecl!=null)
            buffer.append(ClassVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDeclarationNoExtendedNoMethods]");
        return buffer.toString();
    }
}
