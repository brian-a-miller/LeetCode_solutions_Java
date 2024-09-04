package dev.brianmiller.leet;

import java.util.Arrays;

/**
 * @author Brian A. Miller
 * @date Thursday, August 22, 2024
 *
 * NOTE: 202 / 266 test cases passed.
 * Wrong output for Input [1, 3, 2]
 *
 * This is my attempt at solving LeetCode problem
 * "31. Next Permutation" as described at
 * https://leetcode.com/problems/next-permutation/
 *
 * "A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory."
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *
 * "Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 * Input: nums = [ 1, 3, 4, 2 ]
 * Output: [ 1, 4, 2, 3 ] (need to swap (3,4) and then swap (3,2)
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * "
 */
public class Problem31_NextPermutation {

    public static void nextPermutation(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        boolean foundAscendingPair = false;
        while (i >= 0 && j >= 1) {

            if (nums[i] < nums[j]) {
                // found ascending pair
                foundAscendingPair = true;
                break;
            }

            // if (i > 0) {
                i--;
            // }
            //else {
            // if (j > 1) {
                j--;
            //}
        }
        if (foundAscendingPair) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            System.out.printf("Swapped positions %d and %d, now: %s%n", i, j, Arrays.toString(nums));
            if (j < nums.length - 1) {
                Arrays.sort(nums, i + 1, nums.length);
            }
/*
            while (j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i = j;
                j = i + 1;
            }
*/
        } else {
            Arrays.sort(nums);
        }
    }

    /*
     * Correct solution from LeetCode follows.  I did not write the following code:
     *
     *     public class Solution {
     *
     *         public void nextPermutation(int[] nums) {
     *             int i = nums.length - 2;
     *             while (i >= 0 && nums[i + 1] <= nums[i]) {
     *                 i--;
     *             }
     *             if (i >= 0) {
     *                 int j = nums.length - 1;
     *                 while (nums[j] <= nums[i]) {
     *                     j--;
     *                 }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
     */

}
