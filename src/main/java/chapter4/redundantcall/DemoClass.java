package chapter4.redundantcall;

import java.security.SecureRandom;

public class DemoClass implements DemoInterface {


    @Override
    public int calculate1() throws Throwable {
        System.out.println("calculate1 is called");
        return 0;
    }

    @Override
    public int calculate2()throws Throwable{
        System.out.println("calculate2 is called");
        return new SecureRandom().nextInt(3);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new DemoClass();
    }
}
