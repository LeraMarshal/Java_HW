import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedListImpl<T> implements Iterable<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> currentNode;
        private Node<T> nextNode;

        public LinkedListIterator(Node<T> nextNode) {
            this.currentNode = null;
            this.nextNode = nextNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element available");
            }

            currentNode = nextNode;
            nextNode = nextNode.next;
            return currentNode.data;
        }

        @Override
        public void remove() {
            if (currentNode == null) {
                throw new IllegalStateException("No current element");
            }

            removeNode(currentNode);
            currentNode = null;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListImpl() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public boolean add(T elem) {
        Node<T> newNode = new Node<>(elem);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        newNode.prev = tail;
        tail = newNode;

        size += 1;

        return false;
    }

    public void add(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be in range of 0.." + size);
        }

        if (index == size) {
            add(elem);
        } else {
            Node<T> newNode = new Node<>(elem);
            Node<T> currentNode = getNode(index);

            newNode.next = currentNode;
            newNode.prev = currentNode.prev;

            if (currentNode.prev == null) {
                head = newNode;
            } else {
                currentNode.prev.next = newNode;
            }

            currentNode.prev = newNode;

            size += 1;
        }
    }

    public T remove(int index) {
        return removeNode(getNode(index));
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    private T removeNode(Node<T> node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size -= 1;

        return node.data;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be in range of 0.." + (size - 1));
        }

        int distanceFromHead = index;
        int distanceFromTail = size - index - 1;

        Node<T> currentNode;

        if (distanceFromHead <= distanceFromTail) {
            currentNode = head;

            for (int i = 0; i < distanceFromHead; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;

            for (int i = 0; i < distanceFromTail; i++) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node<T> currentNode = head;
        while (currentNode != null) {
            builder.append(currentNode.data);

            if (currentNode.next != null) {
                builder.append(", ");
            }

            currentNode = currentNode.next;
        }

        return "[" + builder + "]";
    }
}

