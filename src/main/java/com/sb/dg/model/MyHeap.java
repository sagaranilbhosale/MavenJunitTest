package com.sb.dg.model;

import java.util.Arrays;

public class MyHeap<E extends Comparable<E>> {

    private Object[] store;
    private int size;

    public MyHeap() {
        this(10);
    }

    public MyHeap(int capacity) {
        store = new Object[capacity + 1];
        size = 0;
        store[0] = new Object();
    }



    public int getSize() {
        return size;
    }

    public boolean offer(E e) {
        if (e == null) {
            System.out.println("Cannot add null value");
            return false;
        }

        if (size == store.length - 1) {
            int newCapacity = size * 2;
            Object[] newStore = Arrays.copyOf(store, newCapacity + 1);
            store = newStore;
        }
        size++;
        store[size] = e;
        int c = size;
//        Comparable<? super E> key = (Comparable<? super E>) x;

        while ((c > 1) && (((Comparable<? super E>) store[c]).compareTo((E) store[c / 2]) <= 0)) {
            swap(c, c / 2);
            c = c / 2;
        }
        return true;
    }

    public boolean add(E e) {
        if (size == store.length - 1) System.out.println("Too Many Emements!");
        else return offer(e);
        return false;
    }

    public E remove() {
        if (size == 0) {
            System.out.println("No elements in the heap");
            return null;
        }
        E item = (E) store[1];
        store[1] = store[size];
        store[size] = null;

        size--;
        if (size == 0) {
            return (E) item;
        }

        int c = 1;
        while (c * 2 <= size) {
            E key = (E) store[c];
            int left = c * 2, right = c * 2 + 1;
            E child = (E) store[left];
            if (right <= size) {
                E rchild = (E) store[right];
                if (((Comparable<? super E>) child).compareTo(rchild) > 0) {
                    left = right;
                    child = rchild;
                }
            }
            if (key.compareTo(child) > 0) {
                swap(c, left);
                c = left;
            } else {
                break;
            }
        }
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object o : store) {
            sb.append(o != null ? o.toString() + ", " : "");
        }
        return sb.toString();
    }

    private void swap(int first, int second) {
        Object temp = store[first];
        store[first] = store[second];
        store[second] = temp;
    }
}
