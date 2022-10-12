package after_generics;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;

    private int size = 0;

    public MyArrayList(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Size must be positive");
        }

        this.arr = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public void put(T item) {
        if (size >= arr.length) {
            Object[] arr2 = new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
          //  System.arraycopy(arr, 0, arr2, 0, arr.length);

            arr = arr2;
        }

        arr[size++] = item;
    }

    @Override
    public void push(T item) {
        if (size >= arr.length) {
            Object[] arr2 = new Object[arr.length * 2];
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

    @Override
    public void remove(T item) {
        int pos = 0;

        for (int i = 0; i < size; i++) {
            if (!checkEquals(arr[i], item)) {
                arr[pos++] = arr[i];
            }
        }

        for (int i = pos; i < size; i++) {
            arr[i] = null;
        }

        size = pos;

        if (size < arr.length / 3) {
            Object[] arr2 = new Object[arr.length / 2];
            for (int i = 0; i < size; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }
    }

    private boolean checkEquals(Object value1, Object value2) {
        if (value1 == null) {
            if (value2 == null) {
                return true;
            } else {
                return false;
            }
        }

        return value1.equals(value2);
    }
}
