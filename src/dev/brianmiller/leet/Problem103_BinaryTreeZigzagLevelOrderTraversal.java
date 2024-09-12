package dev.brianmiller.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem103_BinaryTreeZigzagLevelOrderTraversal {

    record NodeAndLevel(TreeNode node, int level) {}

    /**
     * Status: Accepted
     * Result: Success
     * Test results: 33 / 33 test cases passed
     * Runtime: 1 ms, faster than 73.66% of Java online submissions
     * Memory Usage: 42.3 MB, less than 27.02% of Java online submissions
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<NodeAndLevel> q = new ArrayDeque<>();
        q.addLast(new NodeAndLevel(root, 0));
        int thisLevel = 0;
        List<Integer> levelList = new ArrayList<>();
        while (!q.isEmpty()) {
            var current = q.removeFirst();
            TreeNode node = current.node();
            int lvl = current.level();
            if (node.left != null) {
                q.addLast(new NodeAndLevel(node.left, lvl + 1));
            }
            if (node.right != null) {
                q.addLast(new NodeAndLevel(node.right, lvl + 1));
            }
            if (current.level() == thisLevel) {
                if (thisLevel % 2 == 0) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }
            } else {
                thisLevel++;
                result.add(levelList);
                levelList = new ArrayList<>();
                levelList.add(node.val);
            }
        }
        if (!levelList.isEmpty()) {
            result.add(levelList);
        }

        return result;
    }
}
