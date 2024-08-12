package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 *
 * My accepted solution (in Java) to LeetCode problem
 * "26. Remove Duplicates from Sorted Array"
 * as described at 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class Problem26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int numDuplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                numDuplicates++;
            } else if (numDuplicates > 0) {
                nums[i - numDuplicates] = nums[i];
            }
        }
        return nums.length - numDuplicates;
    }
}
