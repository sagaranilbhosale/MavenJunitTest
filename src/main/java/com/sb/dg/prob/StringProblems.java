package com.sb.dg.prob;

public class StringProblems {

    /**
     * <div class="xFUwe" data-track-load="description_content"><p>The string <code>"PAYPALISHIRING"</code> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)</p>
     *
     * <code>P   A   H   N<p/>
     * A P L S I I G<p/>
     * Y   I   R
     * </code>
     *
     * <p>And then read line by line: <code>"PAHNAPLSIIGYIR"</code></p>
     *
     * <p>Write the code that will take a string and make this conversion given a number of rows:</p>
     *
     * <pre>string convert(string s, int numRows);
     * </pre>
     *
     * <p>&nbsp;</p>
     * <p><strong class="example">Example 1:</strong></p>
     *
     * <pre><strong>Input:</strong> s = "PAYPALISHIRING", numRows = 3
     * <strong>Output:</strong> "PAHNAPLSIIGYIR"
     * </pre>
     *
     * <p><strong class="example">Example 2:</strong></p>
     *
     * <pre><strong>Input:</strong> s = "PAYPALISHIRING", numRows = 4
     * <strong>Output:</strong> "PINALSIGYAHRPI"
     * <strong>Explanation:</strong>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * </pre>
     *
     * <p><strong class="example">Example 3:</strong></p>
     *
     * <pre><strong>Input:</strong> s = "A", numRows = 1
     * <strong>Output:</strong> "A"
     * </pre>
     *
     * <p>&nbsp;</p>
     * <p><strong>Constraints:</strong></p>
     *
     * <ul>
     * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
     * 	<li><code>s</code> consists of English letters (lower-case and upper-case), <code>','</code> and <code>'.'</code>.</li>
     * 	<li><code>1 &lt;= numRows &lt;= 1000</code></li>
     * </ul>
     *
     * @param s
     * @return <a href="https://leetcode.com/problems/zigzag-conversion/">...</a>
     */
    public static String convert(String s, int numRows) {


        int slantNum = numRows - 2;
        StringBuffer sb = new StringBuffer();

        if (numRows < 2) {
            return s;
        }

        System.out.println("\ns: " + s + " num rows: " + numRows);

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += (numRows + slantNum)) {
                System.out.print(s.charAt(j));
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && j + numRows + slantNum - 2 * i < s.length()) {
                    System.out.print(s.charAt(j + numRows + slantNum - 2 * i));
                    sb.append(s.charAt(j + numRows + slantNum - 2 * i));
                }
            }
            System.out.println();
        }
        System.out.println(sb);
        return sb.toString();
    }
}
