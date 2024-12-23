package chapter5.listUtils;

public class NumberPrinter implements Processor<MyNumber>{
    @Override
    public void process(MyNumber myNumber) {
        System.out.println(myNumber);
    }
}
