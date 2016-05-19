lexer grammar DecimalReals;

FLOAT : REAL F;
DOUBLE : (REAL D) | REAL;
WS : [ \t\n\r] -> skip;

fragment F : 'f'|'F';
fragment D : 'd'|'D';
fragment E : 'e'|'E';
fragment DOT : '.';
fragment NEG : '-';
fragment DIGIT : '0'..'9';
fragment NEGNUM : (DIGIT+) | (NEG (DIGIT+)); //Might be a negative number
fragment SEP : (DIGIT* DOT DIGIT+) | (DIGIT+ DOT DIGIT*); //A number containing a dot i.e. "12.34", "3.", ".5"
fragment NEGSEP : SEP | (NEG SEP);
fragment REAL : (NEGSEP E NEGNUM) | (NEGNUM E NEGNUM) | (NEGSEP) | (NEGNUM); //The number part of a float or double


