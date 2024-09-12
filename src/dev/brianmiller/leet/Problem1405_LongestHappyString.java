package dev.brianmiller.leet;

// TODO
// import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-happy-string/
 *
 * 1405. Longest Happy String
 *
 * "A string s is called happy if it satisfies the following conditions:
 *
 *     s only contains the letters 'a', 'b', and 'c'.
 *     s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 *     s contains at most a occurrences of the letter 'a'.
 *     s contains at most b occurrences of the letter 'b'.
 *     s contains at most c occurrences of the letter 'c'.
 *
 * Given three integers a, b, and c, return the longest possible happy string.
 * If there are multiple longest happy strings, return any of them.
 * If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It is the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0"
 */
public class Problem1405_LongestHappyString {

    //
    // TODO: refactor to avoid duplicate code
    //
    public static String longestDiverseString(int a, int b, int c) {


        int aCount = 0, bCount = 0, cCount = 0;
        StringBuilder sb = new StringBuilder();
        while ((aCount < a) || (bCount < b) || (cCount < c)) {

            boolean appended = false;

            System.out.printf("Entering while loop with aCount=%d, a=%d, bCount=%d, b=%d, cCount=%d, c=%d%n",
                    aCount, a, bCount, b, cCount, c);

            int aRemaining = a - aCount;
            int bRemaining = b - bCount;
            int cRemaining = c - cCount;

            if ((aCount < a) && (aRemaining >= bRemaining) && (aRemaining >= cRemaining)) {
                if (sb.isEmpty() || (sb.charAt(sb.length()-1) != 'a')) {
                    if (a - aCount > 1) {
                        sb.append("aa");
                        appended = true;
                        aCount += 2;
                    } else {
                        sb.append("a");
                        appended = true;
                        aCount++;
                    }
                } else {
                    if (bRemaining > 0) {
                        if (b - bCount > 1) {
                            sb.append("bb");
                            appended = true;
                            bCount += 2;
                        } else {
                            sb.append("b");
                            appended = true;
                            bCount++;
                        }
                    } else if (cRemaining > 0) {
                        if (c - cCount > 1) {
                            sb.append("cc");
                            appended = true;
                            cCount += 2;
                        } else {
                            sb.append("c");
                            appended = true;
                            cCount++;
                        }
                    }
                }
            }

            if ((bCount < b) && (bRemaining >= aRemaining) && (bRemaining >= cRemaining)) {
                if (sb.isEmpty() || (sb.charAt(sb.length()-1) != 'b')) {
                    if (b - bCount > 1) {
                        sb.append("bb");
                        appended = true;
                        bCount += 2;
                    } else {
                        sb.append("b");
                        appended = true;
                        bCount++;
                    }
                } else if (aRemaining > 0) {
                    if (a - aCount > 1) {
                        sb.append("aa");
                        appended = true;
                        aCount += 2;
                    } else {
                        sb.append("a");
                        appended = true;
                        aCount++;
                    }
                } else if (cRemaining > 0) {
                    if (c - cCount > 1) {
                        sb.append("cc");
                        appended = true;
                        cCount += 2;
                    } else {
                        sb.append("c");
                        appended = true;
                        cCount++;
                    }
                }
            }

            if ((cCount < c) && (cRemaining >= aRemaining) && (cRemaining >= bRemaining)) {
                if (sb.isEmpty() || (sb.charAt(sb.length()-1) != 'c')) {
                    if (c - cCount > 1) {
                        sb.append("cc");
                        appended = true;
                        cCount += 2;
                    } else {
                        sb.append("c");
                        appended = true;
                        cCount++;
                    }
                } else if (aRemaining > 0) {
                    if (a - aCount > 1) {
                        sb.append("aa");
                        appended = true;
                        aCount += 2;
                    } else {
                        sb.append("a");
                        appended = true;
                        aCount++;
                    }
                } else if (bRemaining > 0) {
                    if (b - bCount > 1) {
                        sb.append("bb");
                        appended = true;
                        bCount += 2;
                    } else {
                        sb.append("b");
                        appended = true;
                        bCount++;
                    }
                }
            }

            System.out.println("At end of while loop, sb: " + sb);

            if (!appended) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
