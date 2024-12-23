package chapter4.operation;

public class Demo {

    public static void main(String[] args) {
        Operation op = Operation.MINUS;

        System.out.println("2 "+ op.toSymbol() + " 3 =" + op.apply(2,3));
    }
}
