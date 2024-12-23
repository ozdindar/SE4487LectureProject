package chapter9.producerconsumer;

public class MathUtil {

    public static long squareRoot(long l)
    {
        for (int i = 1; i <l ; i++) {
            if (i*i>l)
                return i-1;
        }
        return 0;
    }

    public static boolean isPrime(long l)
    {
        if (l<2)
            return false;
        long sql = squareRoot(l);
        for (int i = 2; i <= sql ; i++) {
            if (l%i==0)
                return false;
        }
        return true;
    }
}
