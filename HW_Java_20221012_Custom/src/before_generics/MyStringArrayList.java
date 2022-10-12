package before_generics;

import after_generics.MyList;

public class MyStringArrayList implements MyList<String> {
    private String[] arr;
    private int size = 0;

    public MyStringArrayList(int size) {
        this.arr = new String[size];
    }

    public int size() {
        return size;
    }

    public String get(int index) {
        return arr[index];
    }

    public void put(String item) {
        if (size >= arr.length) {
            String[] arr2 = new String[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }

        arr[size++] = item;
    }

    public void push(String item) {
        if (size >= arr.length) {
            String[] arr2 = new String[arr.length * 2];
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

    public void remove(String item) {
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
            String[] arr2 = new String[arr.length / 2];
            for (int i = 0; i < size; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }
    }

}


