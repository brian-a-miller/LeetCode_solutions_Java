package dev.brianmiller.leet;

/**
 * Solution to the LeetCode problem "66. Plus One"
 * as described at
 * https://leetcode.com/problems/plus-one/
 */
public class Problem66_PlusOne {

    /**
     * @author Brian A. Miller
     * @date August 15, 2024
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1) {
            throw new IllegalArgumentException("input must not be null or empty");
        }
        boolean allNines = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                allNines = false;
                break;
            }
        }
        int[] result;
        if (allNines) {
            result = new int[digits.length + 1];
            result[0] = 1;
            // for (int j = 1; j < result.length; j++) {
            // result[j] = 0;
            // }
        } else {
            result = new int[digits.length];
            boolean addedOne = false;
            // int carry = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (addedOne) {
                    result[i] = digits[i];
                } else {
                    if (digits[i] < 9) {
                        result[i] = digits[i] + 1;
                        addedOne = true;
                    } else {
                        result[i] = 0;
                        // carry = 1;
                    }
                }
            }
        }
        return result;
    }
}
