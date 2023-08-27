package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.sb.dg.prob.LeetCodeSolutions.*;

class LeetCodeSolutionsTest {

    @Test
    void findKthLargest1() {
        Assertions.assertEquals(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4);
    }

    @Test
    void productExceptSelf1() {
        int[] arr = {1, 2, 3, 4};
        int[] expectedArr = {24, 12, 8, 6};
        int[] res = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            Assertions.assertEquals(expectedArr[i], res[i]);
        }
    }


    @Test
    void testMyAtoi() {
        Assertions.assertEquals(myAtoi("9223372036854775808"), Integer.MAX_VALUE);
        Assertions.assertEquals(myAtoi(" 42"), 42);
        Assertions.assertEquals(myAtoi("  -42"), -42);
        Assertions.assertEquals(myAtoi(" 4193 with words"), 4193);
        Assertions.assertEquals(myAtoi("-91283472332"), -2147483648);
        Assertions.assertEquals(myAtoi("+1"), 1);
    }

    @Test
    void minAbsoluteDifferenceTest() {
        Assertions.assertEquals(0, minAbsoluteDifference(Arrays.asList(new Integer[]{4, 3, 2, 4}), 2));
    }

    @Test
    void testLargestNumber() {
        Assertions.assertEquals("9534330", largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    void testSmallestNumber() {
        Assertions.assertEquals(103L, smallestNumber(310L));
    }
}