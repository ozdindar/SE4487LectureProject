package chapter7.assertions;

import java.util.Objects;

public class Demo {

    private void funcpublic(int a, String b)
    {
        if ( a<=0)
            throw new ArithmeticException("the parameter a must be a positive number ");
        Objects.requireNonNull( b,"the parameter b must not be null") ;

        System.out.println("Everything is OK. Function is performed..");
    }
    private void func(int a, String b)
    {
        assert a>0:"the parameter a must be a positive number ";
        assert b!= null : "the parameter b must not be null" ;

        System.out.println("Everything is OK. Function is performed..");
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.funcpublic(1,"2");

        d.funcpublic(0,"Failure");
        d.funcpublic(1,null);
    }
}
