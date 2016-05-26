grammar Number;

num : prf seq | seq  ;
/** Sequence of digits */
seq : dig | dig seq ;
/** Prefix: x stands for hexadecimal, b for boolean */
prf : 'x' | 'b' ;
/** Single digit (hexadecimal range) */
dig : DIGIT ;

/** Digit token */
DIGIT: [0-9A-F];