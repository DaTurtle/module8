lexer grammar Ex3Vocab;

EXPO  : '^';
PLUS  : '+';
EQUAL : '=';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;
STRING : [0-9a-zA-Z]+;
BOOL   : [true] | [false];

// ignore whitespace
WS : [ \t\n\r] -> skip;