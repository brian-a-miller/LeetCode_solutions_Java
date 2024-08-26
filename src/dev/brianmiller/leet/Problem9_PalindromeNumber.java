package dev.brianmiller.leet;

/**
 * Given an integer x, return true if x is a palindrome,
 * and false otherwise.
 *
 * Follow up: Could you solve it
 * without converting the integer to a string?
 */
public class Problem9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("isPalindrome(121) returned: " + isPalindrome(121));
        System.out.println("isPalindrome2(121) returned: " + isPalindrome2(121));
        System.out.println("isPalindrome(-121) returned: " + isPalindrome(-121));
        System.out.println("isPalindrome2(-121) returned: " + isPalindrome2(-121));
        System.out.println("isPalindrome(123) returned: " + isPalindrome(123));
        System.out.println("isPalindrome2(123) returned: " + isPalindrome2(123));
    }

    private static boolean isPalindrome(int x) {

        if (x >=0 && x <= 9) {
            return true;
        }
        if (x < 0) {
            return false;
        }

        String s = Integer.toString(x);
        StringBuilder revSB = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            revSB.append(c);
        }
        return revSB.toString().equals(s);
    }

    private static boolean isPalindrome2(int x) {
        if (x >=0 && x <= 9) {
            return true;
        }
        if (x < 0) {
            return false;
        }

        int newPlace = 1;
        int reversedNumber = newPlace * (x % 10);
        int xPrime = x / 10;
        System.out.printf("x = %d, newPlace = %d, xPrime = %d, reversedNumber = %d%n",
                x, newPlace, xPrime, reversedNumber);
        while (xPrime != 0) {
            newPlace *= 10;
            reversedNumber = (10 * reversedNumber) + (xPrime % 10);
            xPrime = xPrime / 10;
            System.out.printf("x = %d, newPlace = %d, xPrime = %d, reversedNumber = %d%n",
                    x, newPlace, xPrime, reversedNumber);
        }
        return (x == reversedNumber);
    }
}
