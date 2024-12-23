package chapter9.bigdata;

import utils.Chrono;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LongOperation {
    int[] arr;

    public LongOperation(int len) {
        this.arr = new int[len];
    }

    static void fillArray(int[] arr)
    {
        fillArray(arr,0,arr.length);
    }

    static void fillArray(int[] arr, int min, int max)
    {
        Random r = new SecureRandom();

        for (int i = min; i <max; i++) {

            int s =0;
            for (int j = 0; j < 10000; j++) {
                s += r.nextInt(10000);
            }
            arr[i] = s/10000;
        }
    }

    static void fillArrayParallel(int[] arr, int threadCount)
    {
        int segmentSize=  arr.length/threadCount;
        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        int min=0;
        for (int s = 0; s < threadCount; s++) {
            int finalMin = min;
            es.submit(()->{ fillArray(arr, finalMin,finalMin +segmentSize);});
            min += segmentSize;
        }
        es.shutdown();
        try {
            if (!es.awaitTermination(10, TimeUnit.HOURS))
                System.out.println("The jobs can not be performed..");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static void fillArrayParallelSimple(int[] arr, int threadCount)
    {
        int segmentSize=  arr.length/threadCount;
        int min=0;

        List<Thread> threads = new ArrayList<>();

        for (int s = 0; s < threadCount; s++) {
            int finalMin = min;
            threads.add(new Thread(()->{ fillArray(arr,finalMin,finalMin+segmentSize);}));
            threads.get(threads.size()-1).start();
            min += segmentSize;
        }

        for (Thread t:threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        LongOperation lo = new LongOperation(800);

        fillArray(lo.arr);
        Duration d1 = Chrono.runFor(()->{fillArrayParallelSimple(lo.arr,8);},2);
        System.out.println(Arrays.toString(lo.arr));
        System.out.println("Duration: "+ d1);

        Duration d2 = Chrono.runFor(()->{fillArrayParallel(lo.arr,4);},2);
        System.out.println(Arrays.toString(lo.arr));
        System.out.println("Duration: "+ d2);

        Duration d3 = Chrono.runFor(()->{fillArrayParallel(lo.arr,8);},2);
        System.out.println(Arrays.toString(lo.arr));
        System.out.println("Duration: "+ d3);
    }


}
