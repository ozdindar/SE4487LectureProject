package chapter9.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class LongQueue {
    ArrayBlockingQueue<Long> queue;

    public LongQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    void put(long l)
    {
        try {
            queue.put(l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    long get()
    {
        long l;
        try {
            l =queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    public int size() {
        return queue.size();
    }
}
