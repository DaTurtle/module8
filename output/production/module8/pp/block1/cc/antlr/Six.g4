lexer grammar Six;

@header{package pp.block1.cc.antlr;}

fragment ALPHA : ('a'..'z' | 'A'..'Z');
fragment ALPHANUM : ('a'..'z' | 'A'..'Z' | '0'..'9');

WORD : ALPHA ALPHANUM ALPHANUM ALPHANUM ALPHANUM ALPHANUM;