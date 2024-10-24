package dev.brianmiller.leet;

public class Problem917_ReverseOnlyLetters {


    /*
     * @author                Brian A. Miller (bamjuggler on leetcode)
     * @date                  Wednesday, October 23, 2024
     * @leetcode.status       Accepted
     * @leetcode.result       Success
     * @leetcode.test.results 115 / 115 test cases passed
     * @leetcode.runtime      0 ms, faster than 100.00% of Java online submissions
     * @leetcode.memory.usage 41.7 MB, less than 30.68% of Java online submissions
     */
    public static String reverseOnlyLetters(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            while (!Character.isLetter(charArray[left]) && (left < right)) {
                left++;
            }
            while (!Character.isLetter(charArray[right]) && (right > left)) {
                right--;
            }
            char tmp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(charArray);
    }
}
