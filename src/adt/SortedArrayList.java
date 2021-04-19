package adt;

import java.io.Serializable;

public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T>,Serializable {

  private T[] list;
  private int length;
  private static final int DEFAULT_CAPACITY = 20;

  public SortedArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public SortedArrayList(int initialCapacity) {
    length = 0;
    list = (T[]) new Comparable[initialCapacity];
  }

  public boolean add(T newEntry) {
    int i = 0;
    if(isArrayFull())
        doubleArray();
    while (i < length && newEntry.compareTo(list[i]) > 0) {
      i++;
    }
    makeSpace(i);
    list[i] = newEntry;
    length++;
    return true;
  }

  public boolean remove(T anEntry) {
    if(length == 0)
        return false;
    else{
        int index = 0;
        while(index < length && list[index].compareTo(anEntry) < 0)
        {
            index++;
        }
        if(list[index].equals(anEntry)){
            removeGap(index+1);
            length --;
            return true;
        }
        return false;
    }      
  }
  
  public void clear() {
    length = 0;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(list[index])) {
        found = true;
      }
    }
    return found;
  }

  public int getLength() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }
   
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = list[givenPosition - 1];
    }

    return result;
  }
  
  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += list[index] + "\n";
    }

    return outputStr;
  }
  
  private boolean isArrayFull() {
    return length == list.length;
  }
  
  private void doubleArray() {
    T[] oldList = list;
    int oldSize = oldList.length;

    list = (T[]) new Comparable[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      list[index] = oldList[index];
    }
  }

  private void makeSpace(int newPosition) {
    int newIndex = newPosition;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      list[index + 1] = list[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      list[index] = list[index + 1];
    }
  }
}
