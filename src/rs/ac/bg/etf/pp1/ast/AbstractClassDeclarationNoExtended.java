// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDeclarationNoExtended extends AbstractClassDeclList {

    private AbstractClassStartDefinition AbstractClassStartDefinition;
    private ClassVarDecl ClassVarDecl;
    private AbstractInClassDeclarations AbstractInClassDeclarations;

    public AbstractClassDeclarationNoExtended (AbstractClassStartDefinition AbstractClassStartDefinition, ClassVarDecl ClassVarDecl, AbstractInClassDeclarations AbstractInClassDeclarations) {
        this.AbstractClassStartDefinition=AbstractClassStartDefinition;
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.setParent(this);
        this.ClassVarDecl=ClassVarDecl;
        if(ClassVarDecl!=null) ClassVarDecl.setParent(this);
        this.AbstractInClassDeclarations=AbstractInClassDeclarations;
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.setParent(this);
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

    public AbstractInClassDeclarations getAbstractInClassDeclarations() {
        return AbstractInClassDeclarations;
    }

    public void setAbstractInClassDeclarations(AbstractInClassDeclarations AbstractInClassDeclarations) {
        this.AbstractInClassDeclarations=AbstractInClassDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.accept(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.accept(visitor);
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.traverseTopDown(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseTopDown(visitor);
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassStartDefinition!=null) AbstractClassStartDefinition.traverseBottomUp(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseBottomUp(visitor);
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDeclarationNoExtended(\n");

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

        if(AbstractInClassDeclarations!=null)
            buffer.append(AbstractInClassDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDeclarationNoExtended]");
        return buffer.toString();
    }
}
