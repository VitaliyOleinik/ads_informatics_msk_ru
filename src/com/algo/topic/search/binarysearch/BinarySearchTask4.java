package com.algo.topic.search.binarysearch;

import java.util.HashMap;
import java.util.Scanner;

public class BinarySearchTask4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] list = new int[n];
        int[] search = new int[m];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            search[i] = scanner.nextInt();
        }

        int l = 0;
        int r = list.length - 1;
        int[] result1 = new int[m];
        int i = 0;
        for (int k = 0; k < m; k++) {
            while (l < r) {
                int mid = (l + r) / 2;
                if (list[mid] < search[k]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            if (list[r] == search[k]) {
                System.out.print(r + 1 + "   ");
            } else if (list[r] != search[k]){
                System.out.println(-1);
            }
            int low = 0;
            int high = list.length - 1;
            while (low < high) {
                int mid = (low + high + 1) / 2;  // Bias the mid calculation to the right
                if (list[mid] > search[k]) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            if (list[low] == search[k]) {
                System.out.println(low + 1 + "   ");  // Convert zero-indexed to one-indexed
            }
        }
        for (int q = 0; q < result1.length; q++) {
            System.out.println(result1[q]);
        }

    }
}
