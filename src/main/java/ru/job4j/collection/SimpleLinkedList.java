package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleLinked<E> {
    private int size;
    private int modCount;
    private Node<E> head;
    Node<E> currentNode;
    Node<E> temp;

    @Override
    public void add(E value) {
        currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node<E> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        }
        if (currentNode != null) {
            currentNode.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        int i = 0;
        Objects.checkIndex(index, size);
        currentNode = head;
        while (index != i) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        currentNode = head;
        return new Iterator<E>() {
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                temp = currentNode;
                currentNode = currentNode.next;
                return temp.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
