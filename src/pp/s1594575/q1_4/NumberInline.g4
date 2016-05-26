grammar NumberInline;

import Number;




digit returns [int val]
  : DIGIT {
    char c = $DIGIT.getText().charAt(0);
    $val = c - (c < ’A’ ? ’0’ : ’A’);
  }
  ;

prf returns [char ch]
  : 'b'
    {$ch = 'b'; }
  | 'x'
    {$ch = 'x'; }
  ;

num returns  [int val]
  : s=seq
    { $val = s.val(''); }
  | p=prf s=seq
    { $val = s.val(p.ch); }
  ;