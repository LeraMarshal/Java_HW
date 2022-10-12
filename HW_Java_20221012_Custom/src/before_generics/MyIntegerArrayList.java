package before_generics;

import after_generics.MyList;

public class MyIntegerArrayList implements MyList<Integer> {
    private Integer[] arr;
    private int size = 0;

    public MyIntegerArrayList(int size) {
        this.arr = new Integer[size];
    }

    public int size() {
        return size;
    }

    public Integer get(int index) {
        return arr[index];
    }

    public void put(Integer item) {
        if (size >= arr.length) {
            Integer[] arr2 = new Integer[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }

        arr[size++] = item;
    }

    public void push(Integer item) {
        if (size >= arr.length) {
            Integer[] arr2 = new Integer[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arr2[i + 1] = arr[i];
            }
            arr = arr2;
        } else {
            for (int i = size; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
        }

        arr[0] = item;
        size++;
    }

    public void remove(Integer item) {
        int pos = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] != item) {
                arr[pos++] = arr[i];
            }
        }

        for (int i = pos; i < size; i++) {
            arr[i] = null;
        }

        size = pos;

        if (size < arr.length / 3) {
            Integer[] arr2 = new Integer[arr.length / 2];
            for (int i = 0; i < size; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }
    }
}
