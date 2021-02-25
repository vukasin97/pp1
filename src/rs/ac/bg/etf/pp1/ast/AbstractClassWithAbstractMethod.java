// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassWithAbstractMethod extends AbstractInClassDeclarations {

    private AbstractInClassDeclarations AbstractInClassDeclarations;
    private AbstractMethodDecl AbstractMethodDecl;

    public AbstractClassWithAbstractMethod (AbstractInClassDeclarations AbstractInClassDeclarations, AbstractMethodDecl AbstractMethodDecl) {
        this.AbstractInClassDeclarations=AbstractInClassDeclarations;
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.setParent(this);
        this.AbstractMethodDecl=AbstractMethodDecl;
        if(AbstractMethodDecl!=null) AbstractMethodDecl.setParent(this);
    }

    public AbstractInClassDeclarations getAbstractInClassDeclarations() {
        return AbstractInClassDeclarations;
    }

    public void setAbstractInClassDeclarations(AbstractInClassDeclarations AbstractInClassDeclarations) {
        this.AbstractInClassDeclarations=AbstractInClassDeclarations;
    }

    public AbstractMethodDecl getAbstractMethodDecl() {
        return AbstractMethodDecl;
    }

    public void setAbstractMethodDecl(AbstractMethodDecl AbstractMethodDecl) {
        this.AbstractMethodDecl=AbstractMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.accept(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.traverseTopDown(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.traverseBottomUp(visitor);
        if(AbstractMethodDecl!=null) AbstractMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassWithAbstractMethod(\n");

        if(AbstractInClassDeclarations!=null)
            buffer.append(AbstractInClassDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractMethodDecl!=null)
            buffer.append(AbstractMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassWithAbstractMethod]");
        return buffer.toString();
    }
}
