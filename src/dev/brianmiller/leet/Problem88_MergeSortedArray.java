package dev.brianmiller.leet;

/**
 * @author            Brian A. Miller
 * @date              June 25, 2024
 * @leetcode.status   Accepted
 * @leetcode.runtime  0 ms
 * @leetcode.memory   41.9 MB (memory usage beats 87.73 % of java submissions)
 *
 * My Java solution to LeetCode problem "88. Merge Sorted Array"
 * described at https://leetcode.com/problems/merge-sorted-array/
 *
 */
public class Problem88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int j=0; j < n; j++) {
                nums1[j] = nums2[j];
            }
            return;
        }
        int targetIndex = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (targetIndex >= 0) {
            if (i < 0) {
                nums1[targetIndex] = nums2[j];
                j--;
            } else if ((j < 0) || (nums1[i] > nums2[j])) {
                nums1[targetIndex] = nums1[i];
                i--;
            } else {
                nums1[targetIndex] = nums2[j];
                j--;
            }
            targetIndex--;
        }
    }
}
