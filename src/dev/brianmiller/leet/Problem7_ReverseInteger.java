package dev.brianmiller.leet;

public class Problem7_ReverseInteger {

    /**
     * @author Brian A. Miller
     * @date August 18, 2024
     *
     * LeetCode Submission Details:
     * 1045 / 1045 test cases passed.
     * Runtime: 2 ms
     * Memory Usage: 40.6 MB
     * runtime beats 12.48 % of java submissions.
     * memory usage beats 85.28 % of java submissions.
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {

        String original = Integer.toString(x);
        StringBuilder reversedSB = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--) {
            if (i == 0 && original.charAt(0) == '-') {
                reversedSB.insert(0, '-');
            } else {
                reversedSB.append(original.charAt(i));
            }
        }
        try {
            Integer num = Integer.parseInt(reversedSB.toString());
            return num.intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
