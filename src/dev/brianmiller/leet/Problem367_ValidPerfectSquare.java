package dev.brianmiller.leet;

public class Problem367_ValidPerfectSquare {

    public static void main(String[] args) {

        // Example 1
        int input1 = 16;
        boolean expectedResult = true;
        boolean actualResult = isPerfectSquare(input1);
        System.out.printf("input: %d, expected: %s, actual: %s%n",
                input1, expectedResult, actualResult);

        // Example 2
        int input2 = 14;
        expectedResult = false;
        actualResult = isPerfectSquare(input2);
        System.out.printf("input: %d, expected: %s, actual: %s%n",
                input2, expectedResult, actualResult);
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        if (num < 0) {
            return false;
        }

        int possibleSquareRoot = num / 2;
        while (possibleSquareRoot > 1) {
            if (possibleSquareRoot * possibleSquareRoot == num) {
                return true;
            }
            possibleSquareRoot--;
        }
        return false;
    }
}
