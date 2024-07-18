package ss10_list.bai_tap;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = null;
    }

    public boolean contains(E e) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return !found;
            }
        }
        return found;
    }

    public int indexOf(E e) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                found = true;
                index = i;
                return i;
            }
        }
        if (found) {
            return index;
        } else return -1;
    }

    public boolean contains(E e, int index) {
        boolean found = false;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                found = true;
            }
        }
        return found;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }
//    public static void main(String[] args) {
//        MyList<Integer> myList = new MyList<>();
//        myList.add()
//    }
}
