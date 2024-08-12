package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 *
 * My Java solution to the LeetCode problem
 *
 *   14. Longest Common Prefix
 *
 * As described at https://leetcode.com/problems/longest-common-prefix/
 * 
 */
public class Problem14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        for (int i = 0; i < strs.length; i++) {
            if (strs[0] == null || strs.length == 0) {
                return "";
            }
        }

        String commonPrefix = "";
        for (int len = 1; len <= strs[0].length(); len++) {
            String prefix = strs[0].substring(0, len);
            boolean matchesAll = true;
            for (int s = 1; s < strs.length; s++) {
                if (!strs[s].startsWith(prefix)) {
                    matchesAll = false;
                    break;
                }
            }
            if (matchesAll) {
                commonPrefix = prefix;
            }
        }
        return commonPrefix;
    }

}
