package com.algo.topic.search.mergesort;

public class MergeSortTask1 {

    public static void merge(int[] arr, int l, int m, int r) {
        // Вычисляем размеры подмассивов для слияния
        int n1 = m - l + 1;
        int n2 = r - m;

        // Создаем временные массивы
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Копируем данные в временные массивы
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Индексы первого и второго подмассивов
        int i = 0, j = 0;

        // Индекс объединенного массива
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов L[], если таковые имеются
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Копирование оставшихся элементов R[], если таковые имеются
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            // Сортируем первую и вторую половину
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] input = {12, 11, 13, 5, 6, 7};
        sort(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
