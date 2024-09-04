package dev.brianmiller.leet;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class Problem1480_RunningSumOf1DArray {

    /**
     * @author Brian A. Miller
     * @date Monday, August 26, 2024
     *
     * @leetcode.status Success
     * @leetcode.test.cases 54 of 54 test cases passed
     * @leetcode.runtime 0 ms, faster than 100.00% of Java online submissions
     * @leetode.memory.usage 42.6 MB, less than 59.74% of Java online submissions
     *
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i-1];
        }
        return result;
    }
}
