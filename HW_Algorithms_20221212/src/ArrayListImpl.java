import java.util.Arrays;
import java.util.Objects;

public class ArrayListImpl<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private T[] arr;
    private int size = 0;

    public ArrayListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListImpl(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(arr, 0, size, null);

        size = 0;
    }

    public void addAt(int index, T value) {
        checkInRange(index, 0, size);

        if (size == arr.length) {
            T[] tmp = (T[]) new Object[(arr.length > 0) ? arr.length * 2 : 1];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
        }

        if (index != size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }

        arr[index] = value;

        size += 1;
    }

    public void add(T value) {
        addAt(size, value);
    }

    public T get(int index) {
        checkInRange(index, 0, size - 1);

        return arr[index];
    }

    public void set(int index, T value) {
        checkInRange(index, 0, size - 1);

        arr[index] = value;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], value)) {
                return true;
            }
        }
        return false;
    }

    public void shrinkSize() {
        T[] tmp = (T[]) new Object[size];
        System.arraycopy(arr, 0, tmp, 0, size);
        arr = tmp;
    }

    public void removeAt(int index){
        checkInRange(index, 0, size - 1);

        if (index != size - 1){
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        }

        arr[size - 1] = null;
        size -= 1;
    }

    public void remove(){
        removeAt(size - 1);
    }

    private void checkInRange(int value, int low, int high) {
        if (value < low || value > high) {
            throw new IllegalArgumentException("Index must be in range of " + low + ".." + high);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
