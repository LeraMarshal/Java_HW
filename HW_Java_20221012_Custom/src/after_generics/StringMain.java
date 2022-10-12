package after_generics;

public class StringMain {
    public static void main(String[] args) {
//        MyList<String> list = new MyPrintingArrayList<>(5);
//        MyList<String> list = new ComposedPrintingMyList<>(new MyLinkedList<>());
        MyList<String> list = new MyArrayList<>(5);
//        MyList<String> list = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.put("" + (char)('j' - i));
            list.push("" + (char)('j' - i));
        }

        for (int i = 9; i >= 0; i--) {
            print(list);
            list.remove("" + (char)('j' - i));
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
