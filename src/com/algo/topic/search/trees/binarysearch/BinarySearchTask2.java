package com.algo.topic.search.trees.binarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BinarySearchTask2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("input.txt")));
             PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            // input from file a
            int n = 0;
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            }
            // solution
            int l = 0;
            int r = n;
            int cnt = 0;
            while (r - l >= 1) {
                r = (l + r) / 2;
                cnt++;
            }
            // output to file b
            writer.println(cnt);

        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }
    }
}
