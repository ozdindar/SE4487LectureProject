package chapter5.listUtils;

public class MyNumberGenerator implements ObjectGenerator<MyNumber>{
    @Override
    public MyNumber generate() {
        return new MyNumber(3.0);
    }
}
