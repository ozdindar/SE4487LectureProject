package chapter9.sortingrace.sorters;

import chapter9.sortingrace.ArraySorter;

import java.util.Arrays;

public class ParallelStreamSort implements ArraySorter
{

    @Override
    public void sort(int[] arr) {
        arr = Arrays.stream(arr).parallel().sorted().toArray();
    }

    @Override
    public String getName() {
        return "P-Stream Sort";
    }
}
