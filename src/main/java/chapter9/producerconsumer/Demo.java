package chapter9.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    public static void main(String[] args) {

        //LongContainer q = new LongContainer();
        LongQueue queue= new LongQueue(100);

        PrimeGenerator generator = new PrimeGenerator(queue::put);
        PrimeFactorizer factorizer = new PrimeFactorizer(queue::get);



        new Thread(factorizer).start();
        new Thread(generator).start();
        new Thread(()->{
            while(true){
                System.out.println("Queue Size: "+ queue.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
