package dev.brianmiller.leet;

public class Problem344_ReverseString {

    /**
     * @author Brian A. Miller (bamjuggler)
     * @date   Wednesday, October 9, 2024
     * @leetcode.status Accepted
     * @leetcode.result Success
     * @leetcode.tests 477 / 477 test cases passed
     * @leetcode.runtime 0 ms, faster than 100% of Java online submissions
     * @leetcode.memory.usage 48.8 MB, less than 62.61% of Java online submissions
     */
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (j > i) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
