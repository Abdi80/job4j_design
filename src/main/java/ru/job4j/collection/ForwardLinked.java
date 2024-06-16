package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        Node<T> currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        }
        if (currentNode != null) {
            currentNode.next = newNode;
        }
        size++;
        modCount++;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
        modCount++;
    }

    public T get(int index) {
        int i = 0;
        Objects.checkIndex(index, size);
        Node<T> currentNode = head;
        while (index != i) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.item;
    }

    public T deleteFirst() {
        final T value;
        if (head == null) {
            throw new NoSuchElementException();
        }
        value = head.item;
        Node<T> currentNode = head;
        head = head.next;
        currentNode.item = null;
        currentNode.next = null;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
         return new Iterator<T>() {
            Node<T> currentNode = head;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> temp = currentNode;
                currentNode = currentNode.next;
                return temp.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}