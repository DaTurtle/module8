grammar Latex;

table : TABLESTART row* TABLEEND;

row : entry (SEP entry)* ENDROW;

entry: ENTRY?;

TABLESTART : WS '\\begin{tabular}{' [lcr]+ '}' WS;
ENDROW : WS '\\\\' WS;
SEP : WS '&' WS;
ENTRY : [A-Za-z0-9]+;
TABLEEND : WS '\\end{tabular}' WS;

COMMENT : '%' ~'\n'* -> skip;

fragment WS : [ \t\n\r]*;