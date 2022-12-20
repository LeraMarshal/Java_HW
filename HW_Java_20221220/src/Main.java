import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        list.remove(0); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        list.remove(8); // [1, 2, 3, 4, 5, 6, 7, 8]
        list.remove(3); // [1, 2, 3, 5, 6, 7, 8]
        list.remove(3); // [1, 2, 3, 6, 7, 8]

        System.out.println(list); // [1, 2, 3, 6, 7, 8]

        for (Integer n : list) {
            System.out.print(n + " ");
        }
        System.out.println(); // 1 2 3 6 7 8

        Iterator<Integer> it1 = list.iterator();
        while (it1.hasNext()) {
            Integer elem = it1.next();

            if (elem % 2 == 0) {
                it1.remove();
            }
        }

        System.out.println(list); // [1, 3, 7]

        Iterator<Integer> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next() % 2 != 0) {
                it2.remove();
            }
        }

        System.out.println(list); // []

        list.add(5);

        System.out.println(list); // [5]
    }
}
