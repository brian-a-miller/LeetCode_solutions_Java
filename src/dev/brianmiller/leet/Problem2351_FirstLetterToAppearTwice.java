package dev.brianmiller.leet;

import java.util.HashSet;
import java.util.Set;

public class Problem2351_FirstLetterToAppearTwice {

    /*
     * @author Brian A. Miller (bamjuggler on leetcode)
     * @date   Thursday, October 24, 2024
     * @leetcode.status Accepted
     * @leetcode.result Success
     * @leetcode.tests
     * @leetcode.runtime 0 ms, faster than 100.00% of Java online submissions
     * @leetcode.memory.usage 41.2 MB, less than 90.56% of Java online submissions
     *
     */
    public static char repeatedCharacter(String s) {
        Set<Character> lettersFound = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lettersFound.contains(c)) {
                return c;
            } else {
                lettersFound.add(c);
            }
        }
        return 'z';
    }
}