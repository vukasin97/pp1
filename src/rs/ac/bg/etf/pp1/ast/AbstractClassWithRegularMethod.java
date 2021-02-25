// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassWithRegularMethod extends AbstractInClassDeclarations {

    private AbstractInClassDeclarations AbstractInClassDeclarations;
    private MethodDecl MethodDecl;

    public AbstractClassWithRegularMethod (AbstractInClassDeclarations AbstractInClassDeclarations, MethodDecl MethodDecl) {
        this.AbstractInClassDeclarations=AbstractInClassDeclarations;
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public AbstractInClassDeclarations getAbstractInClassDeclarations() {
        return AbstractInClassDeclarations;
    }

    public void setAbstractInClassDeclarations(AbstractInClassDeclarations AbstractInClassDeclarations) {
        this.AbstractInClassDeclarations=AbstractInClassDeclarations;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractInClassDeclarations!=null) AbstractInClassDeclarations.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassWithRegularMethod(\n");

        if(AbstractInClassDeclarations!=null)
            buffer.append(AbstractInClassDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassWithRegularMethod]");
        return buffer.toString();
    }
}
