package adt;

import entity.Player;
import java.io.Serializable;
import java.util.Objects;

public class LinkedList<T> implements LinkedListInterface<T>, Serializable {

    private Node firstNode;
    private int length;

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList() {

    }

    public final void clear() {
        firstNode = null;
        length = 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        length++;
        return true;
    }

    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 0) && (newPosition <= length)) {
            Node newNode = new Node(newEntry);

            if (isEmpty() || (newPosition == 0)) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 0; i < newPosition; ++i) {
                    nodeBefore = nodeBefore.next;
                }

                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }

            length++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

//    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition <= length)) {
            if (givenPosition == 0) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 0; i < givenPosition; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            } 		// one to be deleted (to disconnect node from chain)

            length--;
        }

        return result;
    }

//    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 0) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition; ++i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

//    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition; ++i) {
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }

        return result;
    }

//    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

//    @Override
    public int getLength() {
        return length;
    }

//    @Override
    public boolean isEmpty() {
        boolean result;

        result = length == 0;

        return result;
    }

//    @Override
    public boolean isFull() {
        return false;
    }

//    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    public T equalTo(T newEntry) {
        Node currentNode = firstNode;

        while ((currentNode != null)) {
            if (newEntry.equals(currentNode.data)) {
                return currentNode.data;
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public int getIndex(T anEntry) {
        Node currentNode = firstNode;
        int index = 0;

        while (currentNode != null) {
            if (anEntry.equals(currentNode.data)) {
                return index;
            } else {
                currentNode = currentNode.next;
                index++;
            }
        }
        return -1;
    }
}
