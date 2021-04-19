package ADT;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 霆翔
 * @param <T>
 */
public interface ListInterface<T> {
    public boolean add(T path);
    public boolean remove(int index);
    public int length();
    public T contain(String keyword);
    public T getEntry(int index);
    
    public void setEntry(int index, T data);
    public T[] toArray();
    public void clear();
}
