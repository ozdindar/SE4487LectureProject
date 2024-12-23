package chapter9.simplethread;

public class SimpleThread extends Thread{

    @Override
    public void run() {
        for (;;)
        {
            System.out.println("Thread-" + getName() + " is running..");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
