package chapter9.sortingrace.sorters;

import chapter9.sortingrace.ArraySorter;

public class SelectionSort implements ArraySorter {

    @Override
    public void sort(int[] arr) {
        int max, maxIndex =0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = arr[0];
            maxIndex=0;
            for (int j = 1; j < arr.length-i ; j++) {

                if (arr[j]>max){
                    max =  arr[j];
                    maxIndex=j;
                }
            }

            arr[maxIndex] = arr[arr.length-i-1];
            arr[arr.length-i-1]= max;
        }
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}
