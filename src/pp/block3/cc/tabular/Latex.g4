grammar Latex;

@header{package pp.block3.cc.tabular;}

fragment LCR  : ('l' | 'c' | 'r')+;
fragment ALPHANUM : ('a'..'z' | 'A'..'Z' | '0'..'9');
fragment EOL : [\n\r];

total : (comment | tabular)+;
comment : '%' (ALPHANUM | ' ')*? EOL ;
tabular : (' '*) '\\begin{tabular}{'LCR'}' (' '*) table (' '*) '\\end{tabular}' (' '*) ;
table : row*;
row : (' '*) entry (' '*) ('&' (' '*) entry (' '*) )*  '\\\\' ;
entry : ALPHANUM* ;


WS : [ \t\n\r]+ -> skip;
