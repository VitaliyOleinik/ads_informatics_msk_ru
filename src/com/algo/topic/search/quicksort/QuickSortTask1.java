package com.algo.topic.search.quicksort;

public class QuickSortTask1 {

    static int[] arr;

    private static void quickSort(int left, int right) {
        int i = left;
        int j = right;
        int pointer = arr[(left + right) / 2];

        while (i < j) {
            while (arr[i] < pointer) {
                i++;
            }
            while (arr[j] > pointer) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(left, j);
        }
        if (i < right) {
            quickSort(i, right);
        }
    }

    public static void main(String[] args) {
        arr = new int[]{23, 4, 1, 0, 22, 90, 34, 100, 324, 3, 6, 7, 8, 9};
        quickSort(0, arr.length - 1);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
