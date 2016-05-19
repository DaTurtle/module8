lexer grammar DecimalReals;


fragment F : 'f'|'F';
fragment D : 'd'|'D';
fragment Exponent : 'e'|'E';
fragment dot : '.';
fragment digit : '0'..'9';
fragment seperated : (digit* dot digit+) | (digit+ dot digit*);
fragment real : digit+ | seperated E digit+ | digit+ E digit+;

float : real F;
double : real D | real;

