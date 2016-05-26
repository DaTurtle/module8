grammar Ex3v2;

import Ex3Vocab;

expr returns [ Type type ]
  : t0=expr EXPO t1=expr
    { $type = ($t0.type == Type.NUM && $t1.type == Type.NUM) ?
        Type.NUM :
        ($t0.type == Type.STR && $t1.type == Type.NUM) ?
            Type.STR :
            Type.ERR; }
  | t0=expr PLUS t1=expr
    { $type = ($t0.type == $t1.type) ? $t0.type : Type.ERR; }
  | t0=expr EQUAL t1=expr
    { $type = ($t0.type == $t1.type) ? Type.BOOL : Type.ERR; }
  | LPAR expr RPAR
    { $type = $expr.type; }
  | NUMBER
    { $type = Type.NUM; }
  | BOOL
    { $type = Type.BOOL; }
  | STRING
    { $type = Type.STR; }
  ;