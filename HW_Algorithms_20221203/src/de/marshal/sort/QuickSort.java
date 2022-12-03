package de.marshal.sort;

public class QuickSort {
    public static long count = 0;

    public static void quickSort(int[] arr) {
        count = 0;

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = findPivotIndex(arr, left, right);

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int findPivotIndex(int[] arr, int left, int right) {
        // Опорный элемент
        int pivot = arr[right];

        // Место, на которое нужно поставить следующий элемент, который <= pivot
        int pos = left;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                // На место pos++ мы ставим элемент, который стоял ранее на i-м месте
                swap(arr, i, pos++);
            }

            count += 1;
        }

        // Опорный элемент поместим на следующее место (pos)
        swap(arr, right, pos);

        return pos;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
