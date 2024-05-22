package com.algo.topic.search.heapsort;

import java.util.ArrayList;
import java.util.Scanner;

public class MinHeap {
    private ArrayList<Integer> heap;
    private int size;

    private MinHeap(int[] array) {
        heap = new ArrayList<>();
        for (int value : array) {
            heap.add(value);
        }
        size = heap.size();
        buildHeap();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public int getMin() {
        return heap.get(0);
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int k) {
        heap.add(k);
        size++;
        int i = size - 1;

        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if (left < size && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < size && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void buildHeap() {
        // Начинаем с последнего ненулевого узла и двигаемся к корню
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int extractMin() {
        if (size <= 0) {
            throw new IllegalStateException("Heap underflow");
        }

        int root = heap.get(0);
        heap.set(0, heap.get(size - 1));
        size--;
        heapify(0);
        return root;
    }

    public static void heapSort(int[] array) {
        MinHeap minHeap = new MinHeap(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = minHeap.extractMin();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        heapSort(array);

        for (int value : array) {
            System.out.print(value + " ");
        }

        scanner.close();
    }


}
