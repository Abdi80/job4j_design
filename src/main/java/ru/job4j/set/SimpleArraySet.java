package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArraySet<T> implements SimpleSet<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(0);
    int point;

    @Override
    public boolean add(T value) {
        boolean result = !contains(value);
        if (result) {
            set.add(value);
        }
        return result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), value)) {
                result = true;
            }
        }
        return result;
    }


    @Override
    public Iterator<T> iterator() {
        point = 0;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return point < set.size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return set.get(point++);
            }
        };
    }
}
