package chapter9.sortingrace.sorters;

import chapter9.sortingrace.ArraySorter;

public class BubbleSort implements ArraySorter {

    @Override
    public void sort(int[] arr) {
        int t;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i]>arr[j]){
                    t =  arr[i];
                    arr[i]=  arr[j];
                    arr[j]= t;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}