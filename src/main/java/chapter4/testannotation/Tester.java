package chapter4.testannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {

    static void runTests(String className) throws ClassNotFoundException {

        Class<?> testClass = Class.forName(className);

        int totalTests=0, passedTests=0;

        for (Method method:testClass.getDeclaredMethods())
        {

            if (method.isAnnotationPresent(MyTest.class))
            {
                totalTests++;
                try {
                    method.invoke(null);
                    passedTests++;
                } catch (IllegalAccessException e) {
                    System.out.println( method.getName() + " is not accessible");

                } catch (InvocationTargetException e) {
                    System.out.println(method.getName() + " failed due to an exception");
                } catch (Exception e)
                {
                    System.out.println(method.getName() + " invalid test function.");
                }
            }
        }


        System.out.println(passedTests+ "/"+ totalTests + " is successful");
    }


    static void runIntReturningTests(String className) throws ClassNotFoundException {

        Class<?> testClass = Class.forName(className);

        int totalTests=0, passedTests=0;

        for (Method method:testClass.getDeclaredMethods())
        {

            if (method.isAnnotationPresent(MyIntReturningTest.class))
            {
                totalTests++;
                try {
                    Object returnValue = (Integer) method.invoke(null);
                    int intval= ((Integer)returnValue).intValue();
                    if (method.getAnnotation(MyIntReturningTest.class).returnValue() == intval)
                        passedTests++;
                } catch (IllegalAccessException e) {
                    System.out.println( method.getName() + " is not accessible");

                } catch (InvocationTargetException e) {
                    System.out.println(method.getName() + " failed due to an exception");
                } catch (Exception e)
                {
                    System.out.println(method.getName() + " invalid test function.");
                }
            }
        }


        System.out.println(passedTests+ "/"+ totalTests + " is successful");
    }


    public static void main(String[] args) {
        try {
            runIntReturningTests("chapter4.testannotation.SampleTestClass");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
