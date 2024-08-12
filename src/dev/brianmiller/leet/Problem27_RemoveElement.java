package dev.brianmiller.leet;

/**
 * Solution to LeetCode problem "27. Remove Element"
 * described at https://leetcode.com/problems/remove-element/
 */
public class Problem27_RemoveElement {

    /**
     * @author           Brian A. Miller
     * @date             June 16, 2024
     * @leetcode.status  Accepted
     * @leetcode.runtime 0 ms
     * leetcode.memory   41.6 MB
     * memory usage beats 91.27 % of java submissions
     */
    public static int removeElement(int[] nums, int val) {
        int numMatches = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                numMatches++;
            } else {
                nums[i - numMatches] = nums[i];
            }
        }
        return nums.length - numMatches;
    }
}
