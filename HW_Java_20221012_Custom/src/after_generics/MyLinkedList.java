package after_generics;

public class MyLinkedList<T> implements MyList<T> {
    private Node head = null;

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("No such index " + index);
        }

        Node item = head;
        for (int i = 1; i <= index; i++) {
            item = item.next;
        }

        return item.value;
    }

    @Override
    public void put(T item) {
        if (head == null) {
            head = new Node(null, item);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(null, item);
        }
        size++;
    }

    @Override
    public void push(T item) {
        if (head == null){
            head = new Node(null, item);
        }else {
            head = new Node(head, item);
        }
        size++;
    }

    @Override
    public void remove(T item) {
        while (head != null && checkEquals(head.value, item)){
            head = head.next;
            size--;
        }

        Node node = head;
        while (node != null){
            if (node.next != null && checkEquals(node.next.value, item)){
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
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

    private class Node {
        Node next;
        T value;

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }

}
