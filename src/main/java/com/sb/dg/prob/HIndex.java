package com.sb.dg.prob;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an array of integers <code>citations</code> where <code>citations[i]</code> is the number of citations a researcher received for their <code>i<sup>th</sup></code> paper, return <em>the researcher's h-index</em>.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/H-index" target="_blank">definition of h-index on Wikipedia</a>: The h-index is defined as the maximum value of <code>h</code> such that the given researcher has published at least <code>h</code> papers that have each been cited at least <code>h</code> times.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre><strong>Input:</strong> citations = [3,0,6,1,5]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre><strong>Input:</strong> citations = [1,3,1]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>n == citations.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5000</code></li>
 * 	<li><code>0 &lt;= citations[i] &lt;= 1000</code></li>
 * </ul>
 * </div></div>
 *
 * <a href="https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150">Leet Code</a>
 */
public class HIndex {
    public static int calculateHIndex(int[] citations) {

        if (citations.length == 1 && citations[0] > 0) {
            return 1;
        }
        int res = 0;
        int maxCitation = 0;
        int maxCitCount = 0;


        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < citations.length; i++) {
            freqMap.put(citations[i], freqMap.getOrDefault(citations[i], 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(freqMap.keySet());

        while (!maxHeap.isEmpty()) {
            maxCitation = maxHeap.remove();
            if (maxCitation < res) {
                continue;
            }
            maxCitCount += freqMap.get(maxCitation);
            res = Math.min(maxCitation, maxCitCount);
        }

        return res;
    }

    /**
     * <p>According to the <a href="https://en.wikipedia.org/wiki/H-index" target="_blank">definition of h-index on Wikipedia</a>: The h-index is defined as the maximum value of <code>h</code> such that the given researcher has published at least <code>h</code> papers that have each been cited at least <code>h</code> times.</p>
     *
     * <p>You must write an algorithm that runs in logarithmic time.</p>
     *
     * <p>&nbsp;</p>
     * <p><strong class="example">Example 1:</strong></p>
     *
     * <pre><strong>Input:</strong> citations = [0,1,3,5,6]
     * <strong>Output:</strong> 3
     * <strong>Explanation:</strong> [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
     * </pre>
     *
     * <p><strong class="example">Example 2:</strong></p>
     *
     * <pre><strong>Input:</strong> citations = [1,2,100]
     * <strong>Output:</strong> 2
     * </pre>
     *
     * <p>&nbsp;</p>
     * <p><strong>Constraints:</strong></p>
     *
     * <ul>
     * 	<li><code>n == citations.length</code></li>
     * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
     * 	<li><code>0 &lt;= citations[i] &lt;= 1000</code></li>
     * 	<li><code>citations</code> is sorted in <strong>ascending order</strong>.</li>
     * </ul>
     *
     * @param citations Sorted Array
     * @return H Index
     */
    public static int calculateHIndex2(int[] citations) {

        int hi = 0;

        for (int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i){
                return citations.length - i;
            }
        }
        return 0;
    }
}
