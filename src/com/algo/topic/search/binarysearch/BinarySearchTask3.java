package com.algo.topic.search.binarysearch;

import java.util.Scanner;

public class BinarySearchTask3 {
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
        int r = list.length - 1; // == n
        for (int k = 0; k < m; k++) {
            while (l < r) {
                int mid = (l + r) / 2;
                if (list[mid] < search[k]) { // .......
                    l = mid + 1; // 1 регулирует, чтобы не зацикливался код
                } else {
                    r = mid;
                }
            }
            if (list[r] == search[k]) System.out.println("YES"); else System.out.println("NO");
            l = 0;
            r = list.length - 1; // == n
        }

    }
}
