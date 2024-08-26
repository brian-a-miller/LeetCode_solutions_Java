package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 * @date Monday, August 26, 2024
 *
 * My Java solution to the problem
 * "1768. Merge Strings Alternately" as described at
 * https://leetcode.com/problems/merge-strings-alternately/
 *
 *
 */
public class Problem1768_MergeStringsAlternatively {

    /*
     * LeetCode submission result:
     * Success
     * Details
     * Runtime: 1 ms, faster than 85.32% of Java online submissions for Merge Strings Alternately.
     * Memory Usage: 41.7 MB, less than 50.43% of Java online submissions for Merge Strings Alternately.
     */
    public static String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.isBlank()) {
            return word2.strip();
        }
        if (word2 == null || word2.isBlank()) {
            return word1.strip();
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while ((i < word1.length()) || (j < word2.length())) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }
}
