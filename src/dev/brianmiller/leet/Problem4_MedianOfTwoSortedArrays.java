package dev.brianmiller.leet;

import java.util.Arrays;

/**
 * @author Brian A. Miller
 * @date Sunday, August 18, 2024
 *
 * My Java solution for the problem described at
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * runtime beat 63.06 % of java submissions
 */
public class Problem4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[] { 1, 3 };
        int[] nums2 = new int[] { 2 };
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) +
                ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + findMedianSortedArrays(nums1, nums2));

        nums1 = new int[] { 1, 2 };
        nums2 = new int[] { 3, 4 };
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) +
                ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + findMedianSortedArrays(nums1, nums2));

    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                mergedArray[k++] = nums2[j++];
            } else if (j == nums2.length) {
                mergedArray[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        if (mergedArray.length % 2 == 0) {
            return (mergedArray[(mergedArray.length / 2) - 1] + mergedArray[mergedArray.length / 2]) / 2.0;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
}
