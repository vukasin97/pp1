package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.HashTableDataStructure;
import rs.ac.bg.etf.pp1.ast.ExprAddopRight;








public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;
	boolean array = false;
	boolean newArray = false;
	public int last = 0;
	boolean abstractClassDefinition = false;
	boolean len = false;
	boolean ord = false;
	boolean chr = false;
	Struct typeOfArray = null;
	Obj accessedField = null;
	Obj objectInForEachStatement = null;
	Obj bool = Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool));
	Struct TypeOrVoid = null;


	private Stack<SyntaxNode> stackForOps = new Stack<SyntaxNode>();
	
	ArrayList<Obj> parametersForMethod = new ArrayList<Obj>();
	
	ArrayList<String> namesOfAccessedFields = new ArrayList<String>();
	
	ArrayList<String> abstractClasses = new ArrayList<String>();
	
	ArrayList<String> abstractMethodes = new ArrayList<String>();
	
	
	ArrayList<String> newObjectes = new ArrayList<String>();
	
	ArrayList<Obj> initializedObjects = new ArrayList<Obj>();
	
	boolean extendedClassDefinition = false;
	
	boolean returnFound = false;
	
	Obj currentMethod = null;
	
	Obj currentClass = null;
	 ArrayList<Obj> methodParams = new ArrayList<Obj>();
	//Expression expression = null;
	
	boolean newClassStarted = false;
	
	boolean mulopright = false;
	
	//Obj extendedClassInExpression = null;
	
//	protected Map<String, String> extendedClasses = new LinkedHashMap<String, String>();
	// kljuc ce biti izvedena klasa a objekat koji ce da se vraca je osnovna klasa
	
	HashTableDataStructure fields = new HashTableDataStructure();
	
	boolean InsideFor = false;
	Logger log = Logger.getLogger(getClass());
	Struct currentType = null;
	public int nVars = 0;
	int printCallCount = 0;
	int varDeclCount = 0;
		ArrayList<String> variables = new ArrayList<String>();
		ArrayList<String> constants = new ArrayList<String>();
		
		ArrayList<String> parameters = new ArrayList<String>();
		
		ArrayList<Object> constantValues = new ArrayList<Object>(); 
		
		
		Struct classType = null;
		private boolean squareBrackets;
		private boolean accessToField = false;
		private boolean addopright = false;
		private boolean addopassigning = false;
		private boolean mulopassigning = false;
		
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	

	
    
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	System.out.println("Broj promenljivih u okviru programa je " + nVars);
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    	
    	
    }

    
    public void visit(FormalParamDeclarations sfp) 
    {
    Obj obj = Tab.find(sfp.getIdent());
   
    if (obj == Tab.noObj) {
    //	if (currentClass == null)
    	Obj obj123 = Tab.insert(Obj.Var, sfp.getIdent(), sfp.getType().struct);
    	methodParams.add(obj123);
    }
    else {
    	report_error("Vec je definisana promenljiva sa tim imenom", sfp);
    }
     }
    
    
    
    
    public void visit(FormalParamDeclarationsArray sfp) 
    {
    Obj obj = Tab.find(sfp.getIdent());
    if (obj == Tab.noObj) {
    	Obj obj1 = Tab.insert(Obj.Var, sfp.getIdent(), sfp.getType().struct);
    	methodParams.add(obj1);
    }
    else {
    	report_error("Vec je definisana promenljiva sa tim imenom", sfp);
    }
     }
    
    
    
    
    
    
    
    
    public void visit(Type type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			
    			
    			type.struct = typeNode.getType();
    			currentType = type.struct;
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    }
    

	public void visit(VarDecl varDecl){
	
	}
	
    public void visit(PrintExpression print) {
    	if (!print.getExpr().obj.getType().compatibleWith(Tab.intType) && !print.getExpr().obj.getType().compatibleWith(Tab.charType) && !print.getExpr().obj.getType().compatibleWith(bool.getType()) )
    	{
    		
    		report_error("Tip mora biti int char ili bool", print);
    	}
		printCallCount++;
	}
    
    public void visit(PrintExpAndNumberConst print) 
    {
    	if (!print.getExpr().obj.getType().compatibleWith(Tab.intType) && !print.getExpr().obj.getType().compatibleWith(Tab.charType) && !print.getExpr().obj.getType().compatibleWith(bool.getType()) )
    	{
    		
    		report_error("Tip mora biti int char ili bool", print);
    	}
		printCallCount++;
    }
	
    
    public void visit(FuncCall funcCall){
    	Obj func = funcCall.getDesignator().obj;
    	if(Obj.Meth == func.getKind()){
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.obj = func;
			if (!(funcCall.obj.getName().equals("ord")) && !(funcCall.obj.getName().equals("len"))  && !(funcCall.obj.getName().equals("chr")))
			{
			StructForMethod sfm = (StructForMethod) func.getType();
			
			ArrayList<Obj> parametersInMethod = sfm.getMethodArguments();
			
			for(int i=0; i<parametersInMethod.size(); i++)
			{
				
				//if (!(parametersInMethod.get(i).getType().compatibleWith(parametersForMethod.get(i).getType())
			Obj currObj;
			try {
			currObj = parametersForMethod.get(i);
			}catch(IndexOutOfBoundsException index)
			{
				report_error("Nema dovoljno argumenata za metodu", funcCall);
				break;
			}
			if (!(parametersInMethod.get(i).getType().compatibleWith(parametersForMethod.get(i).getType())))
					{
				if (!(parametersInMethod.get(i).getType().getKind() == parametersForMethod.get(i).getType().getKind()))
				report_error("Tipovi nisu kompatibilni u pozivu funkcije", funcCall
						);
					}
			}
    	}else {
    		if (this.len) {
    			len = false;
    			if (this.parametersForMethod.size() > 1)
    				report_error("Broj argumenata u okviru len funkcije mora biti jedan", funcCall);
    		}
    		else if (this.ord)
    		{
    			ord = false;
    			if (this.parametersForMethod.size() > 1)
    				report_error("Broj argumenata u okviru len funkcije mora biti jedan", funcCall);
    		}
    		else if (this.chr)
    		{
    			chr = false;
    			if (this.parametersForMethod.size() > 1)
    				report_error("Broj argumenata u okviru len funkcije mora biti jedan", funcCall);
    		}
    	}
    	}else{
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
		//	funcCall.struct = Tab.noType;
    	}
    	
    	namesOfAccessedFields.clear();
    	parametersForMethod.clear();
    }
    
	
	public void visit(ConstDeclNumber constDecl) 
	
	{
		
	if (!constDecl.getType().getTypeName().equals("int")) {
		report_error("Konstanta mora biti deklarisana kao int a ne kao " + constDecl.getType().getTypeName(), null);
		
	}
	else {
		
	for (int i = 0; i < constants.size(); i++) {
			
			Obj varNode = Tab.insert(Obj.Con, constants.get(i), constDecl.getType().struct);
			initializedObjects.add(varNode);
			Integer intValue = (Integer)(constantValues.get(i));
			report_info("Vrednost konstante je" + intValue.toString(), constDecl);
			varNode.setAdr(intValue);
		}
		
	}
	constantValues.clear();
	constants.clear();

	}
	
	public void visit(ClassVarDecl cvd) 
	{
		currentClass.getType().setMembers(fields);
	fields = new HashTableDataStructure();
	}
	
	public void visit(VarDeclList1 varDecl) {
	
		report_info("dkakdakdakdkadkadka", varDecl);
		//report_info(variables.toString() + "variable", null);
		Obj varNode;
		/*
				if (currentMethod != null && currentClass != null) {
					Tab.insert(Obj.Var, "this", new Struct(Struct.Class));
					report_info("This parametear", varDecl);
		
				}
		*/
		for (int i = 0; i < variables.size(); i++) {
			if (currentClass != null) {
				if (currentMethod == null) {
					report_info("Polja klase", varDecl);
				Obj obj = Tab.insert(Obj.Fld, variables.get(i), currentType);
			if (!fields.insertKey(obj)) 	{
				report_error("Ne mogu se dva polja isto zvati u klasi", varDecl);
											}
										}
				else {
					report_info("Metoda nije null" + currentMethod.getName(), varDecl);
				}
			}
			else
			{
				
			varNode = Tab.insert(Obj.Var, variables.get(i), currentType);
			
			report_info("DKAKDAKDKAKAD", varDecl);
			}
														}
		
		variables.clear();
	}
	public void visit(ConstDeclString stringConst) 
	{
		
	if (!stringConst.getType().getTypeName().equals("char")) {
		errorDetected = true;
		report_error("Konstanta mora biti deklarisana kao char a ne kao " + stringConst.getType().getTypeName(), null);
		
		
	}
	else {
		
	for (int i = 0; i < constants.size(); i++) {
			
			Obj varNode = Tab.insert(Obj.Con, constants.get(i), stringConst.getType().struct);
			String intValue = (String)(constantValues.get(i));
			char s = intValue.charAt(0);
			report_info("Vrednost konstante je" + intValue.toString(), stringConst);
			varNode.setAdr((int)s);
		}
		
	}
	constantValues.clear();
	constants.clear();
		}
	public void visit(Sametyperecursive stpr) {
		Obj alreadyDeclared = Tab.find(stpr.getVarName());
		if (alreadyDeclared.equals(Tab.noObj)) {
		varDeclCount++;
	//	report_info("Deklarisana promenljiva "+ stpr.getVarName(), stpr);
		variables.add(stpr.getVarName());
		report_info("Deklarisana promenljiva "+ stpr.getVarName(), stpr);
		
	} 
		else {
			report_error("Promenljiva je vec deklarisana", stpr);
		}
	}
	
	public void visit(Sametypeident stpr) {
		varDeclCount++;
		Obj alreadyDeclared = Tab.find(stpr.getVarName());
		if (alreadyDeclared.equals(Tab.noObj)) { 
		report_info("Deklarisana promenljiva "+ stpr.getVarName(), stpr);
		variables.add(stpr.getVarName());
		}
		else {
			report_error("Promenljiva je vec deklarisana", stpr);
		}
		
	}
	
	public void visit(SametypeIdentBrackets stpr) {
		varDeclCount++;
		Obj alreadyDeclared = Tab.find(stpr.getVarName());
		if (alreadyDeclared.equals(Tab.noObj)) { 
		report_info("Deklarisana promenljiva "+ stpr.getVarName(), stpr);
		currentType = new Struct(Struct.Array, currentType);
		variables.add(stpr.getVarName());
		}
		else {
			report_error("Promenljiva je vec deklarisana", stpr);
		}
		
	}
	
	public void visit(SameTypeSquareBrackets stpr) {
		varDeclCount++;
		Obj alreadyDeclared = Tab.find(stpr.getVarName());
		if (alreadyDeclared.equals(Tab.noObj)) { 
		report_info("Deklarisana promenljiva "+ stpr.getVarName(), stpr);
		currentType = new Struct(Struct.Array, currentType);
		array = true;
		variables.add(stpr.getVarName());
		}
		else {
			report_error("Promenljiva je vec deklarisana", stpr);
		}
		
	}
	
	
	
	public void visit(ConstDeclBool booleanConst) {
		if (!booleanConst.getType().getTypeName().equals("bool")) {
			errorDetected = true;
			report_error("Konstanta mora biti deklarisana kao bool a ne kao " + booleanConst.getType().getTypeName(), null);
			
			
		}
		else {
			
			for (int i = 0; i < constants.size(); i++) {
					
					Obj varNode = Tab.insert(Obj.Con, constants.get(i), bool.getType());
					String intValue = (String)(constantValues.get(i));
					if (intValue.equals("true")) {
						varNode.setAdr(1);
					}
					else {
						varNode.setAdr(0);
					}
					report_info("Vrednost konstante je" + intValue.toString(), booleanConst);
					//varNode.setAdr(Integer.parseInt(intValue));
				}
				
			}
		
		constantValues.clear();
		constants.clear();
		
	}
	
	public void visit(SametypeConstants1 constants1) {
		
	Obj alreadyDeclared = Tab.find(constants1.getConstantIdent());
		if (alreadyDeclared.equals(Tab.noObj)) { 
			constants.add(constants1.getConstantIdent());
			constantValues.add(constants1.getNum());
			// dodati constants1 value i u adr deo ubacivati vrednosti konstanti
		report_info("Deklarisana promenljiva "+ constants1.getConstantIdent(), constants1);
		//variables.add(stpr.getVarName());
		}
		else {
			report_error("Promenljiva je vec deklarisana", constants1);
		}
		
		
	}
	
	public void visit(SametypeConstants2 constants1) {
		
	Obj alreadyDeclared = Tab.find(constants1.getConstantIdent());
		if (alreadyDeclared.equals(Tab.noObj)) { 
			constants.add(constants1.getConstantIdent());
			constantValues.add(constants1.getNum());
		report_info("Deklarisana promenljiva "+ constants1.getConstantIdent(), constants1);
		//variables.add(stpr.getVarName());
		}
		else {
			report_error("Promenljiva je vec deklarisana", constants1);
		}
		
		
	}
	
	
	public void visit(SametypeConstantsIdent1 constants1) {
	
		Obj alreadyDeclared = Tab.find(constants1.getConstantIdent());
			if (alreadyDeclared.equals(Tab.noObj)) {
				constants.add(constants1.getConstantIdent());
				constantValues.add(constants1.getC1());
			report_info("Deklarisana promenljiva "+ constants1.getConstantIdent(), constants1);
			//variables.add(stpr.getVarName());
			} else {
				report_error("Promenljiva je vec deklarisana", constants1);
			}
			
	}
	
	
	
	public void visit(SametypeConstantsIdent2 constants1) {
		
		Obj alreadyDeclared = Tab.find(constants1.getConstantIdent());
			if (alreadyDeclared.equals(Tab.noObj)) {
				constants.add(constants1.getConstantIdent());
				constantValues.add(constants1.getC1());
			report_info("Deklarisana promenljiva "+ constants1.getConstantIdent(), constants1);
			//variables.add(stpr.getVarName());
			} else {
				report_error("Promenljiva je vec deklarisana", constants1);
			}
			
	}
	
	
	
	public void visit(SametypeConstantsBool1 constants1) {
		
		Obj alreadyDeclared = Tab.find(constants1.getConstantIdent());
			if (alreadyDeclared.equals(Tab.noObj)) {
				constants.add(constants1.getConstantIdent());
				constantValues.add(constants1.getBoolconst());
			report_info("Deklarisana promenljiva "+ constants1.getConstantIdent(), constants1);
			//variables.add(stpr.getVarName());
			} else {
				report_error("Promenljiva je vec deklarisana", constants1);
			}
			
	}
	
	  public void visit(Const cnst){
	    	cnst.obj = new Obj(Obj.Con, "cnst", Tab.intType);
	    	cnst.obj.setAdr(cnst.getN1());
	    	cnst.obj.setLevel(0);
	    }
	    
    public void visit(TermOnlyFactor term){
    	
    	term.obj = term.getFactor().obj;
  if (this.len)
  {
	  if (term.obj.getType().getKind() != Struct.Array)
	  {
		  report_error("U okviru len funkcije mora se koristiti niz", term);
	  }
  }
  if (this.chr)
  {
	  if (term.obj.getType().getKind() != Struct.Int)
	  {
		  report_error("U okviru chr funkcije izraz mora biti tipa int", term);
	  }
  }
  if (this.ord)
  {
	  if (term.obj.getType().getKind() != Struct.Char)
	  {
		  report_error("U okviru len funkcije izraz mora biti tipa char", term);
	  }
  }
    }
    
    public void visit(TermExpr termExpr){
    //	if (termExpr.getTerm().struct.getKind() == Struct.Int) { 
    	termExpr.obj = termExpr.getTerm().obj;
    	//}
   // else {
    		//report_error("Mora biti int", termExpr);
    //	}
   }
	

    
    public void visit(AddExpr addExpr){
    	Obj te = addExpr.getExprLeft().obj;
    	Obj t = addExpr.getTerm().obj;
    	
    	//Obj t = addExpr.getExpr().obj;
    	//Obj te = addExpr.getTerm().obj;
    	// 22 / 5 / 2020 zamenjeni operandi te i t radi provere za Nemanjin izraz vratit ako ne rade svi testovi
    	// odma vraceno 22 / 5 8:18
//   	SyntaxNode syntnode = stackForOps.pop();
    	/*
    	if (syntnode instanceof RightAddop) {
    		//addopright = false;
    		System.out.println("Ovde jeeejej getExprjdjdjdjdjddjjdjdjd");
    if (te.getKind() != Obj.Elem && te.getKind() != Obj.Fld && te.getKind() != Obj.Var) 
    {
    	System.out.println(te.getKind());
    report_error("U izrazu sa desne strane mora biti promenljiva, polje klase ili element niza", addExpr);	
   
    	// zbog preklapanja treba ovo promeniti !!!!!!!!! dodacemo kasnije
    }
    if(te.getType().equals(t.getType())  && te.getType() == Tab.intType){
		addExpr.obj = te;
	}else {
		report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
	}
    	}
    	*/
    	/*else*/ if(te.getType().equals(t.getType()) && te.getType().assignableTo(Tab.intType)){
    		addExpr.obj = te;
    	}else{
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			//addExpr.struct = Tab.noType;
    	}
    }
    public void visit(ExprLeftInAddopRight expraddop) {
    	expraddop.obj = expraddop.getExprLeft().obj;
    }
    public void visit(TermRightRepetition1 termrep) {
    	termrep.obj = termrep.getTermRight().obj;
    }
    
    public void visit(ExprAddopRight expraddop) {
    	Obj t = expraddop.getExpr().obj;
    	Obj te = expraddop.getExprLeft().obj;
    	//SyntaxNode syntnode = stackForOps.pop();
    	//if (syntnode instanceof RightAddop) {
    		//addopright = false;
    		System.out.println("Ovde jeeejej getExprjdjdjdjdjddjjdjdjd");
    if (te.getKind() != Obj.Elem && te.getKind() != Obj.Fld && te.getKind() != Obj.Var) 
    {
    	System.out.println("Ime promenljive u addopright je " + te.getName());
    	System.out.println("Vrednost konstante je  "  + te.getAdr());
    report_error("U izrazu sa desne strane mora biti promenljiva, polje klase ili element niza", expraddop);	
   
    	// zbog preklapanja treba ovo promeniti !!!!!!!!! dodacemo kasnije
    }
    if(te.getType().equals(t.getType())  && te.getType() == Tab.intType){
		expraddop.obj = te;
	}else {
		report_error("Greska na liniji "+ expraddop.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
	}
    //	}

    }
    
    public void visit(TermRightRepetition termrightrep) {
    	//SyntaxNode syntnode = stackForOps.pop();
    	Obj t = termrightrep.getTermRight().obj;
    	Obj te = termrightrep.getTerm().obj;
    	
     //	if (syntnode instanceof RightMulop) {
    		//mulopright = false;
    		System.out.println("Mulopping ");
    if (t.getKind() != Obj.Elem && t.getKind() != Obj.Fld && t.getKind() != Obj.Var) 
    {
    report_error("U izrazu sa desne strane mora biti promenljiva, polje klase ili element niza", termrightrep);	
    }
    if(te.getType().equals(t.getType()) && te.getType() == Tab.intType){
		termrightrep.obj = te;
	}else {
		report_error("Greska na liniji "+ termrightrep.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
	}
   // 	}
    }
    public void visit(TermRepetition termrep) 
    {
    	Obj te = termrep.getFactor().obj;
    	Obj t = termrep.getTermRight().obj;
    //	SyntaxNode syntnode = stackForOps.pop();
    	if (this.len) 
    	  if (te.getType().getKind() != Struct.Array)
    	  {
    		  report_error("U okviru len funkcije mora se koristiti niz", termrep);
    	  }
    	if (this.chr) 
      	  if (te.getType().getKind() != Struct.Int)
      	  {
      		  report_error("U okviru chr funkcije izraz mora biti tipa int", termrep);
      	  }
    	if (this.ord) 
      	  if (te.getType().getKind() != Struct.Char)
      	  {
      		  report_error("U okviru ord funkcije izraz mora biti tipa char", termrep);
      	  }
    	/*
    	if (syntnode instanceof RightMulop) {
    		//mulopright = false;
    		System.out.println("Mulopping ");
    if (t.getKind() != Obj.Elem && t.getKind() != Obj.Fld && t.getKind() != Obj.Var) 
    {
    report_error("U izrazu sa desne strane mora biti promenljiva, polje klase ili element niza", termrep);	
    }
    if(te.getType().equals(t.getType()) && te.getType() == Tab.intType){
		termrep.obj = te;
	}else {
		report_error("Greska na liniji "+ termrep.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
	}
    	}
    	*/
    	/*else*/ if(te.getType().equals(t.getType()) && te.getType() == Tab.intType){
    		termrep.obj = te;
    	}else{
			report_error("Greska na liniji "+ termrep.getLine()+" : nekompatibilni tipovi u izrazu za mulop.", null);
			//termrep = Tab.noType; mozda se vratim
    	}
    	
    	
    	
    }
    
    public void visit(MinusTermExpr mte) {
    	if (mte.getTerm().obj.getType().getKind() == Struct.Int) { 
    	mte.obj = mte.getTerm().obj;
    	}
    	else {
    		report_error("Tip mora biti int", mte);
    	}
    }
	
    
    
    public void visit(DesignatorDot2 dd1) 
    {
    	// provera da li je polje klase
    	// Obj obj = Tab.find(dd1.getIdent());
    	 
    	 //if (!(obj != Tab.noObj && obj.getKind() == Obj.Fld)) {
    		// report_error("Mora se pristupati polju klase", dd1);
    	 													
    	 		//
    //	}
    
    	namesOfAccessedFields.add(dd1.getIdent());
    	
    	 accessToField  = true;
    	 
    	 
    }
    
    public void visit(DesignatorIncrement desinc) {
    	Obj foundDesignator = Tab.find(desinc.getDesignator().getDesIdent());
    	if (!(initializedObjects.contains(foundDesignator))) {
    		report_error("Identifikator u izrazu mora biti inicijalizovan", desinc);
    	}
    	switch (desinc.getDesignator().obj.getKind()) {
    	case Obj.Fld : report_info("Field", desinc);
    			if (desinc.getDesignator().obj.getType().getKind() != Struct.Int) {
    		
    		report_error("Promenljiva mora biti tipa int", desinc);
    	}
    	break;
    	case  Obj.Elem: report_info("Array", desinc);
    			if (desinc.getDesignator().obj.getType().getKind() != Struct.Int) {
    		
    				report_error("Promenljiva mora biti tipa int", desinc);
    	}// vratiti se ovde kada postavis dodatne informacije
    	break;
    	case Obj.Var: report_info(" " +foundDesignator.getType().getKind(), desinc);
    	if (desinc.getDesignator().obj.getType().getKind() != Struct.Int) {
    		
    		report_error("Promenljiva mora biti tipa int", desinc);
    	}
    	break;
    	default :
    		report_error("Promenljiva nije odgovarajuce vrste" + " ", desinc);
    	}
    	
    	namesOfAccessedFields.clear();
    }
    
    
    
    public void visit(DesignatorDecrement desinc) {
    	Obj foundDesignator = Tab.find(desinc.getDesignator().getDesIdent());
    	if (!(initializedObjects.contains(foundDesignator))) {
    		report_error("Identifikator u izrazu mora biti inicijalizovan", desinc);
    	}
    	switch (desinc.getDesignator().obj.getKind()) {
    	case Obj.Fld : report_info("Field", desinc);
    			if (desinc.getDesignator().obj.getType().getKind() != Struct.Int) {
    		
    		report_error("Promenljiva mora biti tipa int", desinc);
    	}
    	break;
    	case  Obj.Elem: report_info("Array", desinc);
    			if (desinc.getDesignator().obj.getType().getKind() != Struct.Int) {
    		
    				report_error("Promenljiva mora biti tipa int", desinc);
    	}// vratiti se ovde kada postavis dodatne informacije
    	break;
    	case Obj.Var: report_info(" " +foundDesignator.getType().getKind(), desinc);
    	if (desinc.getDesignator().obj.getType().getKind() != Struct.Int) {
    		
    		report_error("Promenljiva mora biti tipa int", desinc);
    	}
    	break;
    	default :
    		report_error("Promenljiva nije odgovarajuce vrste" + " ", desinc);
    	}
    	namesOfAccessedFields.clear();
    }
    
    
  
    
    public void visit(DesignatorDot1 dd1) {
    	
    	 squareBrackets = true;
    	if  (dd1.getExpr().obj.getType().getKind() != Struct.Int) 
    	{
    		
    		report_error("Izraz unutar [      ] mora biti tipa Int", dd1);
    	}
    	else {
    		report_info("Int", dd1);
    	}
    //	if (dd1.get)
    }
    public void visit(Designator des) {
    	Obj obj = Tab.find(des.getDesIdent());
    	boolean ElemObj = false;
    	boolean fieldObj = false;
    	Iterator<String> iterator = namesOfAccessedFields.iterator();
    	Collection<Obj> locals;
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + des.getDesIdent()+ " : ime "+des.getDesIdent()+" nije deklarisano! ", des);
    	}
    	else {
    	/*	if (squareBrackets) {
    			squareBrackets = false;
    			if (!obj.getType().equals(new Struct(Struct.Array))) {
    				report_error("Greska na liniji identifikator mora biti tipa niz", null);
    				
    				
    			}
    		}
    		*/
    		Obj currentClassToCheck = obj;
    		if (accessToField) {
    			accessToField = false;
    			if (obj.getType().getKind() != Struct.Class) {
    				report_error("Mora se pristupati polju klase", des);
    			}
    			else {
    				boolean behindNothing = false;
    				for(;iterator.hasNext();) {
    					if (behindNothing) {
    						report_error("Nakon poziva klasne metode ne sme se pristupati odma poljima klase", null);
    						break;
    					}
    					// za sad nemamo staticka polja
    					if (!(newObjectes.contains(currentClassToCheck.getName()))) {
    					
    						report_error("Objekat se mora inicijalizovati da bi se pristupalo njegovim poljima", des);
    					}
    				StructForClass sfc = (StructForClass)currentClassToCheck.getType();
    				Scope scope = sfc.getScope();
    				String currentString = iterator.next();
    			Obj foundedSymbol = scope.findSymbol(currentString);
    			if (foundedSymbol == null) {
    				report_error("Taj simbol ne pripada opsegu klase", null);
    				// dodati proveru da li je field
    										}else 
    					{
    		if (foundedSymbol.getKind() == Obj.Meth) {
    			behindNothing = true;
    		}
    		else	if (foundedSymbol.getKind() != Obj.Fld) 
    					report_error("Simbol nije polje", null);
    					}
    			currentClassToCheck = foundedSymbol;
    			des.obj = foundedSymbol;
    		fieldObj = true;
    												}
    					}
    			//namesOfAccessedFields.clear();
    									}
    		if (squareBrackets && !(obj.getType().getKind() == Struct.Array)) {
    			report_error("Greska na liniji identifikator mora biti tipa niz" + "  " +  obj.getType().getKind(), des);
    			
    		}
    		
    		/*else 	if (!squareBrackets && obj.getType().getKind() == Struct.Array) {
    			
    			report_error("Niz se mora koristiti sa zagradama", des);
    		}
    		*/
    	 if (squareBrackets) 
    		{
    			squareBrackets = false;
    			//typeOfArray = obj.getType().getElemType();
    			System.out.println(des.getDesIdent() + "  Array");
    			//StructForElem sfe =   new StructForElem(obj.getType().getElemType().getKind());
    			ObjForElem objElem = new ObjForElem(Obj.Elem, "ELEM"  ,obj.getType().getElemType());
    			report_info(objElem.getName(), des);
    			objElem.setArray(obj);
    			//sfe.setArray(obj);
    			des.obj = objElem;
    			ElemObj =true ;
    			
    		}
    	}
    	if (!(ElemObj || fieldObj))
    	des.obj = obj;
    	
    	if (obj.getName().equals("len")) 
    	{
    		this.len = true;
    		if (!(des.getParent() instanceof FuncCall) && !(des.getParent() instanceof DesignatorActualPars))
    		{
    			report_error("len se mora koristiti kao standardna funkcija za odredjivanje duzine niza", des);
    		}
    	}
    	if (obj.getName().equals("ord")) 
    	{
    		this.ord = true;
    		if (!(des.getParent() instanceof FuncCall) && !(des.getParent() instanceof DesignatorActualPars))
    		{
    			report_error("ord se mora koristiti kao standardna funkcija za odredjivanje vrednosti znaka", des);
    		}
    	}
    	if (obj.getName().equals("chr")) 
    	{
    		this.chr = true;
    		if (!(des.getParent() instanceof FuncCall) && !(des.getParent() instanceof DesignatorActualPars))
    		{
    			report_error("len se mora koristiti kao standardna funkcija za odredjivanje znaka sa nekom int vrednoscu", des);
    		}
    	}
    }
    
    
    
    
    public void visit(SametypeConstantsBool2 constants1) {
		
		Obj alreadyDeclared = Tab.find(constants1.getConstantIdent());
			if (alreadyDeclared.equals(Tab.noObj)) {
				constants.add(constants1.getConstantIdent());
				constantValues.add(constants1.getBoolconst());
			report_info("Deklarisana promenljiva "+ constants1.getConstantIdent(), constants1);
			//variables.add(stpr.getVarName());
			} else {
				report_error("Promenljiva je vec deklarisana", constants1);
			}
			
	}
	
	  public boolean passed(){
	    	return !errorDetected;
	    }
	  
	  
	 public void visit(For f) {
	    	InsideFor = true;
	    	report_info("Koriscenje for petlje", f);
	 }
	 public void visit(BreakStatement brkstmnt) {
		 
		 if (InsideFor == false) {
			 report_error("Break mora biti unutar Fora", brkstmnt);
		 }
	 }
	 
	 public void visit(ContinueStatement cntstmnt) {
		 if (InsideFor == false) {
			 report_error("Continue mora biti unutar Fora", cntstmnt);
		 }
	 }
		 public void visit(ForStatement forstmnt) {
			 
			 InsideFor = false;
		 }
	 
		 public void visit(ForStatementInitializationMatched forstmnt) {
			 InsideFor = false;
		 }
		 public void visit(ForStatementCondition forstmnt) {
			 InsideFor = false;
		 }
		 
		 public void visit(ForStatementIncrement forstmnt) {
			 InsideFor = false;
		 }
		 
		 public void visit(ForStatementInitializationAndCondition forstmnt) {
			 InsideFor = false;
		 }
		 
		 
		 public void visit(ForStatementInitializationAndIncrement forstmnt) {
			 InsideFor = false;
		 }
		 

		 public void visit(ForStatementConditionAndIncrement forstmnt) {
			 InsideFor = false;
		 }

		 public void visit(ForStatementInitializationIncrementAndCondition forstmnt) {
			 InsideFor = false;
		 }
		 
		 
		 public void visit(CondFactNoRelop mte) 
		 {
			mte.struct = mte.getExpr().obj.getType();
			 
			 
		 
		 }
		 
		 public void visit(CondFactRelop mte) 
		 {
			 if (!mte.getCondFact().struct.compatibleWith(mte.getExpr().obj.getType()))
				report_error("Tipovi moraju biti kompatibilni", mte);
			 else {
				 mte.struct = bool.getType();
				 
			 }
		 }
		 
		 public void visit(CondTermAnd mte) {

			 if (!mte.getCondFactInTerm().struct.compatibleWith(mte.getCondTerm().struct)) {
				 if (!(mte.getCondFactInTerm().struct.getKind() == mte.getCondTerm().struct.getKind()))
				report_error("Tipovi moraju biti kompatibilni", mte);
			
			 }
			 else {
				 mte.struct = bool.getType();
				 
			 }
			 
		 }
		 public void visit(CondFactInTerm cond)
		 {
			 cond.struct = cond.getCondFact().struct;
		 }
		 
		 public void visit(ConditionWithoutOR cor) {
			 cor.struct = cor.getCondTerm().struct;
		 }
		 
		 public void visit(ConditionOR mte) {
		
					 mte.struct = bool.getType();
					 
				 
		 }
		 public void visit(CondTermFact mte) {
			 mte.struct = mte.getCondFact().struct;
			 
		 }
		 public void visit(CondORStart cond) {
			 cond.struct = cond.getCondTerm().struct;
		 }
		 
	  public void visit(Var var){
	    	var.obj = var.getDesignator().obj;
	    	if		(		!initializedObjects.contains(var.obj) && var.obj.getType().getKind() != Struct.Class && !(currentMethod != null && !currentMethod.getName().equals("main")))
	    	{
	    		if (!(var.getDesignator().getDesIdent().equals("eol")))
	    	report_error("Identifikator u izrazu mora biti inicijalizovan", var);
	    	}
	    	
	    //	extendedClassInExpression = var.getDesignator().obj;
	    	
	    	report_info("Type je " + var.getDesignator().obj.getType().getKind() + " ", null);
	    	
	    	
	    	if (currentMethod != null && methodParams.size() != 0) 
	    	{
	    		if (methodParams.contains(var.obj))
	    			report_info("Koriscenje formalnog argumenta funkcije", var);
	    	}
	    	//report_info("Ime objekta izvedene klase je" + extendedClassInExpression.getName(), var);
	    }
	  
	 
	   public void visit(MethodDeclType methodDecl){
	    	if(!returnFound && currentMethod.getType().getKind() != Struct.None){
				report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
	    	}
	    	StructForMethod sfm =(StructForMethod)currentMethod.getType();
	    	sfm.setMethodArguments(methodParams);
	    	currentMethod.setLevel(methodParams.size());
	    	methodParams.clear();
	    	Tab.chainLocalSymbols(currentMethod);
	    	Tab.closeScope();
	    	
	    	returnFound = false;
	    	currentMethod = null;
	    	namesOfAccessedFields.clear();
	    }
	   
	    
	 
	   public void visit(MethodTypeName methodTypeName){
		   
	    	if (extendedClassDefinition) {
	    		if (Tab.currentScope().findSymbol(methodTypeName.getMethName()) != null)
	    		{
	    			StructForClass sfc = (StructForClass) currentClass.getType();
	    			sfc.addAbstractMethod(methodTypeName.getMethName());
	    			System.out.println("Ovde je");
	    			Tab.currentScope().getLocals().deleteKey(methodTypeName.getMethName());
	    			
	    			//Iterator<Obj> iteratorMethodDelete;
	    			//Collection<Obj> collectionDelete;
	    			
	    			//iteratorMethodDelete = Tab.currentScope().getLocals().symbols().iterator();
	    			//for(;iteratorMethodDelete.hasNext();) 
	    			//{
	    				//report_info("Ostali elementi  " + iteratorMethodDelete.next().getName() + " ", methodTypeName);
	    			//}
	    			
	    		}
	    	}
	   	if (TypeOrVoid.getKind() ==  Struct.None) {
	   		System.out.println("Struct None");
	   		StructForMethod sfm = new StructForMethod(Struct.None);
	    		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), sfm);
	    		
	    	}
	    	else {
	    		StructForMethod sfm = new StructForMethod(TypeOrVoid.getKind());
	    		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), sfm);
	    	}
	    	methodTypeName.obj = currentMethod;
	    	Tab.openScope();
	    	Struct s;
	    	s = new Struct(Struct.Class, fields);
	    	//s.setMembers(fields);
	    	if (currentClass != null) {
    			Tab.insert(Obj.Var, "this", currentClass.getType());
    		}
			report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	    
	    
	    }
	    
	   
	   public void visit(ReturnExpr returnExpr){
	    	returnFound = true;
	    	StructForMethod currMethType = (StructForMethod) currentMethod.getType();
	    	if (currMethType != null && returnExpr.getExpr().obj != null) 
	    	if(!currMethType.compatibleWith(returnExpr.getExpr().obj.getType())){
				report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName() + " " + currentMethod.getType().getKind() + "  " + returnExpr.getExpr().obj.getType().getKind(), null);
	    	}
	    }
	    
	    
	    public void visit(DesignatorAssignOp des) {
	    	if (objectInForEachStatement != null) 
	    	{
	    		if (des.getDesignator().obj == objectInForEachStatement)
	    			report_error("Ne sme se upisivati u iterator u okviru foreach", des);
	    	}
	    		if (addopassigning || mulopassigning) {
	    			if (addopassigning)
	    			addopassigning = false;
	    			else 
	    				if (mulopright)
	    				mulopright = false;
	    		if (des.getDesignator().obj.getKind() != Obj.Elem &&  des.getDesignator().obj.getKind() != Obj.Var && des.getDesignator().obj.getKind() != Obj.Fld)
	    		{
	    			report_error("U izrazu sa desne strane mora biti element niza, polje klase ili promenljiva", des);
	    			
	    		}
	    		 if(des.getDesignator().obj.getType().equals(des.getExpr().obj.getType()) && des.getExpr().obj.getType() == Tab.intType){
	    				report_info("Izraz je dobar", des);
	    				if(	!(initializedObjects.contains(des.getDesignator().obj)))
	    						{
	    					initializedObjects.add(des.getDesignator().obj);
	    						}
	    			}else {
	    				report_error("Greska na liniji "+ des.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
	    			}
	    	
	    		}
	    		else if (newArray) {
	    			newArray = false;
	    		Obj noObj = Tab.find(des.getDesignator().getDesIdent());
	    		initializedObjects.add(des.getDesignator().obj);
	    		
	    	if (noObj.getType().getKind() != Struct.Array) {
	    		report_error("Tip mora biti NIZ", des);
	    	}
	    	else {
	    		if (noObj.getType().getElemType().getKind() != currentType.getKind()) {
	    			report_error("Tip elementa u naredbi new mora biti isti kao tip elementa niza", des);
	    		}
	    		// vraticemo se u toku zadnje faze
	    	}
	    	}
	    	else 
	    		
	    		if(!des.getExpr().obj.getType().assignableTo(des.getDesignator().obj.getType()))
	    		{
	    			boolean isOk = false;
	    			System.out.println("Kompatibilan je za dodelu  " + des.getDesignator().getDesIdent());
	    			
	    			System.out.println(des.getExpr().obj.getType().getKind() + "  " + des.getDesignator().obj.getType().getKind());
	    			if (des.getExpr().obj.getType().getKind() == Struct.Class) 
	    			{
	    		//	String nameOfObject = extendedClassInExpression.get
	    				
	    			
	    				// newClassStarted = false;
	    				report_info("Klasni tip extended klas " + des.getDesignator().getDesIdent(), null);
	    			}
	    		report_error("Greska na liniji " + des.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! " + "tip je" + des.getDesignator().obj.getType().getKind(), null);
	    
	    		}else {
	    			if (des.getDesignator().obj.getType().getKind() == Struct.Class)
	    			{
	    				System.out.println("dkdkdkdkgwrisgjfqjfgjfkqdkqfkqfkqfjwifrf");
	    				if (!newClassStarted) {
	    						if (!(newObjectes.contains(des.getExpr().obj.getName()))) {
	    							report_error("Objekat sa desne strane mora biti inicijalizovan", null);
	    						}else {
	    							newObjectes.add(des.getDesignator().getDesIdent());
	    						}
	    				//	newObjectes.add(des.getDesignator().getDesIdent());
	    				}
	    				
	    				else {
	    			    			newObjectes.add(des.getDesignator().getDesIdent());
	    			    			newClassStarted = false;
	    			    			System.out.println("New Object added");
	    			    			System.out.println(des.getDesignator().getDesIdent());
	    						}
	    			}else 	if(	!(initializedObjects.contains(des.getDesignator().obj)))
					{
				initializedObjects.add(des.getDesignator().obj);
				System.out.println(des.getDesignator().obj.getName());
					}
	    			System.out.println(des.getDesignator().obj.getName() + " LEFT SIDE ");
	    		}
	    		
	    	namesOfAccessedFields.clear();	
	    }
	    	
	    
	    
	    
	    
	    
	    public void visit(NewTypeNoExpression newclass) {
	    	if (newclass.getType().struct.getKind() != Struct.Class) {
	    		report_error("Tip mora biti klasa", null);
	    		
	    	}
	    	
	    	newClassStarted = true;
	    	if (abstractClasses.contains(newclass.getType().getTypeName())) {
	    		report_error("Greska ne moze se instancirati apstraktna klasa", newclass);
	    	}
	    	//currentType = newclass.getType().struct;
	    	newclass.obj = new Obj(Obj.Var, "newObj", currentType);
	    }
	    
	   
	    
	    
	    
	    public void visit(NewTypeExpression newclass) 
	    {
	    	if (newclass.getExprInNewArray().obj.getType().getKind() != Struct.Int) {
	    		report_error("Izraz mora biti tipa int", newclass);
	    	}
	    	//initializedObjects.add(newclass.g)
	    	newArray = true;
	    	
	    	//expression = newclass.getExpr().;
	    	newclass.obj = new Obj(Obj.Var, "newObj", currentType);
	    }
	    public void visit(ExprInNewArray expr)
	    {
	    	expr.obj = expr.getExpr().obj;
	    }
	    
	    public void visit(ClassIdentNoExtend cie) {
	    	StructForClass sfc = null;
	    	Obj obj = Tab.find(cie.getIdent());
	    	//cie.struct = new Struct(Struct.Class);
	    	
	    if (obj == Tab.noObj) {
	    	sfc = new StructForClass(Struct.Class);
	    
	    	
	    	currentClass = Tab.insert(Obj.Type, cie.getIdent(), sfc);
	    	//sfc.setClassObj(currentClass);
	    //	Tab.openScope();
	    }
	    
	    else {
	    	if (obj.getType().getKind() != Struct.Class) {
	    		report_error("Ne mogu postojati dve klase sa istim imenom", cie);
	    	}
	    	 sfc = new StructForClass(Struct.Class);
	    	
	    	
	    	currentClass = Tab.insert(Obj.Type, cie.getIdent(), sfc);	
	    	sfc.setClassObj(currentClass);
	    	//	Tab.openScope();
	    }
	  //  cie.obj = currentClass;

	    Tab.openScope();
	    if (sfc != null)
	    sfc.setScope(Tab.currentScope);
	    report_info("Obradjuje se klasa " + cie.getIdent(), cie);
	    // vratiti se ovde
	    }
	    
	    
	    public void visit(ClassDeclarationWithNoExtended cdne) {
	    	
	    	Tab.chainLocalSymbols(currentClass);
	    	Tab.closeScope();
	    	
	    	currentClass = null;
	    	
	    }
	    
		public void visit(ClassIdentExtend cie) {
			boolean isOk = false;
			Obj obj1;
	    	Obj obj = Tab.find(cie.getIdent());
	    	//cie.struct = new Struct(Struct.Class);
	    	
	    	Collection<Obj> pomFields;
			Iterator<Obj> iterator;
			Collection<Obj> allLocals;
			Iterator<Obj> iterator2 = null;
			Collection<Obj> removedLocals;
	    if (obj == Tab.noObj) {
	    	//currentClass = Tab.insert(Obj.Type, cie.getIdent(), new Struct(Struct.Class));
	    //	Tab.openScope();
	    	isOk = true;
	    }
	    
	    else {
	    	if (obj.getType().getKind() != Struct.Class) {
	    		report_error("Ne mogu postojati dve klase sa istim imenom", cie);
	    	}
	    	//currentClass = Tab.insert(Obj.Type, cie.getIdent(), new Struct(Struct.Class));
	    	isOk = true;
	    //	Tab.openScope();
	    }
	    StructForClass sfc = null;
	    if (isOk) {
	    	
	    	 obj1 = Tab.find(cie.getType().getTypeName());
			report_info("Type name je " + cie.getType().getTypeName() + " ", cie);
			if (obj1.getKind() == Obj.Type) {
				
				report_info("Zapocinje deklaracija izvedene klase", cie);
		    	 sfc = new StructForClass(Struct.Class);
				currentClass = Tab.insert(Obj.Type, cie.getIdent(), sfc);
				
				sfc.setBaseClass(cie.getType().struct);
				//sfc.setClassObj(currentClass);
			//	extendedClasses.put(currentClass.getName(), cie.getType().getTypeName());
					if (currentClass == null) {
						report_info("Klasa je null", cie);
					}
				
					allLocals = obj1.getLocalSymbols();
					removedLocals = new ArrayList<>();
					iterator2 = allLocals.iterator();
					for(; iterator2.hasNext();) {
						removedLocals.add(iterator2.next());
					}
				/*	for(;iterator2.hasNext();) {
						report_info(iterator2.next().getName() + "KLASNI CLANOVI",null);  
					}
					*/
				pomFields = obj1.getType().getMembersTable().symbols();
		
				iterator = pomFields.iterator();
				for(;iterator.hasNext();) {
					Obj obj123 = iterator.next();
					fields.insertKey(obj123);
					removedLocals.remove(obj123);
				}
				iterator2 = removedLocals.iterator();
			
			//	fields = new HashTableDataStructure(pomFields.symbols());
				
				isOk = false;
				
			}
	    }
	    extendedClassDefinition = true;
	  cie.obj = currentClass;
	  // cie.struct = currentClass.getType();
	   Tab.openScope();
	   if (sfc != null)
	   sfc.setScope(Tab.currentScope);
	   for(;iterator2.hasNext();) 
	   {
		   	Obj objMethod = iterator2.next();
		   	Tab.insert(Obj.Meth, objMethod.getName(), objMethod.getType());
		 //  Collection<Obj> methodLocals = objMethod.getLocalSymbols();
		  // Iterator<Obj> methodIterator = methodLocals.iterator();
		   //for(; methodIterator.hasNext();) 
		   //{
			 //  report_info("Lokalni simboli metode su  " + methodIterator.next().getType().getKind() + "   tipa" +  " ", cie);
		//   }
	   }
	   // Tab.currentScope = new Scope(obj1.)
	    report_info("Obradjuje se klasa " + cie.getIdent(), cie);


}
	    
	    
	    
	    public void visit(ClassDeclarationWithExtended cdie) {
	    	
	    		
	    	StructForClass sfc = (StructForClass)currentClass.getType();
	    	Scope scope = sfc.getScope();
	    	String nameOfBaseClass = cdie.getClassIdentExtend().getType().getTypeName();
	    	Iterator<String> iterator;
	    	if (abstractClasses.contains(nameOfBaseClass)) {
	    	iterator = abstractMethodes.iterator();
	    	
	    	ArrayList<String> overidedAbs = sfc.getAbstractMethods();
	    	String elem = iterator.next();
	    	while(!elem.equals(nameOfBaseClass)) elem =iterator.next();
	    	// mozda se vratim
	    	while (iterator.hasNext()) {
	    		elem = iterator.next();
	    		if (elem.equals(nameOfBaseClass)) break;
	    		if (!(overidedAbs.contains(elem))) 
	    		{
	    			report_error("Klasa koja ne extenduje sve metode apstraktne klase mora biti apstrakt", null);
	    		}
	    		// ce se vrnem
	    	//	Obj thisObj = new Obj(Obj.Var, "this", currentClass.getType());
	    	//	if (!(found.getLocalSymbols().contains(thisObj))) {
	    			//		report_error("Klasa ne extenduje sve metode apstraktne klase " + found.getName() + " "+ found.getLocalSymbols().toString(), cdie);
	    		//}
	    	}
	    	}
	    	Tab.chainLocalSymbols(currentClass);
	    	Tab.closeScope();
	    	
	    	currentClass = null;
	    	
	    	extendedClassDefinition = false;
	    														}
	    
	    
	    
	    public void visit(AbstractClassStartDefinition acsd) 
	    {
	    	Obj obj = Tab.find(acsd.getIdent());
	    	
	    			if (obj == Tab.noObj)
	    			{
	    				currentClass = Tab.insert(Obj.Type, acsd.getIdent(), new Struct(Struct.Class));
	    				abstractClasses.add(acsd.getIdent());
	    				abstractMethodes.add(acsd.getIdent());
	    				
	    			}
	    			else 
	    			{
	    				if (obj.getKind() != Obj.Type)
	    				{
	    					currentClass = Tab.insert(Obj.Type, acsd.getIdent(), new Struct(Struct.Class));
		    				abstractClasses.add(acsd.getIdent());
		    				abstractMethodes.add(acsd.getIdent());
	    				}
	    				else {
	    					report_error("Ne mogu postojati dve klase sa istim imenom --> ime klase" + acsd.getIdent() + " ", acsd);
	    				}
	    			}
	    			
	    			Tab.openScope();
	    			
	    			abstractClassDefinition = true;
	    }
	   
	    
	    
	    public void visit(AbstractClassDeclarationNoExtended acd) {
	    	
	    	
	    	
	    	Tab.chainLocalSymbols(currentClass);
	    	Tab.closeScope();
	    	abstractMethodes.add(currentClass.getName());
	    	report_info(currentClass.getName() + "  ", acd);
	    	currentClass = null;
	    	abstractClassDefinition = false;
	    	
	    	
	    }
	    
    public void visit(AbstractClassDeclarationNoExtendedNoMethods acd) {
	    	
	    	
	    	
	    	Tab.chainLocalSymbols(currentClass);
	    	Tab.closeScope();
	    	abstractMethodes.add(currentClass.getName());
	    	report_info(currentClass.getName() + "  ", acd);

	    	currentClass = null;
	    	abstractClassDefinition = false;
	    }
   
    public void visit(TypeAndIdentInMethod amdt) 
    
    {
    	 
    	if (extendedClassDefinition) {
    		if (Tab.currentScope().findSymbol(amdt.getMethName()) != null)
    		{
    			Obj foundedObj= Tab.currentScope().findSymbol(amdt.getMethName());
    			if (foundedObj == null)
    			System.out.println("NULL JE");
    			
    			Tab.currentScope().getLocals().deleteKey(amdt.getMethName());
    			
    			//Iterator<Obj> iteratorMethodDelete;
    			//Collection<Obj> collectionDelete;
    			
    			//iteratorMethodDelete = Tab.currentScope().getLocals().symbols().iterator();
    			//for(;iteratorMethodDelete.hasNext();) 
    			//{
    				//report_info("Ostali elementi  " + iteratorMethodDelete.next().getName() + " ", methodTypeName);
    			//}
    			
    		}
    	}
    	Obj obj = Tab.find(amdt.getMethName());
    	
    	if (obj == Tab.noObj)
    	{
    	currentMethod =	Tab.insert(Obj.Meth, amdt.getMethName(), TypeOrVoid);
    		
    		abstractMethodes.add(amdt.getMethName());
    		
    		Tab.openScope();
    		
    	
    	}
    	
    	else {
    		report_error("Vec postoji promenljiva sa tim imenom", amdt);
    		
    		 }
    	
    }
    
    public void visit(AbstractMethodDeclarationType amdt)
    {

    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	currentMethod = null;
    	
    }
  
    
    public void visit(TypeVoid tov) 
    {
    	
    	 TypeOrVoid = tov.getType().struct;
    	
    }
    public void visit(VoidType tov)
    {
    	System.out.println("Ovde jejejejejeeejdlajfajaj");
    	TypeOrVoid = Tab.noType;
    }
	    
	    public void visit(AbstractClassStartDefinitionExtends cie)
	    {
	    	Iterator<Obj> iterator2 = null;
	    	String name = cie.getType().getTypeName();
	    	Obj obj =  Tab.find(name);
	    	if (obj == Tab.noObj)
	    	{
	    		report_error("Tip nije definisan", cie);
	    		return;
	    		
	    	}
	    			
	    Collection<Obj> allLocals;
	    Iterator<Obj> iterator;
	    Collection<Obj> pomFields;
	    
	    Obj obj1 = Tab.find(cie.getType().getTypeName());
		report_info("Type name je " + cie.getType().getTypeName() + " ", cie);
		if (obj1.getKind() == Obj.Type) {
	    	currentClass = Tab.insert(Obj.Type, cie.getIdent(), new Struct(Struct.Class));
			if (currentClass == null) {
				report_info("K"
						+ "lasa je null", cie);
			}
		
			allLocals = obj1.getLocalSymbols();
			
		/*	for(;iterator2.hasNext();) {
				report_info(iterator2.next().getName() + "KLASNI CLANOVI",null);  
			}
			*/
		pomFields = obj1.getType().getMembersTable().symbols();
		
		iterator = pomFields.iterator();
		for(;iterator.hasNext();) {
			Obj obj123 = iterator.next();
			fields.insertKey(obj123);
			allLocals.remove(obj123);
		}
		iterator2 = allLocals.iterator();
	    	
	    }
		
		 Tab.openScope();
		 for(;iterator2.hasNext();) 
		   {
			   	Obj objMethod = iterator2.next();
			   	Tab.insert(Obj.Meth, objMethod.getName(), objMethod.getType());
			 //  Collection<Obj> methodLocals = objMethod.getLocalSymbols();
			  // Iterator<Obj> methodIterator = methodLocals.iterator();
			   //for(; methodIterator.hasNext();) 
			   //{
				 //  report_info("Lokalni simboli metode su  " + methodIterator.next().getType().getKind() + "   tipa" +  " ", cie);
			//   }
		   }
		 report_info("Pocinje obrada apstraktne klase", cie);
		 extendedClassDefinition = true;
		 abstractClassDefinition = true;
	    }
	    
	    public void visit(Plus plus)
	    {
	    //	stackForOps.push(plus);
	    }
	    public void visit(Minus minus)
	    {
	    	//stackForOps.push(minus);
	    }
	    
	    public void visit(AbstractClassDeclarationWithExtended acd) 
	    {
	    	Tab.chainLocalSymbols(currentClass);
	    	Tab.closeScope();
	    	abstractMethodes.add(currentClass.getName());
	    	report_info(currentClass.getName() + "  ", acd);
	    	currentClass = null;
	    	abstractClassDefinition = false;
	    	extendedClassDefinition = false;
	    }
	   
	    
	    public void visit(AbstractClassDeclarationWithExtendedNoMethods acd) 
	    {
	    	Tab.chainLocalSymbols(currentClass);
	    	Tab.closeScope();
	    	abstractMethodes.add(currentClass.getName());
	    	report_info(currentClass.getName() + "  ", acd);
	    	currentClass = null;
	    	abstractClassDefinition = false;
	    	extendedClassDefinition = false;
	    }
	    		
	    public void visit(ReadStatement read) 
	    {
	    	if (read.getDesignator().obj.getKind() != Obj.Elem && read.getDesignator().obj.getKind() != Obj.Var && read.getDesignator().obj.getKind() != Obj.Fld)
	    {
	    	report_error("Identifikator unutar read mora biti element, objekat ili promenljiva", null);
	    	
	    }
	    	else 		{
	    		
	    		
	    		if (read.getDesignator().obj.getType().getKind() != Struct.Char && read.getDesignator().obj.getType().getKind() != Struct.Int && read.getDesignator().obj.getType().getKind() != Struct.Bool)
	    		{
	    			report_error("Identifikator mora biti tipa int, char ili bool", null);
	    		}
	    				}
	    	
	    	initializedObjects.add(read.getDesignator().obj);
	    		
	    				
	    
	    }
	    
	    public void visit(CharConst chr)
	    {
	    	Obj obj = new Obj(Obj.Con, "charConst", Tab.charType);
	    	obj.setAdr(chr.getC1().charAt(1));
	    	chr.obj = obj;
	    	System.out.println("Vrednost chara je" + chr.obj.getAdr());
	    }
	    public void visit(ActualParams ap) 
	    {
	    
	    	parametersForMethod.add(ap.getExpr().obj);
	    	
	    	
	    }
	    
	    public void visit(ActualParam ap)
	    {
	    	
	    	parametersForMethod.add(ap.getExpr().obj);
	    	
	    }
	    
	    public void visit(DesignatorActualPars dap) 
	    {
	    	
	    	Obj obj = dap.getDesignator().obj;
	    	if (!(obj.getName().equals("ord")) && !(obj.getName().equals("len"))  && !(obj.getName().equals("chr")))
	    	{
	    	if (obj.getKind() == Obj.Meth)
	    	{
	    			StructForMethod sfm = (StructForMethod) obj.getType();
	    			
	    			ArrayList<Obj> parametersInMethod = sfm.getMethodArguments();
	    			
	    			for(int i=0; i<parametersInMethod.size(); i++)
	    			{
	    				
	    				//if (!(parametersInMethod.get(i).getType().compatibleWith(parametersForMethod.get(i).getType())
	    			Obj currObj;
	    			try {
	    			currObj = parametersForMethod.get(i);
	    			}catch(IndexOutOfBoundsException index)
	    			{
	    				report_error("Nema dovoljno argumenata za metodu", dap);
	    				break;
	    			}
	    			if (!(parametersInMethod.get(i).getType().compatibleWith(parametersForMethod.get(i).getType())))
	    					{
	    				report_error("Tipovi nisu kompatibilni", dap);
	    					}
	    			}
	    
	    	}
	    	
	    	}else {
	    		if (this.len)
	    		{
	    			len = false;
	    			if (parametersForMethod.size() > 1)
	    				report_error("Broj argumenata u okviru len mora biti jedan", dap);
	    		}
	    		else if (this.ord)
	    		{
	    			ord = false;
	    			report_error("Broj argumenata u okviru ord mora biti jedan", dap);
	    		}
	    		else if (this.chr) 
	    		{
	    			chr = false;
	    			report_error("Broj argumenata u okviru chr mora biti jedan", dap);
	    		}
	    	}
	    	parametersForMethod.clear();
	    	
	    	namesOfAccessedFields.clear();
	    }
	    	
	    
	    public void visit(ExpressionInParanthesis express)
	    {
	    	
	    	express.obj = express.getExpr().obj;
	    }
	    
			public void visit(BoolConstants boolConst)
			{
				
				Obj obj = new Obj(Obj.Con, "boolConst", bool.getType());
				boolConst.obj = obj;
				//boolConst.obj.setAdr(boolConst.getB1());
				if (boolConst.getB1().equals("true")) {
					boolConst.obj.setAdr(1);
					
				}
				else {
					boolConst.obj.setAdr(0);
					
				}
			}
	    	public void visit(RightAddop rightAddOp)
	    	{
	    		System.out.println("RightAddop in Expr");
	    		stackForOps.push(rightAddOp);
	    		this.addopright  = true;
	    		//last = 3;
	    	}
	    	
	    	public void visit(RightAssignigWithAdding rightAddop)
	    	{
	    		//stackForOps.add(rightAddop);
	    		System.out.println("RightAdd Assigning");
	    		//this.addopright  = true;
	    		this.addopassigning = true;
	    		//last = 4;
	    	}
	    	public void visit(RightAssignigWithMul mul)
	    	{
	    		/// dodati za mull
	    		System.out.println("Mulop Assigning");
	    		this.mulopassigning = true;
	    	}
	    	/*
	    	public void visit(RightMulop mul)
	    	{
	    		stackForOps.push(mul);
	    		System.out.println("MulopRight in Expr ");
	    		//this. = true;
	    	}
	    	*/
	    	/*
	    	public void visit(LeftMulop left)
	    	{
	    		stackForOps.push(left);
	    	}
	    	*/
	    	
	   // 	public void visit(LeftAddop add) 
	    //	{
	    	//	stackForOps.push(add);
	    	//}
	    	
	

/******* FOREACH ANALYSE *****/
	    	
	    	public void visit(ForEachIdent ident)
	    	{
	    		
	    		// find object in table
	    		Obj object= Tab.find(ident.getI1());
	    		
	    		if (object == Tab.noObj) {
	    			report_error("Promenlji sa tim imenom se ne moze koristiti u okviru foreach", ident);
	    		}
	    		if (object.getKind() != Obj.Var)
	    		{
	    			report_error("Mora se koristiti promenljiva u okviru foreach", ident);
	    		}
	    		 ident.obj = object;
	    		 objectInForEachStatement = ident.obj;
	    		 if (!(initializedObjects.contains(ident.obj)))
	    		 {
	    			 initializedObjects.add(ident.obj);
	    		 }
	    	}

	    		public void visit(ForEachDesignator des)
	    		{
	    			
	    			if (des.getDesignator().obj.getType().getKind() != Struct.Array) 
	    			{
	    				report_error("U okviru foreach petlje mora se iterirati kroz niz", des);
	    			}
	    			des.obj = des.getDesignator().obj;
	    		}
	    		
	    		public void visit(ForEachStatement stmnt)
	    		{
	    			/// const provera
	    			objectInForEachStatement = null;
	    			Obj identobj = stmnt.getForEachIdent().obj;
	    			Obj arrayobj = stmnt.getForEachDesignator().obj;
	    			if (identobj.getType().getKind() != arrayobj.getType().getElemType().getKind())
	    			{
	    				report_error("Tip promenljive u okviru foreach petlje i tip niza mora biti isti", stmnt);
	    			}
	    		}

}
	    
	    
	    
	    

