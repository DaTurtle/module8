grammar Calc;

expr: '(' expr ')'                  #parentheses
 | <assoc=right> expr '^' expr      #exponantion
 | expr '*' expr                    #multiplication
 | expr '+' expr                    #addition
 | '-' expr                         #negation
 | NUM                              #number
 ;

NUM: [0-9]+;
WS: [ \t\n\r] -> skip;