lexer grammar PL1;

@header{package pp.block1.cc.antlr;}

fragment SINGLE : '\"\"';
fragment NOQO : ~(\")

SENTENCE : '\"'(SINGLE | NOQO)*'\"';