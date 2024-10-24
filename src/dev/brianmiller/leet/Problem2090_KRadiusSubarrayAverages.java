package dev.brianmiller.leet;

import java.util.Arrays;

public class Problem2090_KRadiusSubarrayAverages {

    /**
     * @author Brian A. Miller (bamjuggler on leetcode)
     * @date   Tuesday, October 22, 2024

    Version 1
    40 / 40 test cases passed.
    Status: Accepted
    Runtime: 6 ms
    Memory Usage: 62.8 MB
     */
    public static int[] getAverages_version1(int[] nums, int k) {

        int n = nums.length;
        int windowSize = 2 * k + 1;

        long[] prefixSums = new long[n];
        prefixSums[0] = nums[0];
        for (int p = 1; p < n; p++) {
            prefixSums[p] = prefixSums[p-1] + nums[p];
        }


        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < k) {
                answer[i] = -1;
            } else if (i + k > n - 1) {
                answer[i] = -1;
            } else {
                long sum = prefixSums[i+k] - prefixSums[i-k] + nums[i-k];
                answer[i] = (int) (sum / windowSize);
            }
        }

        return answer;
    }

    /*
     * Version 2 based on seeing Solution tab
     *
     * Success
     *
     * Runtime: 6 ms, faster than 68.33% of Java online submissions for K Radius Subarray Averages.
     * Memory Usage: 62.8 MB, less than 68.33% of Java online submissions for K Radius Subarray Averages.
     */
    public static int[] getAverages(int[] nums, int k) {

        int n = nums.length;

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        int windowSize = 2 * k + 1;
        if (windowSize > n) {
            return answer;
        }

        long[] prefixSums = new long[n];
        prefixSums[0] = nums[0];
        for (int p = 1; p < n; p++) {
            prefixSums[p] = prefixSums[p-1] + nums[p];
        }

        for (int i = k; i < (n - k); i++) {
            long sum = prefixSums[i+k] - prefixSums[i-k] + nums[i-k];
            answer[i] = (int) (sum / windowSize);
        }

        return answer;
    }
}
