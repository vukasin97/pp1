package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class StructForMethod extends Struct {

	
	
	
			private ArrayList<Obj> MethodArguments = new ArrayList<Obj>();
			
			public ArrayList<Obj> getMethodVariables() {
				return MethodVariables;
			}

			public void setMethodVariables(ArrayList<Obj> methodVariables) {
				MethodVariables = methodVariables;
			}

			private ArrayList<Obj> MethodVariables = new ArrayList<Obj>();
	public ArrayList<Obj> getMethodArguments() {
				return MethodArguments;
			}

			public void setMethodArguments(ArrayList<Obj> methodArguments) {
				for(int i=0; i<methodArguments.size(); i++)
				{
					MethodArguments.add(methodArguments.get(i));
				}
			}

	public StructForMethod(int kind, Struct elemType) {
		super(kind, elemType);
		// TODO Auto-generated constructor stub
	}

	public StructForMethod(int kind, SymbolDataStructure members) {
		super(kind, members);
		// TODO Auto-generated constructor stub
	}

	public StructForMethod(int kind) {
		super(kind);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setElementType(Struct type) {
		// TODO Auto-generated method stub
		super.setElementType(type);
	}

	@Override
	public void setMembers(SymbolDataStructure symbols) {
		// TODO Auto-generated method stub
		super.setMembers(symbols);
	}

	@Override
	public int getKind() {
		// TODO Auto-generated method stub
		return super.getKind();
	}

	@Override
	public Struct getElemType() {
		// TODO Auto-generated method stub
		return super.getElemType();
	}

	@Override
	public int getNumberOfFields() {
		// TODO Auto-generated method stub
		return super.getNumberOfFields();
	}

	@Override
	public SymbolDataStructure getMembersTable() {
		// TODO Auto-generated method stub
		return super.getMembersTable();
	}

	@Override
	public Collection<Obj> getMembers() {
		// TODO Auto-generated method stub
		return super.getMembers();
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
	}

	@Override
	public boolean isRefType() {
		// TODO Auto-generated method stub
		return super.isRefType();
	}

	@Override
	public boolean equals(Struct other) {
		// TODO Auto-generated method stub
		if (super.getKind() == Array) return other.getKind() == Array
				&& getElemType().equals(other.getElemType());

		if (getKind() == Class) return other.getKind() == Class && getNumberOfFields() == other.getNumberOfFields()
				&& Obj.equalsCompleteHash(getMembersTable(), other.getMembersTable());

		// mora biti isti Struct cvor
		return getKind() == other.getKind();
												
	}

	@Override
	public boolean compatibleWith(Struct other) {
		// TODO Auto-generated method stub
		return this.equals(other) || this == Tab.nullType && other.isRefType()
				|| other == Tab.nullType && this.isRefType();
	}

	@Override
	public boolean assignableTo(Struct dest) {
		// TODO Auto-generated method stub
		//return super.assignableTo(dest);
		return 	this.equals(dest) 
				|| 
				(this == Tab.nullType && dest.isRefType())
				|| 
				(this.getKind() == Array && dest.getKind() == Array && dest.getElemType() == Tab.noType);
	}

	@Override
	public void accept(SymbolTableVisitor stv) {
		// TODO Auto-generated method stub
		super.accept(stv);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}










											
}
