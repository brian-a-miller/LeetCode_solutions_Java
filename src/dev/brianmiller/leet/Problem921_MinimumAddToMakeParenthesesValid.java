package dev.brianmiller.leet;

import java.util.Stack;

public class Problem921_MinimumAddToMakeParenthesesValid {

    /**
     * @author Brian A. Miller (bamjuggler)
     * @date   Wednesday, October 9, 2024
     * @leetcode.status  Accepted
     * @leetcode.result  Success
     * @leetcode.tests   115 / 115 test cases passed.
     * @leetcode.runtime 2 ms, faster than 26.73% of Java online submissions
     * @leetcode.memory  41.4 MB, less than 45.71% of Java online submissions
     */
    public static int minAddToMakeValid_UsingStack(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int result = 0;
        Stack<Character> parenStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                parenStack.push(c);
            } else if (c == ')') {
                if (parenStack.isEmpty()) {
                    result++;
                } else {
                    parenStack.pop();
                }
            }
        }
        result += parenStack.size();

        return result;
    }
}
