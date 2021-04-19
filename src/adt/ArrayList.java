package ADT;

import entity.Media;
import entity.Theme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ArrayList<T> implements ListInterface<T> {

    private T[] array;
    private int num;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        num = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T entry) {
        for (int i = 0; i < num; i++) {
            if (array[i].equals(entry)) {
                return false;
            }
        }

        if (isArrayFull()) {
            doubleArray();
        }

        array[num] = entry;
        num++;
        return true;
    }

    private boolean isArrayFull() {
        return num == array.length;
    }

    private void doubleArray() {
        T[] oldArray = array;
        int oldSize = oldArray.length;

        array = (T[]) new Object[oldSize * 2];

        for (int i = 0; i < num; i++) {
            array[i] = oldArray[i];
        }
    }

    @Override
    public boolean remove(int index) {
        for (int i = 0; i < num; i++) {
            if (array[i].equals(index)) {
                removeGap(i);
                num--;
                return false;
            }
        }
        return false;
    }

    private void removeGap(int index) {
        for (int i = 0; i < index; i++) {
            array[i] = array[i + 1];
        }
    }

    @Override
    public int length() {
        return num;
    }

    @Override
    public T contain(String keyword) {
        for (T obj : array) {
            if (obj.equals(keyword)) {
                return (T)obj;
            }
        }
        return null;
    }

    @Override
    public T getEntry(int index) {
        T result = null;

        if ((index >= 0) && (index <= num)) {
            result = array[index];
        }

        return result;
    }

    @Override
    public void setEntry(int index, T data) {
        array[index] = data;
    }

    //to return the array
    @Override
    public T[] toArray() {
        Object[] copiedArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            copiedArray[i] = array[i];
        }
        return (T[]) copiedArray;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        num = 0;
    }
}
