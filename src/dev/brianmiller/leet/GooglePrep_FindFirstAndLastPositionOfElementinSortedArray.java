package dev.brianmiller.leet;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 *
 */
public class GooglePrep_FindFirstAndLastPositionOfElementinSortedArray {

    public static void main(String[] args) {

        int[] input = new int[] { 5,7,7,8,8,10 };
        int target = 8;

        testAndPrintResults(input, target);

        input = new int[] { 5,7,7,8,8,10 };
        target = 6;

        testAndPrintResults(input, target);

        input = new int[0];
        target = 0;

        testAndPrintResults(input, target);

        input = new int[] { 1 };
        target = 1;

        testAndPrintResults(input, target);

        input = new int[] { 1, 4 };
        target = 4;

        testAndPrintResults(input, target);

    }

    private static void testAndPrintResults(int[] input, int target) {
        int[] output =  searchRange(input, target);
        System.out.println("\nInput: " + Arrays.toString(input));
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(output));
    }

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
