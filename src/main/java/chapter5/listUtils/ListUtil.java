package chapter5.listUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static<T> List<T> generateList(ObjectGenerator<T> generator, int count)
    {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(generator.generate());
        }
        return list;
    }

    public static<T> void tarverseList(List<T> list, Processor<T> processor)
    {
        for (T t:list)
            processor.process(t);
    }

    public static void main(String[] args) {

        // 1st way direct usage of an existing class
        List<MyNumber> numbers1 = generateList(new MyNumberGenerator(),5);
        tarverseList(numbers1,new NumberPrinter());

        // 2nd way anonymous classes
        List<MyNumber> numbers2 = generateList(new ObjectGenerator<MyNumber>() {
            @Override
            public MyNumber generate() {
                return MyNumber.random();
            }
        },5);
        tarverseList(numbers2, new Processor<MyNumber>() {
            @Override
            public void process(MyNumber myNumber) {
                System.out.println(myNumber);
            }
        });

        // 3rd way : lambda expression
        List<MyNumber> numbers3 = generateList(()->new MyNumber(123),5);
        tarverseList(numbers3,(x)->{System.out.println(x);});

        // 4th way : method reference to constructor
        List<MyNumber> numbers4 = generateList(MyNumber::new,5);


        // static method reference
        List<MyNumber> numbers5 = generateList(MyNumber::random,5);

        MyNumber number = new MyNumber(1.0);

        // non static method reference
        List<MyNumber> numbers6 = generateList(number::copy,5);
        tarverseList(numbers6, System.out::println );


    }
}
