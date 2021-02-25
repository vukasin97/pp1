// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDeclarationWithExtendedNoMethods extends AbstractClassDeclList {

    private AbstractClassStartDefinitionExtends AbstractClassStartDefinitionExtends;
    private ClassVarDecl ClassVarDecl;

    public AbstractClassDeclarationWithExtendedNoMethods (AbstractClassStartDefinitionExtends AbstractClassStartDefinitionExtends, ClassVarDecl ClassVarDecl) {
        this.AbstractClassStartDefinitionExtends=AbstractClassStartDefinitionExtends;
        if(AbstractClassStartDefinitionExtends!=null) AbstractClassStartDefinitionExtends.setParent(this);
        this.ClassVarDecl=ClassVarDecl;
        if(ClassVarDecl!=null) ClassVarDecl.setParent(this);
    }

    public AbstractClassStartDefinitionExtends getAbstractClassStartDefinitionExtends() {
        return AbstractClassStartDefinitionExtends;
    }

    public void setAbstractClassStartDefinitionExtends(AbstractClassStartDefinitionExtends AbstractClassStartDefinitionExtends) {
        this.AbstractClassStartDefinitionExtends=AbstractClassStartDefinitionExtends;
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
        if(AbstractClassStartDefinitionExtends!=null) AbstractClassStartDefinitionExtends.accept(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassStartDefinitionExtends!=null) AbstractClassStartDefinitionExtends.traverseTopDown(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassStartDefinitionExtends!=null) AbstractClassStartDefinitionExtends.traverseBottomUp(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDeclarationWithExtendedNoMethods(\n");

        if(AbstractClassStartDefinitionExtends!=null)
            buffer.append(AbstractClassStartDefinitionExtends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDecl!=null)
            buffer.append(ClassVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDeclarationWithExtendedNoMethods]");
        return buffer.toString();
    }
}
