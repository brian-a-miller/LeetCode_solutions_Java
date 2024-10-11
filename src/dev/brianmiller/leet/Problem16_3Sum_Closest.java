package dev.brianmiller.leet;

import java.util.Arrays;

/**
 * @author           Brian A. Miller
 * @date             Tuesday, October 1, 2024
 * @leetcode.status  Accepted
 * @leetcode.result  Success
 * @leetcode.runtime 14 ms, faster than 74.00% of Java online submissions
 * @leetcode.memory  43.1 MB, less than 43.78% of Java online submissions
 */
public class Problem16_3Sum_Closest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int smallestDiffFromTarget = Math.abs(target - closestSum);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int thisSum = nums[i] + nums[j] + nums[k];
                int thisDiffFromTarget = Math.abs(target - thisSum);
                if (thisDiffFromTarget < smallestDiffFromTarget) {
                    smallestDiffFromTarget = thisDiffFromTarget;
                    closestSum = thisSum;
                }
                if (thisSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;
    }
}
