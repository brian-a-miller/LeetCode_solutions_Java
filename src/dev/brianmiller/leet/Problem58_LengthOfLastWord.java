package dev.brianmiller.leet;

/**
 * Two alternate ways to solve in Java the LeetCode problem
 * "58. Length of Last Word"
 * described at
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Problem58_LengthOfLastWord {

    /**
     * @author           Brian A. Miller
     * @date             July 26, 2024
     * @leetcode.status  Accepted
     * @leetcode.runtime 1 ms
     * @leetcode.memory  41.9 MB
     *
     */
    public static int lengthOfLastWord_Solution1(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }

    /**
     * @author           Brian A. Miller
     * @date             August 12, 2024
     * @leetcode.status  Accepted
     * @leetcode.runtime 0 ms (faster than 100.00% of Java online submissions)
     * @leetcode.memory  41.6 MB
     *
     */
    public static int lengthOfLastWord_Solution2(String s) {
        String trimmed = s.trim();
        int lastSpace = trimmed.lastIndexOf(" ");
        return trimmed.length() - lastSpace - 1;
    }
}
