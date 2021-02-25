package rs.ac.bg.etf.pp1;


import rs.ac.bg.etf.pp1.ast.FormalParamDecl;

import rs.ac.bg.etf.pp1.ast.*;
//import rs.ac.bg.etf.pp1.ast.VarDecl;
//import rs.ac.bg.etf.pp1.ast.VarDeclList;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {

	protected int count;
	
	public int getCount(){
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor{
	
		public void visit(FormalParamDeclarations formParamDecl){
			count++;
		}
		
		public void visit(FormalParamDeclarationsArray form)
		{
			count++;
		}
	}
	
	public static class VarCounter extends CounterVisitor{
		
		public void visit(Sametypeident varDecl){
			count++;
		}
		
		public void visti(Sametyperecursive varDecl)
		{
		count++;	
		}
		public void visit(SametypeIdentBrackets varDecl)
		{
			count++;
		}
		public void visit(SameTypeSquareBrackets varDecl)
		{
			count++;
		}
	}
}
