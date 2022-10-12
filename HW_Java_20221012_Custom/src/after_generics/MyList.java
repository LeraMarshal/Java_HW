package after_generics;

public interface MyList<T> {
    int size();

    T get(int index);

    void put(T item);

    void push(T item);

    void remove(T item);
}
