package dev.brianmiller.leet;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * "Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity."
 */
public class Problem34_FindFirstAndLastPositionOfElementInSortedArray {

    /*
     * @author Brian A. Miller
     * @date August 21, 2024
     *
     * @leetcode.status Accepted
     * @leetcode.runtime 0 ms
     * @leetcode.memory.usage 46.2 MB
     *
     * 88/88 test cases passed
     *
     */
    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if ((nums.length == 1) && (nums[0] == target)) {
            return new int[] { 0, 0 };
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] == target) {
                int firstFound = pivot;
                int lastFound = pivot;
                int candidate = pivot - 1;
                while ((candidate >= 0) && (nums[candidate] == target)) {
                    firstFound = candidate;
                    candidate--;
                }

                candidate = pivot + 1;
                while ((candidate < nums.length) && (nums[candidate] == target)) {
                    lastFound = candidate;
                    candidate++;
                }
                return new int[] { firstFound, lastFound };
            } else if (nums[pivot] > target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
