// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationWithNoExtended extends ClassDeclList {

    private ClassIdentNoExtend ClassIdentNoExtend;
    private ClassDeclContinue ClassDeclContinue;

    public ClassDeclarationWithNoExtended (ClassIdentNoExtend ClassIdentNoExtend, ClassDeclContinue ClassDeclContinue) {
        this.ClassIdentNoExtend=ClassIdentNoExtend;
        if(ClassIdentNoExtend!=null) ClassIdentNoExtend.setParent(this);
        this.ClassDeclContinue=ClassDeclContinue;
        if(ClassDeclContinue!=null) ClassDeclContinue.setParent(this);
    }

    public ClassIdentNoExtend getClassIdentNoExtend() {
        return ClassIdentNoExtend;
    }

    public void setClassIdentNoExtend(ClassIdentNoExtend ClassIdentNoExtend) {
        this.ClassIdentNoExtend=ClassIdentNoExtend;
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
        if(ClassIdentNoExtend!=null) ClassIdentNoExtend.accept(visitor);
        if(ClassDeclContinue!=null) ClassDeclContinue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassIdentNoExtend!=null) ClassIdentNoExtend.traverseTopDown(visitor);
        if(ClassDeclContinue!=null) ClassDeclContinue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassIdentNoExtend!=null) ClassIdentNoExtend.traverseBottomUp(visitor);
        if(ClassDeclContinue!=null) ClassDeclContinue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationWithNoExtended(\n");

        if(ClassIdentNoExtend!=null)
            buffer.append(ClassIdentNoExtend.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclContinue!=null)
            buffer.append(ClassDeclContinue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationWithNoExtended]");
        return buffer.toString();
    }
}
