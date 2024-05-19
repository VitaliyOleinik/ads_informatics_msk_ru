package com.algo.topic.search.bubblesort;

import java.util.Scanner;

/*
5
5 4 3 2 1

cnt = 10

5
1 2 3 4 5

cnt = 0
 */

public class BubbleSortTask2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    /*int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;*/
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
