grammar Gzero;

// change left recursive rule into right recursive e : (e '+' f) | f;
e : f eprime?;
eprime : '+' f eprime?;
f : ('-' f) | ('-' '-' f) | t;
// change left recursive rule into right recursive t : (t '+' '+') | ID;
t : ID tprime?;
tprime : '+' '+' t?;

ID : [a-z]+;
WS : [ \t\n\r] -> skip;