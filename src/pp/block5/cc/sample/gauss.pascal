Program gauss;

Var x, y: Integer;

Begin
    In("x? ", x);
    y := 0;
    While x > 0 Do
    Begin
        y := y+x;
        x := x-1
    End;
    Out("Sum: ", y)
End.