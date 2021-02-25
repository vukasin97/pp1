// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationWithExtended extends ClassDeclList {

    private ClassIdentExtend ClassIdentExtend;
    private ClassDeclContinue ClassDeclContinue;

    public ClassDeclarationWithExtended (ClassIdentExtend ClassIdentExtend, ClassDeclContinue ClassDeclContinue) {
        this.ClassIdentExtend=ClassIdentExtend;
        if(ClassIdentExtend!=null) ClassIdentExtend.setParent(this);
        this.ClassDeclContinue=ClassDeclContinue;
        if(ClassDeclContinue!=null) ClassDeclContinue.setParent(this);
    }

    public ClassIdentExtend getClassIdentExtend() {
        return ClassIdentExtend;
    }

    public void setClassIdentExtend(ClassIdentExtend ClassIdentExtend) {
        this.ClassIdentExtend=ClassIdentExtend;
    }

    public ClassDeclContinue getClassDeclContinue() {
        return ClassDeclContinue;
    }

    public void setClassDeclContinue(ClassDeclContinue ClassDeclContinue) {
        this.ClassDeclContinue=ClassDeclContinue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassIdentExtend!=null) ClassIdentExtend.accept(visitor);
        if(ClassDeclContinue!=null) ClassDeclContinue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassIdentExtend!=null) ClassIdentExtend.traverseTopDown(visitor);
        if(ClassDeclContinue!=null) ClassDeclContinue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassIdentExtend!=null) ClassIdentExtend.traverseBottomUp(visitor);
        if(ClassDeclContinue!=null) ClassDeclContinue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationWithExtended(\n");

        if(ClassIdentExtend!=null)
            buffer.append(ClassIdentExtend.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclContinue!=null)
            buffer.append(ClassDeclContinue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationWithExtended]");
        return buffer.toString();
    }
}
