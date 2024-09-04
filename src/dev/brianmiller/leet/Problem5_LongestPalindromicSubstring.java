package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 * @date August 18, 2024
 * <p>
 * My solution to the LeetCode problem "5. Longest Palindromic Substring"
 * as described at
 * https://leetcode.com/problems/longest-palindromic-substring/
 * --> "Given a string s, return the longest palindromic substring in s."
 */
public class Problem5_LongestPalindromicSubstring {

    /*
     * LeetCode Status: Accepted
     * LeetCode Submission Detail:
     * 142 / 142 test cases passed.
     * Status: Accepted
     * Runtime: 497 ms
     * Memory Usage: 44.9 MB
     */
    public static String longestPalindrome(String s) {
        System.out.println("Entering method for s: " + s);
        String lowercase = s.toLowerCase();
        int lengthToCheck = lowercase.length();
        while (lengthToCheck > 1) {
            int i = 0;
            int j = lengthToCheck - 1;
            while (j < lowercase.length()) { //lengthToCheck) {
                String substr = lowercase.substring(i, j + 1);
                // System.out.println("    Checking substr: " + substr);
                boolean isPalindrome = true;
                for (int charIndex = 0;
                     charIndex < substr.length() / 2; charIndex++) {
                    if (substr.charAt(charIndex) != substr.charAt(substr.length() - 1 - charIndex)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    // System.out.println("    i=" + i + ", lengthToCheck=" + lengthToCheck);
                    return s.substring(i, i + substr.length());//substr;
                } else {
                    i++;
                    j++;
                }
            }
            lengthToCheck--;
        }
        return s.substring(0, 1);
    }

}
