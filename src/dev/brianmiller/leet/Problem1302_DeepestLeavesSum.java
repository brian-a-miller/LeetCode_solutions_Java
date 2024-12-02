package dev.brianmiller.leet;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1302_DeepestLeavesSum {

    /**
     * @author Brian A. Miller (bamjuggler on leetcode)
     * @date Monday, December 2, 2024
     *
     * LeetCode: Status = Accepted, Success
     * 39 / 39 test cases passed
     * Runtime: 7 ms, faster than 61.30% of Java online submissions
     * Memory Usage: 46 MB, less than 69.99% of Java online submissions
     */
    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLastLevel = 0;

        Queue<TreeNode> nodesInLevel = new LinkedList<TreeNode>();
        nodesInLevel.add(root);
        while (!nodesInLevel.isEmpty()) {
            int numNodesInLevel = nodesInLevel.size();
            sumLastLevel = 0;
            for (int i = 0; i < numNodesInLevel; i++) {
                TreeNode node = nodesInLevel.remove();
                sumLastLevel += node.val;
                if (node.left != null) {
                    nodesInLevel.add(node.left);
                }
                if (node.right != null) {
                    nodesInLevel.add(node.right);
                }
            }
        }

        return sumLastLevel;
    }
}
