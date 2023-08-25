package com.sb.dg.prob;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LeetCodeSolutions {

    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * Can you solve it without sorting?
     * \n Example 1:
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * \n Example 2:
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     * Constraints:
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * Accepted
     * 1.9M
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int res = -1;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(groupingBy(Function.identity(), counting()));

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }


//        Queue<Integer> maxheap = Arrays.stream(nums)
//                .boxed() // Convert int to Integer
//                .collect(Collectors.toCollection(() ->
//                        new PriorityQueue<>(Collections.reverseOrder())));


        Queue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
//             // (n1,n2)->n2-n1);
        maxheap.addAll(freqMap.keySet());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (k > 0) {
            res = maxheap.poll();
//            k--;
            k -= freqMap.get(res);
        }
        int res2 = minHeap.peek();

        return res;
    }

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * <p>
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     * Example 2:
     * <p>
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * <p>
     * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) return null;

        int[] res = new int[nums.length];

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = product;
            product *= nums[i];
        }
        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }

    /**
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
     * <p>
     * The algorithm for myAtoi(string s) is as follows:
     * <p>
     * Read in and ignore any leading whitespace.<p>
     * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.<p>
     * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.<p>
     * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).<p>
     * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.<p>
     * Return the integer as the final result.<p>
     * Note:<p>
     * <p>
     * Only the space character ' ' is considered a whitespace character.<p>
     * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.<p>
     * <p>
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        String num = s.trim();

        long res = 0;
        /* true means + and false means - */
        boolean sign = true;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '-' && i == 0) {
                sign = false;
                continue;
            }
            if (num.charAt(i) == '+' && i == 0) {
                continue;
            }
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
                res *= 10;
                res += num.charAt(i) - '0';
            } else {
                return clamp(res, sign);
            }
            if (res > Integer.MAX_VALUE) {
                return clamp(res, sign);
            }
        }
        return clamp(res, sign);
    }

    private static int clamp(long res, boolean sign) {

        if (res > Integer.MAX_VALUE) {
            if (sign) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (!sign) {
            res *= -1;
        }
        return (int) res;
    }
}
