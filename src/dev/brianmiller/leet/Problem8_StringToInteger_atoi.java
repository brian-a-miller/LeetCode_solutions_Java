package dev.brianmiller.leet;

/**
 * A solution in Java to the problem described at
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * "8. String to Integer (atoi)
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result."
 */
public class Problem8_StringToInteger_atoi {

    /**
     * @author           Brian A. Miller
     * @date             September 3, 2024
     * @leetcode.status  Accepted
     * @leetcode.tests   1094 / 1094 test cases passed.
     * @leetcode.runtime 2 ms (beats 32.97 % of java submissions)
     * @leetcode.memory  41.5 MB (beats 99.82 % of java submissions)
     */
    public static int myAtoi(String s) {
        int result = 0;
        if (s != null) {
            String trimmed = s.strip(); // trim();
            if (trimmed.length() > 0) {
                int index = 0;
                boolean isPositive = true;
                if (trimmed.charAt(0) == '-') {
                    isPositive = false;
                    index = 1;
                } else if (trimmed.charAt(0) == '+') {
                    isPositive = true;
                    index = 1;
                }
                while (index < trimmed.length() && (trimmed.charAt(index) == '0')) {
                    index++;
                }
                boolean foundNonDigit = false;
                while (!foundNonDigit && (index < trimmed.length())) {
                    char ch = trimmed.charAt(index);
                    if ((ch >= '0') && (ch <= '9')) {
                        int newDigit = (int) (ch - '0');
                        long tmpLong = ((long)result * 10L) + (long) newDigit;
                        if (tmpLong > Integer.MAX_VALUE) {
                            if (isPositive) {
                                return Integer.MAX_VALUE;
                            } else {
                                return Integer.MIN_VALUE;
                            }
                        } else {
                            result = (int) tmpLong;
                        }
                    } else {
                        foundNonDigit = true;
                    }
                    index++;
                }
                if (!isPositive) {
                    result = -1 * result;
                }
            }
        }
        return result;
    }

}
