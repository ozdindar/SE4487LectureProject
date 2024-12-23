package chapter5.operation;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS("+" ,      (x,y)-> x+y),
    MINUS("-",      (x,y)-> x-y),
    MULTIPLY("X",   (x,y)-> x*y),
    DIVIDE("/",     (x,y)-> x/y);



    final String symbol;
    final DoubleBinaryOperator operation;

    Operation(String symbol,DoubleBinaryOperator operation)
    {
        this.symbol = symbol;
        this.operation = operation;
    }

    String toSymbol()
    {
        return symbol;
    }
}
