package code;

import java.util.*;

public class NeonArrayList<E> {

    private final int DEFAULT_SIZE = 8;
    private Object[] arr;
    private int size = 0;
    private int modCount = 0;

    public NeonArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.arr = new Object[initialCapacity];
    }

    public NeonArrayList() {
        this.arr = new Object[DEFAULT_SIZE];
    }

    public int size() {
        return this.size;
    }

    public void add(E element) {
        add(this.size, element);
    }

    public void add(int index, E element) {
        if (this.size > this.arr.length / 2) {
            extendArray(this.arr.length * 2);
        }
        this.size++;
        this.arr[index] = element;
        ++this.modCount;
    }

    private void extendArray(int newSize) {
        Object[] extendedArr = new Object[newSize];
        System.arraycopy(this.arr, 0, extendedArr, 0, this.size);
        this.arr = extendedArr;
    }

    public boolean addAll(Collection<? extends E> c) {
        ++this.modCount;
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

    public void clear() {
        ++this.modCount;
        Object[] prev = this.arr;
        int to = this.size;
        for(int i = this.size = 0; i < to; ++i) {
            prev[i] = null;
        }
    }

    public Object get(int index) {
        Objects.checkIndex(index, this.size);
        return this.arr[index];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.size);
        Object[] es = this.arr;
        this.fastRemove(es, index);
    }

    public void remove(Object o) {
        Object[] es = this.arr;
        int size = this.size;
        int i = 0;
        if (o == null) {
            while(true) {
                if (i >= size) {
                    return;
                }
                if (es[i] == null) {
                    break;
                }
                ++i;
            }
        } else {
            while(true) {
                if (i >= size) {
                    return;
                }
                if (o.equals(es[i])) {
                    break;
                }
                ++i;
            }
        }

        this.fastRemove(es, i);
    }

    private void fastRemove(Object[] es, int i) {
        ++this.modCount;
        int newSize;
        if ((newSize = this.size - 1) > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }

        es[this.size = newSize] = null;
    }

    public void sort() {
        int expectedModCount = this.modCount;
        this.arr = quickSort(this.arr, 0, this.size - 1);
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        } else {
            ++this.modCount;
        }
    }

    private Object[] quickSort(Object[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    private int partition(Object[] arr, int low, int high) {
        int pivot = (int) arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ((int) arr[j] < pivot) {
                i++;
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}