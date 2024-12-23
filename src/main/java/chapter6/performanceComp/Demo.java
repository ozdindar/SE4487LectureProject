package chapter6.performanceComp;

import utils.Chrono;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Demo {

    static int[] generateArray()
    {
        Random r = new SecureRandom();

        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= r.nextInt();
        }
        return arr;
    }

    static Integer findMaxArray(int[] arr)
    {
        int max= arr[0];
        for (int v :arr) {
            if (v>max)
                max=v;
        }
        return max;
    }

    static Integer findMaxList(List<Integer> list)
    {
        int max= list.get(0);
        for (int v :list) {
            if (v>max)
                max=v;
        }
        return max;
    }

    static Integer findMaxListBoxed(List<Integer> list)
    {
        Integer max= list.get(0);
        for (Integer v :list) {
            if (v>max)
                max=v;
        }
        return max;
    }

    static Integer findMaxStream(int[] arr)
    {
        return IntStream.of(arr).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = generateArray();
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        Duration d1 = Chrono.runFor(Demo::findMaxArray,arr,100);
        Duration d2 = Chrono.runFor(Demo::findMaxList,list,100);
        Duration d3 = Chrono.runFor(Demo::findMaxListBoxed,list,100);
        Duration d4 = Chrono.runFor(Demo::findMaxStream,arr,100);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
    }

}
