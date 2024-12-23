package chapter9.producerconsumer;


import java.util.function.Supplier;

public class PrimeFactorizer implements Runnable{
    Supplier<Long> source;


    public PrimeFactorizer(Supplier<Long> source) {
        this.source = source;
    }

    @Override
    public void run() {
        for(;;)
        {
            long prime = source.get();
            factorize(prime);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void factorize(long q) {
        long sqq = MathUtil.squareRoot(q);
        long lf = sqq, hf = sqq;
        for ( ;lf >1 ; lf--) {
            if (MathUtil.isPrime(lf))
                break;
        }
        for ( ;hf <q ; hf++) {
            if (MathUtil.isPrime(hf))
                break;
        }
        System.out.println("Factors of "+ q + " : "+ (lf) + " - " + (hf));
    }
}
