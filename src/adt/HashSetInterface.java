package adt;


import entity.Coordinate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mevicca
 */
public interface HashSetInterface<E> {
    public boolean add(E value);
    
    public boolean add(E[] value);
    
    public boolean contains(E obj);
    
    public boolean remove(E obj);
    
    public boolean remove(E[] objs);
    
    public E[] getAllKey();
            
    public void clear();         
}
