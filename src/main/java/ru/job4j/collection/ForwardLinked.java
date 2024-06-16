package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;
    Node<T> currentNode;
    Node<T> temp;

    public void add(T value) {
        currentNode = head;
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

    public T get(int index) {
        int i = 0;
        Objects.checkIndex(index, size);
        currentNode = head;
        while (index != i) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.item;
    }

    public T deleteFirst() {
        final T value;
        if (head != null) {
            value = head.item;
            currentNode = head;
            head = head.next;
            currentNode.item = null;
            currentNode.next = null;
        } else {
            throw new NoSuchElementException();
        }
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        currentNode = head;
        return new Iterator<T>() {
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
                temp = currentNode;
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