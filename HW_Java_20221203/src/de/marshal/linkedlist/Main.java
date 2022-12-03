package de.marshal.linkedlist;

public class Main {
    /*
    На основании созданного во время занятия связанного списка, создайте двунаправленный связанный список и реализуйте методы:

    - public boolean add(Type elem) {…}

    - public void add(int index, Type elem) {…}

    - public Type remove (int index) {…}
     */
    public static void main(String[] args) {
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        System.out.println(linkedList);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        linkedList.add(0, 0);
        System.out.println(linkedList);

        linkedList.add(4, 5);
        System.out.println(linkedList);

        linkedList.add(4, 4);
        System.out.println(linkedList); // 0 1 2 3 4 5

        System.out.println();

        linkedList.remove(0);
        System.out.println(linkedList);

        linkedList.remove(4);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
