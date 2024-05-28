package com.algo.topic.search.trees.binarysearch;

import java.util.Scanner;

public class BinarySearchTask2Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = 0;
        int r = sc.nextInt();
        int cnt = 0;
        while (r - l >= 1) {
            r = (l + r) / 2;
            cnt++;
        }
        System.out.print(cnt);
    }
}