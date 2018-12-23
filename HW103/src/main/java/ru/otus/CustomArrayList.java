package ru.otus;

import java.util.*;

public class CustomArrayList<T> implements List<T> {

    private final String unsupportedOperationMessage = "method is not supported";
    private Object[] objArray;
    private int nextElementIndex;
    private int defaultCapacity = 10;


    public CustomArrayList() {
        objArray = new Object[defaultCapacity];
        nextElementIndex = 0;
    }

    public CustomArrayList(int capacity) {
        objArray = new Object[capacity];
        nextElementIndex = 0;
    }

    @Override
    public int size() {
        return nextElementIndex;
    }

    @Override
    public boolean add(T t) {
        if (nextElementIndex >= defaultCapacity - 1) {
            expandList();
        }
        objArray[nextElementIndex] = t;
        nextElementIndex++;
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size()];
        System.arraycopy(objArray, 0, a, 0, size());
        return a;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            CustomArrayList.this.add(t);
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (checkIndexAvailable(index)) {
            return (T) objArray[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T element) {
        T oldValue;
        if (checkIndexAvailable(index)) {
            if (index == nextElementIndex) {
                add(element);
                return null;
            } else {
                oldValue = (T) objArray[index];
                objArray[index] = element;
            }
        } else {
            throw new NoSuchElementException("Index is unavailabale");
        }
        return oldValue;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < size(); i++) {
            s.append(objArray[i].toString()).append(" ");
        }
        return s.toString();
    }

    @Override
    public T remove(int index) {
        T removedValue;
        if (!checkIndexAvailable(index)) {
            throw new NoSuchElementException("Index is unavailabale");
        } else {
            removedValue = (T) objArray[index];
            Object[] newArray = new Object[defaultCapacity];
            int j = 0;
            for (int i = 0; i < nextElementIndex; i++) {
                if (i != index)
                    newArray[j] = objArray[i];
                j++;
            }
            objArray = newArray;
        }
        return removedValue;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {

            int cursorPosition = -1;

            @Override
            public boolean hasNext() {
                return cursorPosition < nextElementIndex - 1;
            }

            @Override
            public T next() {
                cursorPosition++;
                return (T) objArray[cursorPosition];
            }

            @Override
            public boolean hasPrevious() {
                return cursorPosition > 0;
            }

            @Override
            public T previous() {
                cursorPosition--;
                return (T) objArray[cursorPosition];
            }

            @Override
            public int nextIndex() {
                return cursorPosition+1;
            }

            @Override
            public int previousIndex() {
                return cursorPosition - 1;
            }

            @Override
            public void set(T t) {
                CustomArrayList.this.set(cursorPosition, t);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(unsupportedOperationMessage);
            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException(unsupportedOperationMessage);
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return (nextElementIndex == 0);
    }


    private boolean checkIndexAvailable(int index) {
        return index <= nextElementIndex - 1;
    }

    private void expandList() {
        int newCapacity = defaultCapacity * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < defaultCapacity; i++) {
            newArray[i] = objArray[i];
        }
        objArray = newArray;
        defaultCapacity = newCapacity;
    }

    public boolean contains(Object o) {
        return false;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public void add(int index, T element) {

    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }
}
