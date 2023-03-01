grammar Mxstar;

program : ( funcDef | varDef';' | classDef)*;

classDef :Class ID '{'(funcDef | constructFuncDef | varDef ';')*'}' ';';
funcDef : returnType ID '(' (funcVarDef (',' funcVarDef)*)? ')' part;
lambdaFunc : '[' '&' ']' ('(' (funcVarDef (',' funcVarDef)*)? ')')? '->' part '(' (expr (',' expr)*)? ')';
funcVarDef : varType oneVarDef;
varDef : varType oneVarDef (',' oneVarDef)* ;
constructFuncDef : ID '(' (funcVarDef (',' funcVarDef)*)? ')' part;
oneVarDef : ID ('=' expr )?;

stmt
    : part                                                                          # partstmt
    | varDef ';'                                                                    # varDefstmt
    | If '(' expr ')' st1=stmt (Else st2=stmt)?                                     # ifstmt
    | For '(' (varDef | init = expr)? ';' cond = expr? ';' next = expr? ')' stmt    # forstmt
    | While '(' expr ')' stmt                                                       # whilestmt
    | Return expr? ';'                                                              # returnstmt
    | Continue ';'                                                                  # continuestmt
    | Break ';'                                                                     # breakstmt
    | expr ';'                                                                      # exprstmt
    | ';'                                                                           # semistmt
    ;
part : '{' stmt* '}';


expr
    : primary                                                       # primaryexpr
    | '(' expr ')'                                                  # exprinexpr
    | New newType ('(' expr? ')')?                                  # newexpr
    | expr '[' expr ']'                                             # arrexpr
    | expr '(' (expr (',' expr)*)? ')'                              # funcexpr
    | expr '.' ID                                                   # classexpr
    | <assoc=right> expr op = ('++' | '--')                         # suffixexpr
    | <assoc=right> op = ('++' | '--') expr                         # prefixexpr
    | op = ('!' | '~')  expr                                        # prefixexpr
    | op = ('+' | '-')  expr                                        # prefixexpr
    | expr op = ('*' | '/' | '%') expr                              # binaryexpr
    | expr op = ('+' | '-') expr                                    # binaryexpr
    | expr op = ('<<' | '>>') expr                                  # binaryexpr
    | expr op = ('<' | '<=' | '>' | '>=') expr                      # binaryexpr
    | expr op = ('==' | '!=') expr                                  # binaryexpr
    | expr op = ('&'|'|'|'^') expr                                  # binaryexpr
    | expr op = ('&&'|'||')  expr                                   # binaryexpr
    | <assoc=right> expr '=' expr                                   # assignexpr
    | lambdaFunc                                                    # lambdaexpr
    ;


returnType : Void | varType;
varType : basicType ('[' ']')*;
newType : basicType ('[' expr ']')* ('[' ']')*;
basicType
    : ID
    | Bool
    | Int
    | String
    ;
//atom
primary
    : ID
    | Number 
    | Null
    | This
    | True
    | False
    | ConstString
    ;

//2.keyword
Int : 'int';
Bool : 'bool';
String : 'string';
Void : 'void';

New : 'new';
Class : 'class';

Null : 'null';
True : 'true';
False : 'false';
This : 'this';

If : 'if';
Else : 'else';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';

ConstString : '"' ('\\"' | '\\''\\'  | .)*? '"';
ID : [a-zA-Z][a-zA-Z0-9_]*;
Number : [1-9][0-9]* | '0';
//3.whitespace
Whitespace : [ \t]+ -> skip;
//4.comment
LineComment : ('\r' '\n'? | '\n') -> skip;
BlockComment : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip;
