package chapter5.simplelambdaexpression;

public class Demo {

    static  void printNumber(MyNumber num)
    {
        System.out.println(num);
    }

    public static void main(String[] args) {
        // Anonymous class
        printNumber(new MyNumber() {
            @Override
            public int value() {
                return 123;
            }
        });

        // Lambda expression
        printNumber(()->{ return 123; } );
    }
}
