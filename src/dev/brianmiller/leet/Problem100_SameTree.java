package dev.brianmiller.leet;

/**
 * A solution to https://leetcode.com/problems/same-tree/
 */
public class Problem100_SameTree {

    /**
     *
     * @author            Brian A. Miller (https://leetcode.com/u/bamjuggler/ )
     * @date              August 6, 2024
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        }
        if ((p == null) != (q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
