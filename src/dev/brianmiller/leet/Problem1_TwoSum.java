package dev.brianmiller.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem1_TwoSum {

    // Brute Force approach
    public static int[] twoSum_solution1(int[] nums, int target) {
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

    // Faster runtime by using HashMap and no nested loop
    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("nums must not be null or empty");
        }

        Map<Integer, List<Integer>> valuetoIndicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valuetoIndicesMap.containsKey(val)) {
                (valuetoIndicesMap.get(val)).add(i);
            } else {
                List<Integer> indicesList = new LinkedList<Integer>();
                indicesList.add(i);
                valuetoIndicesMap.put(val, indicesList);
            }
        }

        int[] result = new int[] { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int needed = target - val;
            if (valuetoIndicesMap.containsKey(needed)) {
                for (Integer j : valuetoIndicesMap.get(needed)) {
                    if (j != i) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
