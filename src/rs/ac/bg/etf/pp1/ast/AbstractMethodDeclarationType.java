// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:43


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclarationType extends AbstractMethodDecl {

    private TypeAndIdentInMethod TypeAndIdentInMethod;
    private FormPars FormPars;

    public AbstractMethodDeclarationType (TypeAndIdentInMethod TypeAndIdentInMethod, FormPars FormPars) {
        this.TypeAndIdentInMethod=TypeAndIdentInMethod;
        if(TypeAndIdentInMethod!=null) TypeAndIdentInMethod.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
    }

    public TypeAndIdentInMethod getTypeAndIdentInMethod() {
        return TypeAndIdentInMethod;
    }

    public void setTypeAndIdentInMethod(TypeAndIdentInMethod TypeAndIdentInMethod) {
        this.TypeAndIdentInMethod=TypeAndIdentInMethod;
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeAndIdentInMethod!=null) TypeAndIdentInMethod.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeAndIdentInMethod!=null) TypeAndIdentInMethod.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeAndIdentInMethod!=null) TypeAndIdentInMethod.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDeclarationType(\n");

        if(TypeAndIdentInMethod!=null)
            buffer.append(TypeAndIdentInMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclarationType]");
        return buffer.toString();
    }
}
