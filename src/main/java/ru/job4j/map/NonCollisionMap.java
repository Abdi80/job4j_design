package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int index = getIndex(key);
        boolean result = table[index] == null;
        if (result) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        if (count >= (capacity * LOAD_FACTOR)) {
            expand();
        }
        return result;
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> kvMapEntry : oldTable) {
            if (kvMapEntry != null) {
                table[getIndex(kvMapEntry.key)] = kvMapEntry;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        V result = null;
        if (table[index] != null) {
            if (Objects.hashCode(table[index].key) == Objects.hashCode(key)
                    && Objects.equals(table[index].key, key)) {
                result = table[index].value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        boolean result = false;
        if (table[index] != null) {
            if (Objects.hashCode(table[index].key) == Objects.hashCode(key)
                    && Objects.equals(table[index].key, key)) {
                table[index] = null;
                result = true;
                count--;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index;
            final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
