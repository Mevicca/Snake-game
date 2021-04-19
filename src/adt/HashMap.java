package adt;

public class HashMap<K, V> implements HashMapInterface<K, V> {

    private KeyPair<K, V>[] table;
    private int capacity = 4;
    private int index = 0;

    @SuppressWarnings("unchecked")
    public HashMap() {
        table = new KeyPair[capacity];
    }

    //need to be modify
    public boolean put(K newKey, V data) {
        if (newKey == null) {
            return false;    //reject to store null.
        }
        int hash = hash(newKey);

        KeyPair<K, V> newEntry = new KeyPair<K, V>(newKey, data, null);

        if (table[hash] == null) { //the first data
            table[hash] = newEntry;
        } else {
            KeyPair<K, V> previous = null;
            KeyPair<K, V> current = table[hash];//the current key pair

            //to read one by one inside the table[hash]
            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return false;
                    } else {//if the node have previous
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return false;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        return true;
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            KeyPair<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            KeyPair<K, V> previous = null;
            KeyPair<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }
    
    public K contains(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            KeyPair<K, V> temp = table[hash];

            while (temp != null) {
                if (temp.key.equals(key)) {
                    return key;
                }
                temp = temp.next;
            }

            return null;
        }

    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public K[] getAllKey() {
        Object[] array=new Object[200];
        int index=0;
            for (var keys : table) {
                while (keys != null) {
                    array[index]=(keys.key);
                    index++;
                    keys = keys.next;
                }
            }
        return (K[])array;
    }
}
