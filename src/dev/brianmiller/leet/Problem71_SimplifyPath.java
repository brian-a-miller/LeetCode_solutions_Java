package dev.brianmiller.leet;

import java.util.Stack;

/**
 * @author       Brian A. Miller
 * @date         August 6, 2024
 * @leet.status  Accepted
 * @leet.runtime 4 ms (runtime beats 87.28 % of java submissions)
 * @leet.memory  43.5 MB
 *
 * My solution in Java for the LeetCode problem "71. Simplify Path"
 * described at https://leetcode.com/problems/simplify-path/
 *
 * I chose to use java.util.Stack data structure,
 * although this could be replaced by Dequeue or another
 * implementation of the stack data structure
 *
 */
public class Problem71_SimplifyPath {

    public static String simplifyPath(String path) {
        if (path == null || path.isBlank() || path.equals("/")) {
            return "/";
        }
        Stack<String> subdirectories = new Stack<String>();
        String[] sections = path.split("/");
        for (String dir : sections) {
            if (dir.equals("..")) {
                if (!subdirectories.empty()) {
                    subdirectories.pop();
                }
            } else if (!dir.equals(".") && !dir.isBlank()) {
                subdirectories.push(dir);
            }
        }
        StringBuilder pathSb = new StringBuilder();
        while (!subdirectories.empty()) {
            String dir = subdirectories.pop();
            pathSb.insert(0, dir);
            pathSb.insert(0, "/");
        }
        if (pathSb.length() == 0) {
            return "/";
        }
        return pathSb.toString();
    }
}
