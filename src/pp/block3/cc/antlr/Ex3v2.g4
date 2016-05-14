grammar Ex3v2;

import Ex3Vocab;

expr returns
    : e0=expr EXPO e1=expr
           { $val = $e0.val ^ $e1.val; }
    | e0=expr PLUS e1=expr
           { $val = $e0.val + $e1.val; }
    | LPAR e=expr RPAR
           { $val = $e.val; }
    | e0=expr EQUAL e1=expr
           { $e0 = e1; }
    | { System.out.println("Evaluating NUMBER"); }
           NUMBER
           { $val = getValue($NUMBER.text); }
    | MINUS e=expr
           { $val = $e.val * -1; }
         ;