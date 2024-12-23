package chapter4.operation;

public enum Operation {
    PLUS("+"){ double apply(double x, double y) {return x+y;}},
    MINUS("-"){ double apply(double x, double y) {return x-y;}},
    MULTIPLY("X"){ double apply(double x, double y) {return x*y;}},
    DIVIDE("/"){ double apply(double x, double y) {return x/y;}},
    MOD("%"){ double apply(double x, double y) {return x%y;}};

    abstract double apply(double x, double y);

    String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    String toSymbol()
    {
        return symbol;
    }
}
