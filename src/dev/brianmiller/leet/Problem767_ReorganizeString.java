package dev.brianmiller.leet;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * https://leetcode.com/problems/reorganize-string/
 *
 * Given a string s, rearrange the characters of s
 * so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 */
public class Problem767_ReorganizeString {

    public static void main(String[] args) {
        System.out.println("reorganizeString(\"vvvlo\") returns: " +
                reorganizeString("vvvlo"));
    }

    public static String reorganizeString(String s) {

        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++charCounts[s.charAt(i) - 'a'];
        }

        var maxHeap = new PriorityQueue<int[]>(26,
                (x, y) -> {
                    int firstCheck = Integer.compare(y[0], x[0]);
                    if (firstCheck != 0) {
                        return firstCheck;
                    }
                    return Integer.compare(x[1], y[1]);
                }
        );
        for (int c = 0; c < charCounts.length; c++) {
            // maxHeap.add(new int[] { charCounts[c], c });
            if (charCounts[c] > 0) {
                maxHeap.offer(new int[]{ c, charCounts[c] });
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            //System.out.println("maxHeap: " + maxHeap);
            int[] first = maxHeap.peek();
            System.out.println("first: " + Arrays.toString(first));
            if (first == null) {
                return "";
            }
            if (sb.isEmpty() || (sb.charAt(sb.length()-1) != ('a' + first[0]))) {
                maxHeap.poll();
                sb.append((char)('a' + first[0]));
                System.out.println("sb: " + sb);
                if (first[1] > 1) {
                    --(first[1]);
                    System.out.println("maxHeap.size() before offer: " + maxHeap.size());
                    maxHeap.offer(first);
                    System.out.println("maxHeap.size() after offer: " + maxHeap.size());
                }
            } else {
                first = maxHeap.poll();
                if (maxHeap.isEmpty()) {
                    return "";
                }
                int[] second = maxHeap.poll();
                System.out.println("second: " + Arrays.toString(second));
                sb.append((char)('a' + second[0]));
                System.out.println("sb: " + sb);
                if (second[1] > 1) {
                    --(second[1]);
                    System.out.println("maxHeap.size() before offer: " + maxHeap.size());
                    maxHeap.offer(second);
                    System.out.println("maxHeap.size() after offer: " + maxHeap.size());
                } else {
                    System.out.println("second[1] <= 1, not adding back to heap");
                }
                if ((first != null) && (first[1] > 0)) {
                    System.out.println("maxHeap.size() before offer: " + maxHeap.size());
                    maxHeap.offer(first);
                    System.out.println("maxHeap.size() after offer: " + maxHeap.size());
                } else {
                    System.out.println("first[1] <= 0, not adding back to heap");
                }
            }
        }
        return sb.toString();
    }
}
