package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

//import com.sun.org.apache.xpath.internal.Expression;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor 
{
private int MainPc;
Obj index;
boolean add = false;

boolean expressionInParanthesis = false;
boolean firstBool = false;
private ObjForElem arrayObj;
private boolean conditionOR = false;
Stack<Integer> forAddresses = new Stack<Integer>();
private boolean insideFor = false;
private int breakForOr = 0;
private boolean breakFound = false;
Stack<Integer> forJumps = new Stack<Integer>();

int foreachloopaddress = 0;


Stack<Integer> foreachAddressForFix = new Stack<Integer>();

Stack<SyntaxNode> stackForOperations = new Stack<SyntaxNode>();

//Stack<SyntaxNode> 


Stack<SyntaxNode> stackForOperationsDividing = new Stack<SyntaxNode>();

Stack<SyntaxNode> stackForRelopOperations = new Stack<SyntaxNode>();

Stack<Integer> numberOfAddressesToFix = new Stack<Integer>();

Stack<Integer> elseOrAddresses = new Stack<Integer>();
//private int beforeLastOperation = 0;
boolean funcCall = false;
boolean multiply = false;
boolean mod = false;
boolean divide = false;
private int numberOfAddresses = 0;
boolean varDesignator = true;
//private boolean settledObjectInDesignatorAssignOp =false;
public boolean newType = false;
public boolean arrayAccess = false;
private boolean addingAssigning = false;
private boolean subAssigning = false;
private boolean multiplyAssigning = false;
private boolean modAssigning = false;

private boolean divideAssigning = false;
private boolean cnstForTermRep = false;
private boolean elemObjInExpr = false;

private Obj identInForEach;

private Obj ObjForLoopingInForEach = new Obj(Obj.Var, "obj", Tab.intType);
private Stack<Integer> stackForIfAddresses = new Stack<Integer>();


private Stack<Integer> stackForElseAddresses = new Stack<Integer>();


private Stack<Integer> stackForOrAddresses = new Stack<Integer>();
private int continueAddress;
private boolean standardFunctions = false;
private boolean len = false;


public int getMainPc() {
	return MainPc;
}

public void visit(TermExpr term)
{
	
	
}

public void visit(ExpressionInParanthesis expr) {
	expressionInParanthesis = true;
}
public void setMainPc(int mainPc) {
	MainPc = mainPc;
}

public void visit(DesignatorAssignOp des)
{
	
	


	if (addingAssigning) {
		addingAssigning = false;
	if (des.getDesignator().obj.getKind() != Obj.Elem)
		Code.load(des.getDesignator().obj);
		Code.put(Code.add);
		
	}
	if (subAssigning) {
		subAssigning = false;
		if (des.getDesignator().obj.getKind() != Obj.Elem)
		Code.load(des.getDesignator().obj);
		
		Code.put(Code.sub);
		Code.put(Code.neg);
	}
	if (multiplyAssigning) {
		multiplyAssigning = false;
		if (des.getDesignator().obj.getKind() != Obj.Elem)
		Code.load(des.getDesignator().obj);
		Code.put(Code.mul);
	}
	if (divideAssigning) 
	{
		
		divideAssigning = false;
		
		if (des.getDesignator().obj.getKind() != Obj.Elem)
		Code.load(des.getDesignator().obj);
		Code.put(Code.div);
		//////
		
	}
	if (modAssigning)
	{
		modAssigning = false;
		if (des.getDesignator().obj.getKind() != Obj.Elem)
			Code.load(des.getDesignator().obj);
			Code.put(Code.rem);
	}
	//System.out.println(des.getDesignator().obj.getName() + " KKDDKDKDKDKDKD");
	
	Code.store(des.getDesignator().obj);
	
	
	// ucitavanje promenljive u factor

	
}

public void visit(BoolConstants boolCon)
{

}

public void visit(TermOnlyFactor factor)

{
	
	
		if (len) {
			len = false;
			Code.put(Code.arraylength);
		}
	
cnstForTermRep = false;
	// staviti factor na expr stack
	if (expressionInParanthesis == false) {
	if (!newType) {
		if (!funcCall) {
	Code.load(factor.obj);
		
	//System.out.println(factor.obj.getAdr());
	
	index = factor.obj;
	}else funcCall = false;
	}
	else newType = false;
	}else  {
		expressionInParanthesis = false;
	}
	varDesignator = false;
}


public void visit(Const cnst) {

	System.out.println(cnst.getLine() + "    sjdjdjdjdd");
	this.cnstForTermRep = true;
}

public void visit(AddExpr add) 
{
	System.out.println("Sabiranje pokusaj");
SyntaxNode node = stackForOperations.pop();

if (node instanceof Plus) {

	Code.put(Code.add);
}
if (node instanceof Minus) {
	
	Code.put(Code.sub);

}
/*
if (node instanceof PlusEqual)
{
	if (add.getExpr().obj.getKind() == Obj.Elem)
	{
	Code.put(Code.add);
	Code.put(Code.astore);
	ObjForElem obj = (ObjForElem)add.getExpr().obj;
	Obj array = obj.getArray();
	Obj ind = obj.getIndex();
	Code.load(array);
	Code.load(ind);
	Code.put(Code.aload);
	}
	else
		{
		
		
		
		Code.put(Code.add);
		Code.put(Code.dup); // kopiranje vrednosti
		Code.store(add.getExpr().obj);
	//	Code.store(add.getTerm().obj);
		}
	
}
*/
/*
if (node instanceof MinusEqual)
{
	
	if (add.getExpr().obj.getKind() == Obj.Elem)
	{
		Code.put(Code.sub);
		Code.put(Code.astore);
		ObjForElem obj = (ObjForElem)add.getExpr().obj;
		Obj array = obj.getArray();
		Obj ind = obj.getIndex();
		Code.load(array);
		Code.load(ind);
		Code.put(Code.aload);
	}
	else 
	{
	Code.put(Code.sub);
	
	Code.put(Code.dup);
	Code.store(add.getExpr().obj);
	
	}
	
	
}	
*/
	
}
public void visit(ExprAddopRight expraddop) {
	SyntaxNode node = stackForOperations.pop();
	
	if (node instanceof PlusEqual)
	{
		if (expraddop.getExprLeft().obj.getKind() == Obj.Elem)
		{
		
		//Code.put(Code.astore);
			/*
		ObjForElem obj = (ObjForElem)expraddop.getExprLeft().obj;
		Obj array = obj.getArray();
		Obj ind = obj.getIndex();
		Code.load(array);
		Code.load(ind);
		Code.put(Code.dup2);
		Code.put(Code.add);
		Code.put(Code.astore);
		Code.put(Code.aload);
		*/
			Code.put(Code.add);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)expraddop.getExprLeft().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else
			{
			
			
			
			Code.put(Code.add);
			Code.put(Code.dup); // kopiranje vrednosti
			Code.store(expraddop.getExprLeft().obj);
		//	Code.store(add.getTerm().obj);
			}
		
	}

	if (node instanceof MinusEqual)
	{
		
		if (expraddop.getExprLeft().obj.getKind() == Obj.Elem)
		{
		//	Code.put(Code.sub);
			//Code.put(Code.astore);
			/*
			ObjForElem obj = (ObjForElem)expraddop.getExprLeft().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.dup2);
			Code.put(Code.sub);
			Code.put(Code.astore);
			Code.put(Code.aload);
			*/
			Code.put(Code.sub);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)expraddop.getExprLeft().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.sub);
		
		Code.put(Code.dup);
		Code.store(expraddop.getExprLeft().obj);
		
		}
		
		
	}	
	
}

public void visit(TermRepetition termrep)
{
	

// vratiti se	
if (len)
{
	Code.put(Code.arraylength);
	len = false;
}
	
	if (varDesignator) {
		if (!expressionInParanthesis)
	Code.load(termrep.getFactor().obj);
		else expressionInParanthesis = false;
	varDesignator = false;
	
	}
	if (expressionInParanthesis) expressionInParanthesis = false;
	if (cnstForTermRep) {
		Code.load(termrep.getFactor().obj);
		cnstForTermRep = false;
	}
	SyntaxNode node = stackForOperationsDividing.pop();
	
	if (node instanceof Multiply) {
		Code.put(Code.mul);
	}
	if (node instanceof Divide) {
		Code.put(Code.div);
	}
	if (node instanceof Mod) {
		Code.put(Code.rem);
	}
	/*
	if (node instanceof EqualMultiply) 
	{
		if (termrep.getTerm().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.mul);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)termrep.getTerm().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.mul);
		Code.put(Code.dup);
		Code.store(termrep.getTerm().obj);
		
		}
	}
	if (node instanceof EqualDivide)
	{
		if (termrep.getTerm().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.div);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)termrep.getTerm().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.div);
		Code.put(Code.dup);
		Code.store(termrep.getTerm().obj);
		
		}
	}
	if (node instanceof EqualMod)
	{
		if (termrep.getTerm().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.rem);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)termrep.getTerm().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.rem);
		Code.put(Code.dup);
		Code.store(termrep.getTerm().obj);
		
		}
		
	}
	*/
}
public void visit(TermRightRepetition termrep) {
	SyntaxNode node = stackForOperationsDividing.pop();
	if (node instanceof EqualMultiply) 
	{
		if (termrep.getTermRight().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.mul);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)termrep.getTermRight().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.mul);
		Code.put(Code.dup);
		Code.store(termrep.getTermRight().obj);
		
		}
	}
	if (node instanceof EqualDivide)
	{
		if (termrep.getTermRight().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.div);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)termrep.getTermRight().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.div);
		Code.put(Code.dup);
		Code.store(termrep.getTermRight().obj);
		
		}
	}
	if (node instanceof EqualMod)
	{
		if (termrep.getTermRight().obj.getKind() == Obj.Elem)
		{
			Code.put(Code.rem);
			Code.put(Code.astore);
			ObjForElem obj = (ObjForElem)termrep.getTermRight().obj;
			Obj array = obj.getArray();
			Obj ind = obj.getIndex();
			Code.load(array);
			Code.load(ind);
			Code.put(Code.aload);
		}
		else 
		{
		Code.put(Code.rem);
		Code.put(Code.dup);
		Code.store(termrep.getTermRight().obj);
		
		}
		
	}
}
public void visit(MinusTermExpr termrep)

{
	
	Code.put(Code.neg);
}

public void visit(DesignatorIncrement increment)
		{
	
//	Code.load(increment.getDesignator().obj);
	if (elemObjInExpr) {
	Code.put(Code.dup2);
	Code.put(Code.aload);
	arrayAccess = false;
	}
	else Code.load(increment.getDesignator().obj);
	Code.put(Code.const_n + 1);
	Code.put(Code.add);
	Code.store(increment.getDesignator().obj);
		
	
			}
					
							
public void visit(DesignatorDecrement decrement)
		{
	
	if (elemObjInExpr) {
		Code.put(Code.dup2);
		Code.put(Code.aload);
		arrayAccess = false;
	}
	else Code.load(decrement.getDesignator().obj);
	Code.put(Code.const_n + 1);
	Code.put(Code.sub);
	Code.store(decrement.getDesignator().obj);
		}


	
	
	public void visit(ReadStatement read)
	{
		if (read.getDesignator().obj.getType().getKind() == Struct.Int) 
		{
			Code.put(Code.read);
			Code.store(read.getDesignator().obj);
			System.out.println("slslslslskfieieiieeiei");
			
		}
		else if (read.getDesignator().obj.getType().getKind() == Struct.Char)
		{
			Code.put(Code.bread);
			Code.store(read.getDesignator().obj);
		}
		
		else if (read.getDesignator().obj.getType().getKind() == Struct.Bool)
		{
			// ispis za true karakter unesite 1 za false unesite 0
			//Code.
			Obj charZ = new Obj(Obj.Con, "charZ", Tab.charType);
			charZ.setAdr((int)'Z');
			Code.load(charZ);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			/**Z**/
			
			Obj charA = new Obj(Obj.Con, "charA", Tab.charType);
			charA.setAdr((int)'a');
			Code.load(charA);
			Code.loadConst(1);
			Code.put(Code.bprint);
			/**A**/
			Obj charBl = new Obj(Obj.Con, "charBl", Tab.charType);
			charBl.setAdr((int)' ');
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			/**T**/
			Obj charT = new Obj(Obj.Con, "charT", Tab.charType);
			charT.setAdr((int)'t');
			Code.load(charT);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charR = new Obj(Obj.Con, "charR", Tab.charType);
			charR.setAdr((int)'r');
			Code.load(charR);
			Code.loadConst(1);
			Code.put(Code.bprint);
		
			/**R**/
			
			
			Obj charU = new Obj(Obj.Con, "charU", Tab.charType);
			charU.setAdr((int)'u');
			Code.load(charU);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			
			Obj charE = new Obj(Obj.Con, "charE", Tab.charType);
			charE.setAdr((int)'e');
			Code.load(charE);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			
			
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			/** bl **/ 
			// vratiti se ovde
			
			Code.load(charU);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charN = new Obj(Obj.Con, "charN", Tab.charType);
			charN.setAdr((int)'n');
			Code.load(charN);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charE);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charS = new Obj(Obj.Con, "charS", Tab.charType);
			charS.setAdr((int)'s');
			Code.load(charS);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charI = new Obj(Obj.Con, "charI", Tab.charType);
			charI.setAdr((int)'i');
			Code.load(charI);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charT);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charE);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			
			Obj charOne = new Obj(Obj.Con, "charOne", Tab.charType);
			charOne.setAdr((int)'1');
			Code.load(charOne);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charnewLine = new Obj(Obj.Con, "charNewLine", Tab.charType);
			charnewLine.setAdr((int)',');
			
			Code.load(charnewLine);
			
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charF = new Obj(Obj.Con, "charF", Tab.charType);
			charF.setAdr((int)'f');
			Code.load(charF);
			Code.loadConst(1);
			Code.put(Code.bprint);
			


			
			Code.load(charA);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charL = new Obj(Obj.Con, "charL", Tab.charType);
			charL.setAdr((int)'l');
			Code.load(charL);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			
			Code.load(charS);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charE);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charZero = new Obj(Obj.Con, "charZero", Tab.charType);
			charZero.setAdr((int)'0');
			Code.load(charZero);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.put(Code.read);
			Code.store(read.getDesignator().obj);
			
		}
	
	}
	
	public void visit(PrintExpression print)
			{
		
		
		if(print.getExpr().obj.getType().getKind() == Struct.Int){
			Code.loadConst(4);
			Code.put(Code.print);
			System.out.println("PPPPCPCPCPCCPCP");
		}else if (print.getExpr().obj.getType().getKind() == Struct.Char){
			
			Obj charBl = new Obj(Obj.Con, "charbl", Tab.charType);
			charBl.setAdr((int)' ');
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
		}else if (print.getExpr().obj.getType().getKind() == Struct.Bool)
		{
		Code.load(print.getExpr().obj);
		Code.loadConst(1);
		Code.putFalseJump(0, 0);
		int adr = Code.pc - 2;
		// ispis true
		Obj charT = new Obj(Obj.Con, "charT", Tab.charType);
		charT.setAdr((int)'t');
		Code.load(charT);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charR = new Obj(Obj.Con, "charR", Tab.charType);
		charR.setAdr((int)'r');
		Code.load(charR);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charU = new Obj(Obj.Con, "charU", Tab.charType);
		charU.setAdr((int)'u');
		Code.load(charU);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charE = new Obj(Obj.Con, "charT", Tab.charType);
		charE.setAdr((int)'e');
		Code.load(charE);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charBl = new Obj(Obj.Con, "charbl", Tab.charType);
		charBl.setAdr((int)' ');
		Code.load(charBl);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Code.putJump(0);
		int adr2 = Code.pc-2;
		Code.fixup(adr);
		// ispis false
		Obj charF = new Obj(Obj.Con, "charF", Tab.charType);
		charF.setAdr((int)'f');
		Code.load(charF);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		
		Obj charA = new Obj(Obj.Con, "charA", Tab.charType);
		charA.setAdr((int)'a');
		Code.load(charA);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charL = new Obj(Obj.Con, "charL", Tab.charType);
		charL.setAdr((int)'l');
		Code.load(charL);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charS = new Obj(Obj.Con, "charS", Tab.charType);
		charS.setAdr((int)'s');
		Code.load(charS);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Code.load(charE);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Code.load(charBl);
		Code.loadConst(1);
		Code.put(Code.bprint);
		// preskakanje else
		Code.fixup(adr2);
		}
			}
	public void visit(PrintExpAndNumberConst print) 
	{
		/*
		if(print.getExpr().obj.getType().getKind() == Struct.Int){
			Code.loadConst(4);
			Code.put(Code.print);
		
		}else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		*/
		
		if(print.getExpr().obj.getType().getKind() == Struct.Int){
			Code.loadConst(4);
			Code.put(Code.print);
			System.out.println("PPPPCPCPCPCCPCP");
		}else if (print.getExpr().obj.getType().getKind() == Struct.Char){
			Code.loadConst(1);
			Code.put(Code.bprint);
			
			Obj charBl = new Obj(Obj.Con, "charbl", Tab.charType);
			charBl.setAdr((int)' ');
			Code.load(charBl);
			Code.loadConst(1);
			Code.put(Code.bprint);
			
		}else if (print.getExpr().obj.getType().getKind() == Struct.Bool)
		{
		Code.load(print.getExpr().obj);
		Code.loadConst(1);
		Code.putFalseJump(0, 0);
		int adr = Code.pc - 2;
		// ispis true
		Obj charT = new Obj(Obj.Con, "charT", Tab.charType);
		charT.setAdr((int)'t');
		Code.load(charT);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charR = new Obj(Obj.Con, "charR", Tab.charType);
		charR.setAdr((int)'r');
		Code.load(charR);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charU = new Obj(Obj.Con, "charU", Tab.charType);
		charU.setAdr((int)'u');
		Code.load(charU);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charE = new Obj(Obj.Con, "charT", Tab.charType);
		charE.setAdr((int)'e');
		Code.load(charE);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charBl = new Obj(Obj.Con, "charbl", Tab.charType);
		charBl.setAdr((int)' ');
		Code.load(charBl);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Code.putJump(0);
		int adr2 = Code.pc-2;
		Code.fixup(adr);
		// ispis false
		Obj charF = new Obj(Obj.Con, "charF", Tab.charType);
		charF.setAdr((int)'f');
		Code.load(charF);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		
		Obj charA = new Obj(Obj.Con, "charA", Tab.charType);
		charA.setAdr((int)'a');
		Code.load(charA);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charL = new Obj(Obj.Con, "charL", Tab.charType);
		charL.setAdr((int)'l');
		Code.load(charL);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Obj charS = new Obj(Obj.Con, "charS", Tab.charType);
		charS.setAdr((int)'s');
		Code.load(charS);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Code.load(charE);
		Code.loadConst(1);
		Code.put(Code.bprint);
		
		Code.load(charBl);
		Code.loadConst(1);
		Code.put(Code.bprint);
		// preskakanje else
		Code.fixup(adr2);
		}
		
		Obj obj = new Obj(Obj.Con, "obj", Tab.intType);
		obj.setAdr(print.getN2());
		Code.load(obj);
		Code.loadConst(4);
		Code.put(Code.print);
		
	}
	
	
	public void visit(MethodTypeName methodTypeName){
		
		if("main".equalsIgnoreCase(methodTypeName.getMethName())){
			MainPc = Code.pc;
			System.out.println("Uso je u main");
		}
		
		methodTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodTypeName.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(varCnt.getCount()); // mozda dodati fpCnt + varCnt
	
	}
	
	public void visit(MethodDeclType methodDecl){
	
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	

	public void visit(FuncCall funcCall)
				{
		this.funcCall = true;
		if (!(funcCall.getDesignator().obj.getName().equals("ord")) && !(funcCall.getDesignator().obj.getName().equals("len")) && !(funcCall.getDesignator().obj.getName().equals("chr"))) 
		{
		Obj functionObj = funcCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		
		Code.put(Code.call);
		
		Code.put2(offset);
					}
		else {
			if (funcCall.getDesignator().obj.getName().equals("len")) 
			{
				this.len  = true;
			}
		}
				}
		
	public void visit(Designator designator){
		SyntaxNode parent = designator.getParent();
		this.elemObjInExpr = false;
		this.arrayObj = null;
		if (Var.class == parent.getClass()) varDesignator = true;
		
		if(Var.class != parent.getClass() && ReadStatement.class != parent.getClass() && arrayAccess != true && DesignatorIncrement.class != parent.getClass() /*&& DesignatorAssignOp.class != parent.getClass()*/ && FuncCall.class != parent.getClass() && DesignatorActualPars.class != parent.getClass()){
			System.out.println(designator.getLine() + "dkdkdkkflor494993993392485uffn");
			Code.load(designator.obj);
			
		}
		else {
			System.out.println(designator.getDesIdent() + "SKSKSKSKSKSKSKSKSKSKS");
		}
	
		if (designator.obj.getKind() == Obj.Elem)
		{
			
		
			
			
			System.out.println(designator.getLine() + "Designator PRINT" + designator.getDesIdent());
			
	
		ObjForElem elemObj = (ObjForElem)designator.obj;
		Obj arrayObj = elemObj.getArray();
		System.out.println(arrayObj.getName());
	Obj indexForArray = new Obj(Obj.Var, "Index For Array", Tab.intType);
	Code.store(indexForArray);
	Code.load(arrayObj);
	Code.load(indexForArray);
	
	
		elemObj.setIndex(indexForArray);
		this.arrayObj = elemObj;
		this.elemObjInExpr = true;
		this.arrayAccess = false;
		
		}
		
	}
	

	
	public void visit(NewTypeExpression expr)
	{
		if (expr.getType().struct.getKind() == Struct.Int)
		{
			newType = true;
			Code.put(Code.newarray);
			Code.put(1);
			
			// ovde imam adresu niza
			
		}
		else 
			if (expr.getType().struct.getKind() == Struct.Char)
			{
				newType = true;
				Code.put(Code.newarray);
				Code.put(0);
			}
		
	}

	public void visit(DesignatorDot1 dot1)
	{
		arrayAccess = true;
		//Code.put(Code.pop);
		
	}
	
	public void visit(Multiply mult)
	{
		if (this.elemObjInExpr)
		{
		//	this.pop = false;
		}
		stackForOperationsDividing.push(mult);
	}
	
	public void visit(Divide d)
	{
		if (this.elemObjInExpr)
		{
			//this.pop = false;
		System.out.println("Divide");	
		}
		stackForOperationsDividing.push(d);
		
	}
	
	public void visit(Mod m)
	{
		
			//this.pop = false;
		stackForOperationsDividing.push(m);
	}
	
	public void visit(Plus p)
	{
		//add = true;
		//addNumber++;
		//lastOperation = 0;
	
		stackForOperations.push(p);
	}
	
	public void visit(Minus m)
	{
	//subNumber++;
	//lastOperation = 1;


		stackForOperations.push(m);
	}
	
	
	public void visit(PlusEqual plusequal)
	{
		/*
		if (this.elemObjInExpr)
		{
			Code.put(Code.pop);
			Code.load(arrayObj.getArray());
			Code.load(arrayObj.getIndex());
			Code.put(Code.dup2);
			Code.put(Code.aload);
		}
		*/
		
		stackForOperations.push(plusequal);
	}
	
	public void visit(MinusEqual minusequal)
	{
	
		
		
		stackForOperations.push(minusequal);
	}
	
	public void visit(RightAssignigWithAdding addingequal)
	{
		SyntaxNode node = stackForOperations.pop();
		if (node instanceof PlusEqual)
		this.addingAssigning  = true;
		else this.subAssigning = true;
		if (this.elemObjInExpr)
		{
			Code.put(Code.dup2);
			Code.put(Code.aload);
			
		}
			}
	
	public void visit(RightAssignigWithMul rm) {
		SyntaxNode node = stackForOperationsDividing.pop();
		if (node instanceof EqualMultiply ) {
			this.multiplyAssigning = true;
		}
		else if (node instanceof EqualMod) {
			this.modAssigning = true;
		}else {
			this.divideAssigning = true;
			
			
		}
		
		if (this.elemObjInExpr) {
			Code.put(Code.dup2);
			Code.put(Code.aload);
		
		}
	}
	public void visit(EqualMultiply p) {
	
		
		
		stackForOperationsDividing.push(p);
	}
	
	public void visit(EqualMod p) {
	

		
		stackForOperationsDividing.push(p);
	}
	
	public void visit(EqualDivide p) {

		
		stackForOperationsDividing.push(p);
	}
	
	public void visit(RightAddop right) 
	{
		
		if (this.elemObjInExpr)
		{
			Code.put(Code.pop);
			Code.load(arrayObj.getArray());
			Code.load(arrayObj.getIndex());
			Code.put(Code.dup2);
			Code.put(Code.aload);
		}
		
	}
	public void visit(RightMulop right)
	{
	
		if (this.elemObjInExpr)
		{
			Code.put(Code.pop);
			Code.load(arrayObj.getArray());
			Code.load(arrayObj.getIndex());
			Code.put(Code.dup2);
			Code.put(Code.aload);
		}
	}
	
	
	///*** NIVO B ****///
	
	
	public void visit(DesignatorActualPars procCall)
	{
		Obj functionObj = procCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		
		
		
	
		Code.put(Code.call);
		Code.put2(offset);
		if(procCall.getDesignator().obj.getType() != Tab.noType){
			Code.put(Code.pop);
		}
	}
	public void visit(CondFactInTerm cnd) {
		try {
			SyntaxNode node = stackForRelopOperations.pop();
			
			
			if (node instanceof Equality) 
			{
					Code.putFalseJump(Code.eq, 0);
					int adr = Code.pc - 2;
					System.out.println("Adresa je " + adr);
					stackForIfAddresses.push(adr);
				
			}
				
			if (node instanceof Difference) 
			{
				Code.putFalseJump(Code.ne, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
				
			}
			
			if (node instanceof Less)
			{
				Code.putFalseJump(Code.lt, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
				
			}
			
		
			if (node instanceof Less_or_equal)
			{
				Code.putFalseJump(Code.le, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
				
			}
			
			if (node instanceof Greater_or_equal)
			{
				Code.putFalseJump(Code.ge, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
				
			}	
			
			
			if (node instanceof Greater)
			{
				Code.putFalseJump(Code.gt, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
			
			}	
		
			}catch(EmptyStackException e) {
				Code.loadConst(0);
				Code.putFalseJump(Code.ne, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
			}
			numberOfAddresses++;
		
		
	}
	
	public void visit(CondTermAnd condAnd)
	{
		
		try {
		SyntaxNode node = stackForRelopOperations.pop();
		
		
		if (node instanceof Equality) 
		{
				Code.putFalseJump(Code.eq, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
			
		}
			
		if (node instanceof Difference) 
		{
			Code.putFalseJump(Code.ne, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
		if (node instanceof Less)
		{
			Code.putFalseJump(Code.lt, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
	
		if (node instanceof Less_or_equal)
		{
			Code.putFalseJump(Code.le, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
		if (node instanceof Greater_or_equal)
		{
			Code.putFalseJump(Code.ge, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}	
		
		
		if (node instanceof Greater)
		{
			Code.putFalseJump(Code.gt, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
		
		}	
	
		}catch(EmptyStackException e) {
			Code.loadConst(0);
			Code.putFalseJump(Code.ne, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
		}
		numberOfAddresses++;
	}
	
	public void visit(CondTermFact ctf)
	{
		
		try {
		SyntaxNode node = stackForRelopOperations.pop();
		
		
		if (node instanceof Equality) 
		{
				Code.putFalseJump(Code.eq, 0);
				int adr = Code.pc - 2;
				System.out.println("Adresa je " + adr);
				stackForIfAddresses.push(adr);
			
		}
			
		if (node instanceof Difference) 
		{
			Code.putFalseJump(Code.ne, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
		if (node instanceof Less)
		{
			Code.putFalseJump(Code.lt, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
	
		if (node instanceof Less_or_equal)
		{
			Code.putFalseJump(Code.le, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
		if (node instanceof Greater_or_equal)
		{
			Code.putFalseJump(Code.ge, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
			
		}
		
		
		if (node instanceof Greater)
		{
			Code.putFalseJump(Code.gt, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
		
		}	
	
		}catch(EmptyStackException e) {
			Code.loadConst(0);
			Code.putFalseJump(Code.ne, 0);
			int adr = Code.pc - 2;
			System.out.println("Adresa je " + adr);
			stackForIfAddresses.push(adr);
		}
		numberOfAddresses++;
		
	}
	
	public void visit(Equality e)
	{
		stackForRelopOperations.add(e);
		
		
	}
	
	
	public void visit(Difference e)
	{
		stackForRelopOperations.add(e);
	}
	
	public void visit(Less e) 
	{
		stackForRelopOperations.add(e);
	}
	

	public void visit(Less_or_equal e) 
	{
		stackForRelopOperations.add(e);
	}
	

	public void visit(Greater e) 
	{
		stackForRelopOperations.add(e);
	}
	
	

	public void visit(Greater_or_equal e) 
	{
		stackForRelopOperations.add(e);
	}
	
	
	public void visit(RightParentInIF right)
	{
			
	}


	public void visit(ElseInIf elsekk)
	{
		
		
		System.out.println("Addddrr   " + Code.pc);
		
		Code.putJump(0);
		int adr = Code.pc - 2;
		
		int i = 0;
		if (!stackForIfAddresses.isEmpty()) {
			int addrnumber = numberOfAddressesToFix.pop();
		while (i < addrnumber) {
			
			Code.fixup(stackForIfAddresses.pop());
			i++;
		}
		}
		else {
			while(!elseOrAddresses.isEmpty()) 
			{
				Code.fixup(elseOrAddresses.pop());
			}
		}
		
		stackForElseAddresses.push(adr);
		
	}
	
	public void visit(MatchedStatementkdkdkdkd matc)
	
	{
		Code.fixup(stackForElseAddresses.pop());
		
		
	}



	public void visit(UnmatchedIf unmif)
	{
		if (elseOrAddresses.isEmpty()) {
		if (!numberOfAddressesToFix.isEmpty()) {
		int number = numberOfAddressesToFix.pop();
		int i =0;
		while (i < number) {
			Code.fixup(stackForIfAddresses.pop());
			i++;
			
		}
		}
		}
		while(!elseOrAddresses.isEmpty()) 
		{
			Code.fixup(elseOrAddresses.pop());
		
		}
		
	}

	public void visit(UnmatchedIfElse unmatch)
	{
		
		Code.fixup(stackForElseAddresses.pop());
		
	}

	
	public void visit(ConditionOR or)
	{
		conditionOR = false;
		
		
		while(!stackForOrAddresses.isEmpty()) {
			Code.fixup(stackForOrAddresses.pop());
		}
	}
	
	
	public void visit(ConditionWithoutOR cnd)
	{
		numberOfAddressesToFix.push(numberOfAddresses);
		numberOfAddresses = 0;
		if (conditionOR)
		{
			
			Code.putJump(0);
			int adr = Code.pc - 2;
			stackForOrAddresses.push(adr);
			
			int addrnumber = numberOfAddressesToFix.pop();
			int i = 0;
			while(i < addrnumber)
			{
			elseOrAddresses.push(stackForIfAddresses.pop());
			i++;
			}
			
		}
		
	}

	public void visit(CondORStart cond) 
	{
		numberOfAddressesToFix.push(numberOfAddresses);
		numberOfAddresses = 0;
		Code.putJump(0);
		conditionOR = true;
		int adr = Code.pc - 2;
		stackForOrAddresses.push(adr); 
		
		int addrnumber = numberOfAddressesToFix.pop();
		int i = 0;
		while (i < addrnumber) {
			Code.fixup(stackForIfAddresses.pop());
			i++;
		}
	}
	

	///**** FOR ***////
	
	public void visit(ForStatement ff)
	{
		insideFor = false;
		Code.putJump(forAddresses.pop());
	//	forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
	}
	
	public void visit(For rp)
	{
		insideFor = true;
		int adr = Code.pc;
	forAddresses.push(adr);
	SyntaxNode parent = rp.getParent();
	if (parent instanceof ForStatementCondition || parent instanceof ForStatement || parent instanceof ForStatementIncrement /*|| parent instanceof ForStatementInitializationMatched*/)
	{
		continueAddress = Code.pc;
	}
	}
	public void visit(ForStatementInitializationMatched fff)
	{
		insideFor = false;
		Code.putJump(forAddresses.pop());
		//forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
	}
	
	public void visit(ForStatementCondition cond)
	{
		insideFor = false;
		Code.putJump(forAddresses.pop());
		int i = 0;
		if (!stackForIfAddresses.isEmpty()) {
			int addrnumber = numberOfAddressesToFix.pop();
		while (i < addrnumber) {
			
			Code.fixup(stackForIfAddresses.pop());
			i++;
		}
		}
		else {
			while(!elseOrAddresses.isEmpty()) 
			{
				Code.fixup(elseOrAddresses.pop());
			}
	}
		
		//forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
}
	
	public void visit(ForStatementIncrement inc)
	{
		insideFor = false;
		Code.putJump(forAddresses.pop());
		insideFor = false;
		//forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
	}
	
	public void visit(ForStatementInitializationAndCondition fff) 
	{
					
		insideFor = false;
		forAddresses.pop();
		Code.putJump(forAddresses.pop());
		int i = 0;
		if (!stackForIfAddresses.isEmpty()) {
			int addrnumber = numberOfAddressesToFix.pop();
		while (i < addrnumber) {
			
			Code.fixup(stackForIfAddresses.pop());
			i++;
		}
		}
		else {
			while(!elseOrAddresses.isEmpty()) 
			{
				Code.fixup(elseOrAddresses.pop());
			}
	}
	//	forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
	}
	
	public void visit(ForStatementInitializationAndIncrement initialization)
	{
		Code.putJump(forAddresses.pop());
		insideFor = false;
		//forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
	}
	
	
	public void visit(ForInit ff) 
	{
		forAddresses.pop();
		int adr = Code.pc;
		SyntaxNode parent = ff.getParent();
		if (parent instanceof ForStatementInitializationAndCondition || parent instanceof ForStatementInitializationAndIncrement ||  parent instanceof ForStatementInitializationMatched) {
			System.out.println("KSKSKSKSKSKSKSKSSKKSIEIEIE");
			continueAddress = Code.pc;
		}
		forAddresses.push(adr);
	}
	
	public void visit(ForIteration ff)
	{
		int adr;
		int adr1;
		
		
		
		if (!forAddresses.isEmpty())
		{
		 adr =	forAddresses.pop();
		
		
	
		
		if (!forAddresses.isEmpty()) {
		
		adr1 = forAddresses.pop();
		
		Code.putJump(adr1);
		
		 forAddresses.push(adr);
		}else forAddresses.push(adr);
		
		
		}
		
		if (!forJumps.isEmpty())
			Code.fixup(forJumps.pop());
		
	}
	
	
	public void visit(ForCondition forCond)
	{
	Code.putJump(0);
		
		int adr2 = Code.pc - 2;
		forJumps.push(adr2);
		SyntaxNode snode = forCond.getParent();
		int adr;
		if (! (snode instanceof ForStatementCondition)) {
		adr = Code.pc;
		forAddresses.push(adr);
		if (!(snode instanceof ForStatementInitializationAndCondition))
		continueAddress = Code.pc;
		System.out.println("Adresa For Condition     " + adr);
		}
		
	
	if (snode instanceof ForStatementInitializationAndCondition || snode instanceof ForStatementCondition)
	{
		Code.fixup(forJumps.pop());
	}
		//
	}
	public void visit(ForStatementConditionAndIncrement forCond) 
	{
		insideFor = false;
		Code.putJump(forAddresses.pop());
		int i = 0;
		if (!stackForIfAddresses.isEmpty()) {
			int addrnumber = numberOfAddressesToFix.pop();
		while (i < addrnumber) {
			
			Code.fixup(stackForIfAddresses.pop());
			i++;
		}
		}
		else {
			while(!elseOrAddresses.isEmpty()) 
			{
				Code.fixup(elseOrAddresses.pop());
			}
			
			if (breakFound)
			{
				breakFound = false;
				Code.fixup(breakForOr);
			}
	}
		//forAddresses.clear();
	}
	
	public void visit(ForStatementInitializationIncrementAndCondition ff)
	{
		
		insideFor = false;
		Code.putJump(forAddresses.pop());
		int i = 0;
		if (!stackForIfAddresses.isEmpty()) {
			int addrnumber = numberOfAddressesToFix.pop();
		while (i < addrnumber) {
			
			Code.fixup(stackForIfAddresses.pop());
			i++;
		}
		}
		else {
			while(!elseOrAddresses.isEmpty()) 
			{
				Code.fixup(elseOrAddresses.pop());
			}
	}
	//	forAddresses.clear();
		if (breakFound)
		{
			breakFound = false;
			Code.fixup(breakForOr);
		}
	}
	
	
	public void visit(BreakStatement brk)
	{
		Code.putJump(0);
		breakFound = true;
		breakForOr = Code.pc - 2;
	}


	public void visit(ContinueStatement cnt)
	{
		//Code.putJump(0);
		Code.putJump(continueAddress);
		
	}
			
		/**** FOREACH *****/
	
	
	public void visit(ForEachIdent ident)
	{
			Code.loadConst(0);
			Code.store(ObjForLoopingInForEach);
			//foreach loop address
			foreachloopaddress = Code.pc;
			
		 identInForEach = ident.obj;
		
			
	}
	public void visit(ForEachDesignator des)
	{
		Code.load(ObjForLoopingInForEach);
		Code.load(des.obj);
		Code.put(Code.arraylength);
		Code.putFalseJump(Code.ne, 0);
		//
		int adr = Code.pc - 2;
		foreachAddressForFix.add(adr);
		//Code.load(des.obj);
		Code.load(des.obj);
		Code.load(ObjForLoopingInForEach);
		if (des.getDesignator().obj.getType().getElemType().getKind() == Struct.Int)
		Code.put(Code.aload);
		else Code.put(Code.baload);
		Code.store(identInForEach);
		
	
		/*
		Code.load(des.obj);
		Code.put(Code.arraylength);
		Code.putFalseJump(Code.ne, 0);
		//
		int adr = Code.pc - 2;
		foreachAddressForFix.add(adr);
		*/
	}
	public void visit(ForEachStatement foreachstmntt)
	{
		
		
		Code.load(ObjForLoopingInForEach);
		Code.loadConst(1);
		Code.put(Code.add);
		
		Code.store(ObjForLoopingInForEach);
		Code.putJump(foreachloopaddress);
		
		Code.fixup(foreachAddressForFix.pop());
	}
}






