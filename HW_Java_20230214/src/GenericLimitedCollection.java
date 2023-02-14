import java.util.Objects;

public class GenericLimitedCollection<T> {
    private T[] data;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public GenericLimitedCollection(int n) {
        this.data = (T[]) new Object[n];
    }

    public void add(T elem) {
        if (size >= data.length) {
            throw new RuntimeException("Collection size exceeded, n=" + data.length);
        }

        data[size++] = elem;
    }

    public T get(int index) {
        Objects.checkIndex(index, data.length);

        return data[index];
    }
}
