package dev.brianmiller.leet;

/**
 * @author Brian A. Miller
 *
 * My Java solution to the LeetCode problem
 *
 * 20. Valid Parentheses
 *
 * as described at https://leetcode.com/problems/valid-parentheses/
 *
 */
public class Problem20_ValidParentheses {

    /**
     * @author Brian A. Miller
     *
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ('('):
                case ('{'):
                case ('['):
                    stack.push(c);
                    break;
                case (')'):
                    if (stack.empty() || (stack.peek() != '(')) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ('}'):
                    if (stack.empty() || (stack.peek() != '{')) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case (']'):
                    if (stack.empty() || (stack.peek() != '[')) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        return stack.empty();
    }
}
