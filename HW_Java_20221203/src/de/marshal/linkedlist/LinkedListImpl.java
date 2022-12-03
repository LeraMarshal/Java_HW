package de.marshal.linkedlist;

class LinkedListImpl<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
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
        Node<T> currentNode = getNode(index);

        if (currentNode.prev == null) {
            head = currentNode.next;
        } else {
            currentNode.prev.next = currentNode.next;
        }

        if (currentNode.next == null) {
            tail = currentNode.prev;
        } else {
            currentNode.next.prev = currentNode.prev;
        }

        size -= 1;

        return currentNode.data;
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

