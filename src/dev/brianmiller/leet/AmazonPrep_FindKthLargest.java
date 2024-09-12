package dev.brianmiller.leet;

import java.util.Collections;
import java.util.PriorityQueue;

public class AmazonPrep_FindKthLargest {

    public static void main(String[] args) {

        int[] nums1 = new int[] { 3, 2, 1, 5, 6, 4 };
        int k1 = 2;
        int expectedOutput1 = 5;

        int actual1 = findKthLargest(nums1, k1);
        System.out.printf("Test 1: Expected = %d, Actual = %d%n", expectedOutput1, actual1);

        int[] nums2 = new int[] { 3,2,3,1,2,4,5,5,6 };
        int k2 = 4;
        int expectedOutput2 = 4;

        int actual2 = findKthLargest(nums2, k2);
        System.out.printf("Test 2: Expected = %d, Actual = %d%n", expectedOutput2, actual2);

    }

    public static int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1 || nums.length < k) {
            throw new IllegalArgumentException("Invalid inputs");
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            //if (pq.size() > k) {

            //}
        }
        if (pq.size() < k) {
            throw new RuntimeException("Unexpected problem with PriorityQueue");
        }
        for (int i = 1; i < k; i++) {
            pq.remove();
        }

        return pq.remove();
    }
}
