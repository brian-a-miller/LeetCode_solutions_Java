package dev.brianmiller.leet;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2965/
 * <p>
 * Given a roman numeral, convert it to an integer.
 */
public class AmazonPrep_RomanToInteger {

    /**
     * @param s
     * @return
     * @author Brian A. Miller
     * @date Tuesday, September 10, 2024
     * @leetcode.result Accepted
     * @leetcode.tests 3999 / 3999 test cases passed
     * @leetcode.runtime 5 ms, faster than 58.67% of Java online submissions
     * @leetcode.memory 44.3 MB, less than 93.44% of Java online submissions
     */
    public static int romanToInt(String s) {

        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("input must not be null or empty");
        }
        s = s.strip();

        int result = 0;

        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length()) {
                String twoCharSubstring = s.substring(i, i + 2);
                if ("CM".equals(twoCharSubstring)) {
                    result += 900;
                    i += 2;
                    continue;
                } else if ("CD".equals(twoCharSubstring)) {
                    result += 400;
                    i += 2;
                    continue;
                } else if ("XC".equals(twoCharSubstring)) {
                    result += 90;
                    i += 2;
                    continue;
                } else if ("XL".equals(twoCharSubstring)) {
// XL            40
                    result += 40;
                    i += 2;
                    continue;
                } else if ("IX".equals(twoCharSubstring)) {
// IX            9
                    result += 9;
                    i += 2;
                    continue;
                } else if ("IV".equals(twoCharSubstring)) {
// IV            4
                    result += 4;
                    i += 2;
                    continue;
                }
            }
            char c = s.charAt(i);
            if ('M' == c) {
                result += 1000;
                i++;
            } else if ('D' == c) {
                result += 500;
                i++;
            } else if ('C' == c) {
                result += 100;
                i++;
            } else if ('L' == c) {

// L             50
                result += 50;
                i++;

            } else if ('X' == c) {
// X             10
                result += 10;
                i++;


            } else if ('V' == c) {
// V             5
                result += 5;
                i++;


            } else if ('I' == c) {
// I             1
                result++;
                i++;
            }

        }

        return result;
    }
}
