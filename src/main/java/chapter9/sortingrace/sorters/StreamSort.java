package chapter9.sortingrace.sorters;

import chapter9.sortingrace.ArraySorter;

import java.util.Arrays;

public class StreamSort implements ArraySorter
{

    @Override
    public void sort(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
    }

    @Override
    public String getName() {
        return "Stream Sort";
    }
}