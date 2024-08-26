package dev.brianmiller.leet;

import java.util.Arrays;

public class GooglePrep_PlusOne {

    public static void main(String[] args) {
        int[] result = plusOne(new int[] { 1, 9, 9 });
        System.out.println(Arrays.toString(result));
    }

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
        } else {
            result = new int[digits.length];
            boolean addedOne = false;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (addedOne) {
                    result[i] = digits[i];
                } else {
                    if (digits[i] < 9) {
                        result[i] = digits[i] + 1;
                        addedOne = true;
                    } else {
                        result[i] = 0;
                    }
                }
            }
        }
        return result;
    }
}
