package after_generics;

public class MyPrintingArrayList<T> extends MyArrayList<T> implements MyList<T> {
    boolean printPut = true;
    boolean printPush = true;

    public MyPrintingArrayList(int size){
        super(size);
    }

    public MyPrintingArrayList(int size, boolean printPut, boolean printPush) {
        super(size);
        this.printPut = printPut;
        this.printPush = printPush;
    }

    @Override
    public int size() {
        System.out.println("Вызвался size");
        return super.size();
    }

    @Override
    public T get(int index) {
        System.out.println("Вызвался get с параметром index[" + index + "]");
        return super.get(index);
    }

    @Override
    public void put(T item) {
        if (printPut) {
            System.out.println("Вызвался put с параметром item[" + item + "]");
        }
        super.put(item);
    }

    @Override
    public void push(T item) {
        if (printPush) {
            System.out.println("Вызвался push с параметром item[" + item + "]");
        }
        super.push(item);
    }

    @Override
    public void remove(T item) {
        System.out.println("Вызвался remove с параметром item[" + item + "]");
        super.remove(item);
    }
}
