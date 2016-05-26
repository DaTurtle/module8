grammar Ex3v1;

import Ex3Vocab;

expr : expr EXPO expr  # exponent
     | expr PLUS expr  # plus
     | expr EQUAL expr # equal
     | LPAR expr RPAR  # param
     | STRING          # string
     | NUMBER          # number
     | BOOL            # boolean
     ;

