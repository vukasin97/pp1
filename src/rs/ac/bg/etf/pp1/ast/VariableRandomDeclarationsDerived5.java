// generated with ast extension for cup
// version 0.8
// 18/7/2020 23:12:42


package rs.ac.bg.etf.pp1.ast;

public class VariableRandomDeclarationsDerived5 extends VariableRandomDeclarations {

    public VariableRandomDeclarationsDerived5 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableRandomDeclarationsDerived5(\n");

        buffer.append(tab);
        buffer.append(") [VariableRandomDeclarationsDerived5]");
        return buffer.toString();
    }
}
