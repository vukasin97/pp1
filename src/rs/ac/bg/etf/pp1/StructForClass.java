package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.HashTableDataStructure;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class StructForClass extends Struct {

	
		private Struct baseClass = null;

		private Scope scope;
		
		private Obj classObj = null;
		
		
		
		public Obj getClassObj() {
			return classObj;
		}
		public void setClassObj(Obj classObj) {
			this.classObj = classObj;
		}

		ArrayList<String> overidedAbstractMethodes = new ArrayList<String>();
		public void addAbstractMethod(String s) 
		{
			overidedAbstractMethodes.add(s);
		}
		public ArrayList<String> getAbstractMethods()
		{
			return overidedAbstractMethodes;
		}
		public void setScope(Scope scope) {
			this.scope = scope;
		}
		public Scope getScope() 
		{
			return this.scope;
		}
		public Struct getBaseClass() {
			return baseClass;
		}
		public void setBaseClass(Struct baseClass) {
		this.baseClass = baseClass;	
		}
		public void setElementType(Struct type) {
			super.setElementType(type);
		}
		
		public void setMembers(SymbolDataStructure symbols) {
		super.setMembers(symbols);		
		}
		
		public StructForClass(int kind) {
			super(kind);
		}

		public StructForClass(int kind, Struct elemType) {
			super(kind, elemType);
		}

		public StructForClass(int kind, SymbolDataStructure members) {
			super(kind, members);
		}

		public int getKind() {
			return super.getKind();
		}

		public Struct getElemType() {
			return super.getElemType();
		}

		public int getNumberOfFields() {
			return super.getNumberOfFields();
		}

		
		/**
		 * Retrieves the internal symbol data structure.
		 *  
		 * @return
		 */
		public SymbolDataStructure getMembersTable() {
				return super.getMembersTable();
		}
		
		/**
		 * Retrieves a collection of all Obj nodes in the list of local symbols of the given type. <br/>
		 * Invokes {@link Struct#getMembersTable()}.
		 * 
		 * @return A collection of Obj nodes.
		 */
		public Collection<Obj> getMembers() {
			return super.getMembers();
		}
		
		public boolean equals(Object o) {
			// najpre provera da li su reference jednake
			return super.equals(o);
		}

		public boolean isRefType() {
			return super.isRefType();
		}

		public boolean equals(Struct other) {
			return super.equals(other);
		}

		public boolean compatibleWith(Struct other) {
			return super.compatibleWith(other);		}
		

		public boolean assignableTo(Struct dest) {
		
			
		System.out.println("skskskksfieiqoeqkmfvmfmmfmffm");
		if (baseClass != null) 
		return super.assignableTo(dest) || baseClass.equals(dest);
		else return super.assignableTo(dest);
		
		}
		
		public void accept(SymbolTableVisitor stv) {
			stv.visitStructNode(this);
		}
	
	}
				
	
	









