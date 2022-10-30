package de.marshal.a20221030;

public class SoloSortedSearch {
    /* 2.
    Find the element that appears once in a sorted array
    Given a sorted array in which all elements occur twice (one after the other) and one element appears only once.

    Простое решение состоит в обходе массива слева направо. Поскольку массив отсортирован, мы легко можем найти нужный элемент.

    Алгоритм:
    Шаг 1: Обход массива через один элемент
    Шаг 2: Если элемент отличается от первого то мы нашли не задублированный элемент
    Шаг 3: Вернем элемент или позицию в массиве
    Шаг 4: Если ключевой элемент не найден, верните -1 или что то еще :)
    …
    Шаг 5: Исправить ошибку ArrayIndexOutOfBoundsException
     */

    public static void main(String[] args) {
        System.out.println(soloSortedSearch(new int[]{1, 2, 2, 3, 3}));
        System.out.println(soloSortedSearch(new int[]{1, 1, 2, 3, 3}));
        System.out.println(soloSortedSearch(new int[]{1, 1, 2, 2, 3}));
        System.out.println(soloSortedSearch(new int[]{1}));
        System.out.println(soloSortedSearch(new int[0]));
    }

    private static int soloSortedSearch(int[] arr) {
        for (int i = 0; i < arr.length; i+=2) {
            if (i == arr.length - 1 || arr[i] != arr[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
