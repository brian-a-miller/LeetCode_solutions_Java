package dev.brianmiller.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem102_BinaryTreeLevelOrderTraversal {

    record NodeAndLevel(TreeNode node, int level) {}

    /**
     * 35 / 35 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 44.9 MB
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //List<Integer> firstLevel = new ArrayList<>();
        //firstLevel.add(root.val);
        //result.add(firstLevel)

        Deque<NodeAndLevel> valAndLevel = new ArrayDeque<>();
        int level = 0;
        valAndLevel.offerLast(new NodeAndLevel(root, 0));
        List<Integer> currentLevelValues = new ArrayList<>();
        while (!valAndLevel.isEmpty()) {
            NodeAndLevel current = valAndLevel.pollFirst();
            if (current.node().left != null) {
                valAndLevel.offerLast(new NodeAndLevel(current.node().left, current.level() + 1));
            }
            if (current.node().right != null) {
                valAndLevel.offerLast(new NodeAndLevel(current.node().right, current.level() + 1));
            }

            if (current.level() != level) {

                // save off previous list
                result.add(currentLevelValues);

                // reset
                level = current.level();
                currentLevelValues = new ArrayList<>();
            }
            currentLevelValues.add(current.node().val);
        }
        if (!currentLevelValues.isEmpty()) {
            result.add(currentLevelValues);
        }

        return result;
    }
}
