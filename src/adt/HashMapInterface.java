package adt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mevicca
 */
public interface HashMapInterface<K,V> {
    public boolean put(K newKey, V data);
 
    public V get(K key);
 
    public boolean remove(K deleteKey);
   
    public K contains(K key);

    public K[] getAllKey();
}
