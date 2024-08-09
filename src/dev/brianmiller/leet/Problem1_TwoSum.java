package dev.brianmiller.leet;

public class Problem1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        boolean found = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (found) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    results[0] = i;
                    results[1] = j;
                    found = true;
                    break;
                }
            }
        }
        return results;
    }
}
