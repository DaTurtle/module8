lexer grammar Lala;

@header{package pp.block1.cc.antlr;}

LA: ('L')('a')+(' ')*;
LALA: LA LA;
LALALALI: LALA LA ('L')('i');

SENTENCE: (LA|LALA|LALALALI)+;