package chapter9.simplethread;

public class Demo {

    static void funcA()
    {
        while (true)
            System.out.println("Function A is running");
    }

    static void funcB()
    {
        while (true)
            System.out.println("Function B is running");
    }
    void demoTraditionalThreads()
    {
        SimpleThread st1= new SimpleThread();
        SimpleThread st2= new SimpleThread();

        st1.start();
        st2.start();
    }

    private static void demoThreadWithRunnable() {
        new Thread(Demo::funcA).start();
        new Thread(Demo::funcB).start();
    }

    public static void main(String[] args) {
        demoThreadWithRunnable();
    }


}
