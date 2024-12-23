package chapter9.producerconsumer;

import java.util.function.Consumer;

public class PrimeGenerator implements Runnable{
    Consumer<Long> target;

    public PrimeGenerator(Consumer<Long> target) {
        this.target = target;
    }

    @Override
    public void run() {
        for(long l = 2;l<1000000;l++)
        {
            if (MathUtil.isPrime(l)) {
                target.accept(l);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
