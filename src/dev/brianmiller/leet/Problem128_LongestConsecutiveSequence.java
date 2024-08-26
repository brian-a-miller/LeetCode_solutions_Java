package dev.brianmiller.leet;

import java.util.Set;
import java.util.TreeSet;

public class Problem128_LongestConsecutiveSequence {

    public static void main(String[] args) {

    }

    /**
     * @author Brian A. Miller
     * @date Sunday, August 18, 2024
     *
     * @param nums
     * @return
     */
    private static int longestConsecutive(int[] nums) {
        Set<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            sortedSet.add(nums[i]);
        }
        boolean first = true;
        int maxConsecutive = 0;
        int previousValue = Integer.MIN_VALUE;
        int currentSequenceLength = 0;
        for (Integer val : sortedSet) {
            if (first) {
                currentSequenceLength = 1;
                maxConsecutive = 1;
                first = false;
            } else {
                if (val == previousValue + 1) {
                    System.out.println(val + " is one more than " + previousValue);
                    ++currentSequenceLength;
                    if (currentSequenceLength > maxConsecutive) {
                        maxConsecutive = currentSequenceLength;
                        System.out.println("maxConsecutive = " + maxConsecutive);
                    }
                } else {
                    currentSequenceLength = 1;
                }
            }
            previousValue = val;
        }
        return maxConsecutive;
    }
}
