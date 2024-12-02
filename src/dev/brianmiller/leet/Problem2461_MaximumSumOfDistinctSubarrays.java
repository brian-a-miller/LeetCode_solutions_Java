package dev.brianmiller.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * A Java solution to the problem described at
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 */
public class Problem2461_MaximumSumOfDistinctSubarrays {

    /**
     * @author Brian A. Miller (bamjuggler on leetcode.com)
     * @date Monday, November 18, 2024
     * @leetcode.status Accepted
     * @leetcode.result Success
     * @leetcode.runtime 45 ms, faster than 52.96% of Java online submissions
     * @leetcode.memory.usage 58.1 MB, less than 53.84% of Java online submissions
     * @leetcode.test.results 93 / 93 test cases passed
     *
     * @param nums
     * @param k
     * @return
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0; // Long.MIN_VALUE;
        if (nums == null || nums.length < k) {
            return maxSum;
        }

        int i = 0;
        int j = k - 1;
        Map<Integer, Integer> mapValueToCount = new HashMap<>();
        long currentSum = 0L;
        while (j < nums.length) {
            if (i == 0) {
                for (int l = i; l <= j; l++) {
                    int val = nums[l];
                    currentSum += (long) val;
                    if (mapValueToCount.containsKey(val)) {
                        mapValueToCount.compute(val, (key, oldCount) -> oldCount + 1);
                    } else {
                        mapValueToCount.put(val, 1);
                    }
                }
            } else {
                currentSum -= (long) nums[i-1];
                currentSum += (long) nums[j];
                int count1 = mapValueToCount.get(nums[i-1]);
                if (count1 == 1) {
                    mapValueToCount.remove(nums[i-1]);
                } else {
                    mapValueToCount.put(nums[i-1], count1 - 1);
                }
                if (mapValueToCount.containsKey(nums[j])) {
                    mapValueToCount.compute(nums[j], (key, count2) -> count2 + 1);
                } else {
                    mapValueToCount.put(nums[j], 1);
                }

            }

            if ((mapValueToCount.keySet().size() == k) &&
                    (currentSum > maxSum)) {
                maxSum = currentSum;
            }

            i++;
            j++;
        }
        return maxSum;
    }
}
