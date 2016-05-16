grammar CC4AGAIN;

l: r A | q B A;
r: A B A r2 | C A B A r2;
r2: B C r2| ;
q: B q2;
q2: B C | C;

A: 'a';
B: 'b';
C: 'c';