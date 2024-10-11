package dev.brianmiller.leet;

import java.util.HashSet;
import java.util.Set;

public class Problem217_ContainsDuplicate {

    /**
     * @author Brian A. Miller (bamjuggler)
     * @date Wednesday, October 9, 2024
     * @leetcode.status Accepted
     * @leetcode.result Success
     * @leetcode.tests 76 / 76 test cases passed.
     * @leetcode.runtime 11 ms, faster than 72.87% of Java submissions
     * @leetcode.memory.usage 57.9 MB, less than 50.89% of Java submissions
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> foundVals = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (foundVals.contains(nums[i])) {
                return true;
            } else {
                foundVals.add(nums[i]);
            }
        }
        return false;
    }
}
