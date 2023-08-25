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

    /**
     * You are given a 0-indexed integer array nums and an integer x.
     * <p>
     * Find the minimum absolute difference between two elements in the array that are at least x indices apart.
     * <p>
     * In other words, find two indices i and j such that abs(i - j) >= x and abs(nums[i] - nums[j]) is minimized.
     * <p>
     * Return an integer denoting the minimum absolute difference between two elements that are at least x indices apart.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,3,2,4], x = 2<p>
     * Output: 0<p>
     * Explanation: We can select nums[0] = 4 and nums[3] = 4.<p>
     * They are at least 2 indices apart, and their absolute difference is the minimum, 0.<p>
     * It can be shown that 0 is the optimal answer.<p>
     * Example 2:
     * <p>
     * Input: nums = [5,3,2,10,15], x = 1<p>
     * Output: 1<p>
     * Explanation: We can select nums[1] = 3 and nums[2] = 2.<p>
     * They are at least 1 index apart, and their absolute difference is the minimum, 1.<p>
     * It can be shown that 1 is the optimal answer.<p>
     * Example 3:
     * <p>
     * Input: nums = [1,2,3,4], x = 3<p>
     * Output: 3<p>
     * Explanation: We can select nums[0] = 1 and nums[3] = 4.<p>
     * They are at least 3 indices apart, and their absolute difference is the minimum, 3.<p>
     * It can be shown that 3 is the optimal answer.<p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 105<p>
     * 1 <= nums[i] <= 109<p>
     * 0 <= x < nums.length<p>
     */
    public static int minAbsoluteDifference(List<Integer> nums, int x) {
        if (x >= nums.size())
            return -1;

        int left = 0, right = x;
        int res = Integer.MAX_VALUE;
        int resI = 0;
        for (int i = 0; i < nums.size() && left <= (nums.size() - x); i++) {
            int t = Math.abs(nums.get(left) - nums.get(right));
            if (t < res) {
                res = t;
                resI = Math.abs(left - right);
            }
        }

        return res;
    }
}
