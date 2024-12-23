package chapter9.producerconsumer;


import java.util.concurrent.Semaphore;

public class LongContainer {

    long val;

    Semaphore semGet;
    Semaphore semPut;

    public LongContainer() {
        semGet = new Semaphore(0);
        semPut = new Semaphore(1);
    }

    public long get() {
        long p;
        try {
            semGet.acquire();
            p = val;
            semPut.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public void put(long p)
    {
        try {
            semPut.acquire();
            val = p;
            semGet.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        val = p;
    }

}
