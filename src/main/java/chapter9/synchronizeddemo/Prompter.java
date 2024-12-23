package chapter9.synchronizeddemo;

public class Prompter {
    synchronized void prompt(String message) throws InterruptedException {
        System.out.print("[");
        Thread.sleep(100);
        System.out.print(message);
        Thread.sleep(100);
        System.out.println("]");
    }
}
