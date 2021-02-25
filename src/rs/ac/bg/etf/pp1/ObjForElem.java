package rs.ac.bg.etf.pp1;

import java.util.Collection;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class ObjForElem extends Obj {
		Obj array;
		
		Obj index;
	public Obj getArray() {
			return array;
		}

	public void setIndex(Obj index1) {
		this.index = index1;
	}
	public Obj getIndex()
	{
		return index;
	}
		public void setArray(Obj array) {
			this.array = array;
		}

	public ObjForElem(int kind, String name, Struct type, int adr, int level) {
		super(kind, name, type, adr, level);
		// TODO Auto-generated constructor stub
	}

	public ObjForElem(int kind, String name, Struct type) {
		super(kind, name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getKind() {
		// TODO Auto-generated method stub
		return super.getKind();
	}

	@Override
	public Struct getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		super.setLevel(level);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public int getAdr() {
		// TODO Auto-generated method stub
		return super.getAdr();
	}

	@Override
	public void setAdr(int adr) {
		// TODO Auto-generated method stub
		super.setAdr(adr);
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return super.getLevel();
	}

	@Override
	public int getFpPos() {
		// TODO Auto-generated method stub
		return super.getFpPos();
	}

	@Override
	public void setFpPos(int fpPos) {
		// TODO Auto-generated method stub
		super.setFpPos(fpPos);
	}

	@Override
	public Collection<Obj> getLocalSymbols() {
		// TODO Auto-generated method stub
		return super.getLocalSymbols();
	}

	@Override
	public void setLocals(SymbolDataStructure locals) {
		// TODO Auto-generated method stub
		super.setLocals(locals);
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
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
