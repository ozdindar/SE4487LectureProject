package chapter4.testannotation;

public class SampleTestClass {


    static void func1()
    {
        System.out.println("func1 is performed..");
    }

    @MyTest
    static void func2()
    {
        System.out.println("func2 is performed..");
    }

    @MyTest
    private static void func3()
    {
        System.out.println("func3 is performed..");
    }

    @MyTest
    static void func4()
    {
        System.out.println("func4 is performed..");
        throw new RuntimeException("BOOM");
    }

    @MyTest
    void func5()
    {
        System.out.println("func5 is performed..");
    }

    @MyIntReturningTest(returnValue = 5)
    static int func6()
    {
        System.out.println("func6 is performed...");
        return 4;
    }
}
