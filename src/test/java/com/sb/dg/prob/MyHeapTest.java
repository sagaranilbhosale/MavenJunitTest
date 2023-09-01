package com.sb.dg.prob;

import com.sb.dg.model.MyHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyHeapTest {

    @Test
    void testSequence() {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        MyHeap<Integer> mh = new MyHeap<>();
        Arrays.stream(arr).forEach((i) -> mh.add(i));
        System.out.println(Arrays.toString(arr));
        System.out.println(mh);

        int size = mh.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(mh.remove().toString());
        }

    }

    @Test
    void testSequenceReversed() {

        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        MyHeap<Integer> mh = new MyHeap<>();
        Arrays.stream(arr).forEach((i) -> mh.add(i));

        System.out.println(Arrays.toString(arr));
        System.out.println(mh);

        int size = mh.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(mh.remove().toString());
        }

    }

    @Test
    void testCapacity() {

        Integer[] arr = {9, 20, 7, 16, 65, 74, 93, 20, 1};

        MyHeap<Integer> mh = new MyHeap<>();
        Arrays.stream(arr).forEach((i) -> mh.add(i));

        System.out.println(Arrays.toString(arr));
        System.out.println(mh);

        mh.add(72);
        mh.add(2);
        mh.add(7);
        mh.add(75);

        int size = mh.getSize();
        Assertions.assertEquals(10, mh.getSize());
//        for (int i = 0; i < size; i++) {
//            System.out.println(mh.remove().toString());
//        }

    }

    @Test
    void testMyHeap() {

        Integer[] arr = {2, 6, 9, 3, 7, 8, 0, 1};

        MyHeap<Integer> mh = new MyHeap<>();
        Arrays.stream(arr).forEach((i) -> mh.add(i));

        System.out.println(Arrays.toString(arr));
        System.out.println(mh);

        int size = mh.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(mh.remove().toString());
        }

    }

    @Test
    void testAllEqual() {

        Integer[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2, 1};

        MyHeap<Integer> mh = new MyHeap<>();
        Arrays.stream(arr).forEach((i) -> mh.add(i));

        System.out.println(Arrays.toString(arr));
        System.out.println(mh);

        int size = mh.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(mh.remove().toString());
        }

    }
}