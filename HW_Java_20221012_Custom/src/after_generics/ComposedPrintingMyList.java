package after_generics;

public class ComposedPrintingMyList<T> implements MyList<T> {
    private MyList<T> delegate;

    public ComposedPrintingMyList(MyList<T> delegate){
        this.delegate = delegate;
    }

    @Override
    public int size() {
        System.out.println("Вызвался size");
        return delegate.size();
    }

    @Override
    public T get(int index) {
        System.out.println("Вызвался get с параметром index[" + index + "]");
        return delegate.get(index);
    }

    @Override
    public void put(T item) {
        System.out.println("Вызвался put с параметром item[" + item + "]");
        delegate.put(item);
    }

    @Override
    public void push(T item) {
        System.out.println("Вызвался push с параметром item[" + item + "]");
        delegate.push(item);
    }

    @Override
    public void remove(T item) {
        System.out.println("Вызвался remove с параметром item[" + item + "]");
        delegate.remove(item);
    }
}
