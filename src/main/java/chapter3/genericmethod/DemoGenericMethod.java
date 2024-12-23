package chapter3.genericmethod;

import java.util.*;

public class DemoGenericMethod {

    static Set union( Set set1, Set set2)
    {
        Set unionSet = new HashSet();
        unionSet.addAll(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    static <T> Set<T> unionGeneric(Set<T> set1, Set<T> set2)
    {
        Set<T> unionSet = new HashSet<>();
        unionSet.addAll(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    static <T> T max(Collection<T> collection, Comparator<T> comparator)
    {
        T max = null;

        for (T item:collection)
        {
            if (max==null || comparator.compare(max,item)<0)
                max= item;
        }
        return max;
    }

    static <T extends Comparable<T> > T max(Collection<T> collection)
    {
        T max = null;

        for (T item:collection)
        {
            if (max==null || max.compareTo(item)<0)
                max= item;
        }
        return max;
    }


    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set2.add(3);

        Set<Integer> set = unionGeneric(set1,set2);

        for (Object i:set)
            System.out.println(i);

        List<Integer> intList= Arrays.asList(1,5,2,3,8,1);
        System.out.println(max(intList));
        List<Double> doubleList = Arrays.asList(3.7,1.2,6.4);
        System.out.println(max(doubleList));

    }

}
