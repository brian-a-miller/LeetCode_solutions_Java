package dev.brianmiller.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199_BinaryTreeRightSideView {

    /**
     * @author Brian A. Miller
     * @date Monday, December 2, 2024
     * @leetcode.status Accepted
     * @leetcode.test.results 217 / 217 test cases passed
     * @leetcode.runtime faster than 67.13% of Java online submissions
     * @leetcode.memory 42.1 MB, less than 32.09% of Java online submissions
     */
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        result.add(root.val);

        if ((root.left == null) && (root.right == null)) {
            return result;
        }

        Queue<TreeNode> bfsNodes = new LinkedList<TreeNode>();
        if (root.left != null) {
            bfsNodes.add(root.left);
        }
        if (root.right != null) {
            bfsNodes.add(root.right);
        }

        while (!bfsNodes.isEmpty()) {
            int numNodesThisLevel = bfsNodes.size();
            for (int i = 1; i <= numNodesThisLevel; i++) {
                TreeNode node = bfsNodes.remove();
                if (i == numNodesThisLevel) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    bfsNodes.add(node.left);
                }
                if (node.right != null) {
                    bfsNodes.add(node.right);
                }
            }
        }

        return result;
    }
}
