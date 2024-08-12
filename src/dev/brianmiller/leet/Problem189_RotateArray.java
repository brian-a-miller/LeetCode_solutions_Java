package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 * 
 * "memory usage beats 91.95 % of java submissions."
 *
 * My Java solution to LeetCode problem "189. Rotate Array"
 * as described at
 * https://leetcode.com/problems/rotate-array/
 *
 */
public class Problem189_RotateArray {

    public static void rotate(int[] nums, int k) {
        int[] tmpArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmpArray[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArray[i];
        }
    }
}
