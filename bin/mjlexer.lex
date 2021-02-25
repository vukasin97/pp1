
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext());	}
"print" 	{ return new_symbol(sym.PRINT, yytext()); 	}
"return" 	{ return new_symbol(sym.RETURN, yytext()); 	}
"abstract"  { return new_symbol(sym.ABSTRACT, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); 	}
"new"       { return new_symbol(sym.NEW, yytext()); 	}
"+="        {  return new_symbol(sym.PLUSEQUAL, yytext()); }
"-="        {  return new_symbol(sym.MINUSEQUAL, yytext()); }
"++" 		{ return new_symbol(sym.INCREMENT, yytext()); }
"--" 		{ return new_symbol(sym.DECREMENT, yytext()); }

":"         { return new_symbol(sym.COLON, yytext());    }
"'"         { return new_symbol(sym.QUOTE, yytext());   }
"+" 		{ return new_symbol(sym.PLUS, yytext()); 	}
"=" 		{ return new_symbol(sym.EQUAL, yytext()); 	}

"*="        { return new_symbol(sym.MULTIPLYEQUAL, yytext()); }
"/="        { return new_symbol(sym.DIVIDEEQUAL, yytext()); }
"%="        { return new_symbol(sym.MODEQUAL, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); 	}
"."			{ return new_symbol(sym.DOT, yytext()); 	}
"," 		{ return new_symbol(sym.COMMA, yytext()); 	}
"(" 		{ return new_symbol(sym.LPAREN, yytext()); 	}
")" 		{ return new_symbol(sym.RPAREN, yytext()); 	}
"{" 		{ return new_symbol(sym.LBRACE, yytext()); 	}
"}"			{ return new_symbol(sym.RBRACE, yytext()); 	}


"break" 	{ return new_symbol(sym.BREAK, yytext()); 	}




"class"		{ return new_symbol(sym.CLASS, yytext()); 	}

"else" 		{ return new_symbol(sym.ELSE, yytext());  	}

"const"		{ return new_symbol(sym.CONST, yytext()); 	}
"if"        { return new_symbol(sym.IF, yytext()); 		} 
"read" 		{ return new_symbol(sym.READ, yytext()); 	} 

"foreach"   { return new_symbol(sym.FOREACH, yytext()); }
"for"       { return new_symbol(sym.FOR, yytext());		}
"extends"   { return new_symbol(sym.EXTENDS, yytext());	}
"continue"  { return new_symbol(sym.CONTINUE, yytext());}

"-"  		{ return new_symbol(sym.MINUS, yytext());  	}

"*" 		{ return new_symbol(sym.MULTIPLY, yytext()); }


"/" 		{ return new_symbol(sym.DIVIDE, yytext()); }
"%"			{ return new_symbol(sym.MOD, yytext());     }
"==" 		{ return new_symbol(sym.EQUALITY, yytext());  }
"!=" 		{ return new_symbol(sym.DIFFERENCE, yytext()); }
"<"			{ return new_symbol(sym.LESS, yytext());     }
"<=" 		{ return new_symbol(sym.LESS_OR_EQUAL, yytext()); }
">"  		{ return new_symbol(sym.GREATER, yytext()); }
">="        { return new_symbol(sym.GREATER_OR_EQUAL, yytext()); }
"&&" 		{ return new_symbol(sym.LOGICAL_AND, yytext()); }
"||" 		{ return new_symbol(sym.LOGICAL_OR, yytext()); }

"["  		{ return new_symbol(sym.LEFT_SQUARE_BRAC, yytext()); }
"]" 		{ return new_symbol(sym.RIGHT_SQUARE_BRAC, yytext()); }


"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9][0-9]*  { return new_symbol(sym.NUMBER, new Integer (yytext())); }

"true" | "false" {return new_symbol(sym.BOOLCONST, new String (yytext()));}

'([a-z]|[A-Z]|[0-9])' {return new_symbol(sym.CHARCONST, new String (yytext()));}
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	 {return new_symbol (sym.IDENT, yytext()); }


. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }










