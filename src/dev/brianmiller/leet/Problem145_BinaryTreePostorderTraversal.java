package dev.brianmiller.leet;

import java.util.ArrayList;
import java.util.List;

public class Problem145_BinaryTreePostorderTraversal {

    /**
     * @author Brian A. Miller (bamjuggler)
     * @date Thursday, August 10, 2024
     * @leetcode.status Accepted
     * @leetcode.result Success
     * @leetcode.test.results 71 / 71 test cases passed
     * @leetcode.runtime 0 ms, faster than 100% of Java submissions
     * @leetcode.memory 41.5 MB, less than 52.20% of Java submissions
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        postOrderTraversal(root, resultList);
        return resultList;
    }

    private static void postOrderTraversal(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postOrderTraversal(root.left, resultList);
        }
        if (root.right != null) {
            postOrderTraversal(root.right, resultList);
        }
        resultList.add(root.val);
    }
}
