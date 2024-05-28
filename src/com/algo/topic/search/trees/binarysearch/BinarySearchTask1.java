package com.algo.topic.search.trees.binarysearch;

import java.util.Scanner;

public class BinarySearchTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] list = new int[n];
        int[] kElements = new int[m];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            kElements[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int k = kElements[i];
            int l = 0;
            int r = n - 1;
            while (r - l > 1) {
                int middle = (l + r) / 2;
                if (list[middle] < k) l = middle;
                else r = middle;
            }
            System.out.println(list[r-1]);
        }
        sc.close();
    }
}
