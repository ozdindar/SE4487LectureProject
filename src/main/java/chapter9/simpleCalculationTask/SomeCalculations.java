package chapter9.simpleCalculationTask;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.*;

public class SomeCalculations {
    static double hype(double a, double b )
    {
        return Math.sqrt(a*a+b*b);
    }

    static long sum(int n)
    {
        long sum =0;
        for (int i = 1; i < n; i++) {
            sum+=i;
        }
        return sum;
    }

    static long fact(int n)
    {
        long f = 1;
        for (int i = 2; i < n; i++) {
            f *=i;
        }
        return f;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Double> cHyp = ()-> hype(60.0,80.0);
        Callable<Long> cSum = ()-> sum(1000);
        Callable<Long> cFact = ()-> fact(20);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Double> fHyp =  executor.submit(cHyp);
        Future<Long> fsum =  executor.submit(cSum);
        Future<Long> fFact =  executor.submit(cFact);

        System.out.println("Hyp: "+ fHyp.get());
        System.out.println("Sum: "+ fsum.get());
        System.out.println("Fact: "+ fFact.get());

        executor.shutdown();


    }
}
