package code;

import java.util.Collection;
import java.util.Comparator;

public class NeonArrayList<E> {

    private final int DEFAULT_SIZE = 8;
    private Object[] arr;
    private int size = 0;

    public NeonArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        arr = new Object[initialCapacity];
    }

    public NeonArrayList() {
        arr = new Object[DEFAULT_SIZE];
    }

    public int size() {
        return this.size;
    }

    public void add(E element) {
        add(this.size, element);
    }

    public void add(int index, E element) {
        if (this.size == arr.length - 1) {
            extendArray(arr.length * 2);
        }
        this.size++;
        arr[index] = element;
    }

    private void extendArray(int newSize) {
        Object[] extendedArr = new Object[newSize];
        System.arraycopy(arr, 0, extendedArr, 0, this.size);
        arr = extendedArr;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if (a.length == 0) {
            return false;
        } else {
            if (a.length > this.arr.length - this.size) {
                extendArray(this.size + a.length);
            }

            System.arraycopy(a, 0, this.arr, this.size, a.length);
            this.size += a.length;
            return true;
        }
    }

    //todo implement methods
    public Object remove(int index) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public void clear() {

    }

    public Object get(int i) {
        return null;
    }

    public void sort(Comparator c) {

    }
}