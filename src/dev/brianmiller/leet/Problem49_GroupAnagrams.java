package dev.brianmiller.leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem49_GroupAnagrams {

    /**
     * @author Brian A. Miller
     * @date July 31, 2024
     * @leetcode.status Accepted
     * @leetcode.runtime 1506 ms
     * @leetcode.memory 47.2 MB
     */
    // "Your memory usage beats 98.30 % of java submissions."
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<List<String>>();
        for (String s : strs) {
            if (result.isEmpty()) {
                LinkedList<String> firstWord = new LinkedList<>();
                firstWord.add(s);
                result.add(firstWord);
            } else {
                boolean found = false;
                for (List<String> group : result) {
                    String previous = group.get(0);
                    if (areAnagrams(previous, s)) {
                        found = true;
                        group.add(s);
                        break;
                    }
                }
                if (!found) {
                    LinkedList<String> newGroup = new LinkedList<>();
                    newGroup.add(s);
                    result.add(newGroup);
                }
            }
        }
        return result;
    }

    private static boolean areAnagrams(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }
}
