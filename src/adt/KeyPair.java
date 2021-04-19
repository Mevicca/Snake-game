package adt;

public class KeyPair<K, V> {
         K key;
         V value;
         KeyPair<K,V> next;
     
         public KeyPair(K key, V value, KeyPair<K,V> next){
             this.key = key;
             this.value = value;
             this.next = next;
         }
     }
