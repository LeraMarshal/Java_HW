package de.marshal.a20221030;

import java.util.Arrays;

public class LinearSearch {
    /*
    First level: 1. Linear Search
    Given an array arr[] of N elements, the challenge is to write a function to find a given element x in arr[] .

    Линейный поиск используется для поиска ключевого элемента среди нескольких элементов.
    Линейный поиск сегодня используется меньше, потому что он медленнее, чем бинарный поиск и хеширование.

    Алгоритм:
    Шаг 1: Обход массива
    Шаг 2: Сопоставьте ключевой элемент с элементом массива
    Шаг 3: Если ключевой элемент найден, верните позицию индекса элемента массива.
    Шаг 4: Если ключевой элемент не найден, верните -1
     */
    public static void main(String[] args) {
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.println(Arrays.toString(arr));

        System.out.println(linearSearch(arr,2));
        System.out.println(linearSearch(arr,12));
    }

    private static int linearSearch(int[] arr, int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                return i;
            }
        }

        return -1;
    }
}
