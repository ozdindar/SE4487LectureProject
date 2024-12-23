package chapter8.boxedtypes;

import utils.Chrono;

import java.time.Duration;
import java.util.Collections;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo {

    static long calculateBoxed()
    {
        Long sum = 0L;
        for (long l = 0; l < Integer.MAX_VALUE; l++) {
            sum += l;
        }
        return sum;
    }

    static long calculatePrimitive()
    {
        long sum = 0L;
        for (long l = 0; l < Integer.MAX_VALUE; l++) {
            sum += l;
        }
        return sum;
    }

    static long calculateStream()
    {
       return LongStream.range(1,Integer.MAX_VALUE).sum();
    }

    public static void main(String[] args) {
        //Duration db = Chrono.runFor(Demo::calculateBoxed,1);
        Duration dp = Chrono.runFor(Demo::calculatePrimitive,10);
        Duration ds = Chrono.runFor(Demo::calculateStream,10);

        //System.out.println("Boxed     : "+db);
        System.out.println("Primitive : "+dp);
        System.out.println("Stream    : "+ds);
    }


}
