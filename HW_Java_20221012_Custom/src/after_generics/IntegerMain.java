package after_generics;

public class IntegerMain {
    public static void main(String[] args) {
//        MyList<Integer> list = new MyPrintingArrayList<>(5);
//        MyList<Integer> list = new ComposedPrintingMyList<>(new MyLinkedList<>());
//        MyList<Integer> list = new MyArrayList<>(5);
        MyList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.put(i);
            list.push(i);
        }

        for (int i = 9; i >= 0; i--) {
            print(list);
            list.remove(i);
        }

        print(list);
    }

    private static void print(MyList<?> list) {
        int size = list.size();
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(list.get(i));
        }
        System.out.println("]");
    }
}


