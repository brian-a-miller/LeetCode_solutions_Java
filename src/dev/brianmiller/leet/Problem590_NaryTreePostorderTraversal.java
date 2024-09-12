package dev.brianmiller.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author           Brian A. Miller
 * @date             Wednesday, September 4, 2024
 * @leetcode.status  Accepted
 * @leetcode.result  Success
 * @leetcode.tests   38 / 38 test cases passed.
 * @leetcode.runtime 0 ms, faster than 100.00% of Java online submissions
 * @leetcode.memory. 44.3 MB, less than 96.20% of Java online submissions
 */
public class Problem590_NaryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private static void postorderRecursive(Node root, List<Integer> result) {
        if (result == null) {
            result = new ArrayList<>();
        }
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                postorderRecursive(child, result);
            }
        }
        result.add(root.val);
    }
}
