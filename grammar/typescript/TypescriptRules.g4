grammar TypescriptRules;

LINE_COMMENT : '//' .*? '\r'? [\n] -> skip ;
BLOCK_COMMENT: '/*' .*? '*/' -> skip       ;
WHITESPACES  : [ \r\t\n]+ -> skip          ;

String: ('"' (~["] | '\\' .)* '"') | ('\'' (~['] | '\\' .)* '\'');

// Point.
Point : '.'   ;
point : Point ;

// Braces.
LeftBrace  : '{'        ;
RightBrace : '}'        ;
leftBrace  : LeftBrace  ;
rightBrace : RightBrace ;

LeftAngleBracket  : '<'               ;
RightAngleBracket : '>'               ;
leftAngleBracket  : LeftAngleBracket  ;
rightAngleBracket : RightAngleBracket ;

LeftBracket  : '['          ;
RightBracket : ']'          ;
leftBracket  : LeftBracket  ;
rightBracket : RightBracket ;

LeftParenthesis  : '('              ;
RightParenthesis : ')'              ;
leftParenthesis  : LeftParenthesis  ;
rightParenthesis : RightParenthesis ;
leftParen        : LeftParenthesis  ;
rightParen       : RightParenthesis ;

// Equals
StricEquals: '===' ;
Equals     : '=='  ;
Equal      : '='   ;

CallbackAssigment: '=>'  ;
assignment       : Equal ;

// Unpresenting values.
Null     : 'null'      ;
Undefined: 'undefined' ;

// Colon(s).
Colon    : ':' ;
Semicolon: ';' ;
Comma    : ',' ;

isEndingLine: Semicolon ;

Var  : 'var'  ;
Let  : 'let'  ;
Const: 'const';

// bools.
True : 'true'  ;
False: 'false' ;

// Functions.
Function: 'function' ;

// Control statement.
Import: 'import' ;
From  : 'from' ;
New   : 'new'    ;
If    : 'if'     ;
Else  : 'else'   ;
Return: 'return' ;

// Connect sign(s).
AndSign : '&'     ;
OrSign  : '|'     ;
and     : AndSign ;
or      : OrSign  ;

// Operators.
Decrement : '--' ;
Increment : '++' ;

AddisionAssignment       : '+='                                   ;
SubtractionAssignment    : '-='                                   ;
MultiplicationAssignment : '*='                                   ;
DivisionAssignment       : '/='                                   ;
PowAssignment            : '^='                                   ;
addisionAssignment       : AddisionAssignment                     ;
subtractionAssignment    : SubtractionAssignment                  ;
multiplicationAssignment : MultiplicationAssignment               ;
divisionAssignment       : DivisionAssignment                     ;
powAssignment            : PowAssignment                          ;
Plus                     : '+'                                    ;
Minus                    : '-'                                    ;
Multiply                 : '*'                                    ;
Divide                   : '/'                                    ;
Pow                      : '^'                                    ;
plus                     : Plus                                   ;
minus                    : Minus                                  ;
multiply                 : Multiply                               ;
divide                   : Divide                                 ;
pow                      : Pow                                    ;
operator                 : arithmetic | comparing | not           ;

arithmetic : AddisionAssignment       |
             SubtractionAssignment    |
             MultiplicationAssignment |
             DivisionAssignment       |
             PowAssignment            |
             Plus                     |
             Minus                    |
             Multiply                 |
             Divide                   |
             Pow                      ;

// Comparator sign(s).
BreakingAndSign : '&&'              ;
BreakingOrSign  : '||'              ;
Not             : '!'               ;
breakingAnd     : BreakingAndSign   ;
breakingOr      : BreakingOrSign    ;
not             : Not               ;
lessThan        : LeftAngleBracket  ;
moreThan        : RightAngleBracket ;

comparingAnd : and | breakingAnd ;
comparingOr  : or  | breakingOr  ;

comparing : ( comparingAnd | comparingOr | moreThan | lessThan | Equals ) ;

isDefineField: Var | Let | Const ;

Identifier: [a-zA-Z_][a-zA-Z_0-9]*         ;
FullName  : (Identifier '.')+ (Identifier) ;
Number    : [0-9]+('.'[0-9]+)?             ;

fullNameOrIdentifier: FullName | Identifier ;
identifier          : Identifier            ;
fullName            : FullName              ;
number              : Number                ;
bool                : True | False          ;