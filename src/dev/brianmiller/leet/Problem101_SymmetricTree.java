package dev.brianmiller.leet;
/**
 * https://leetcode.com/problems/symmetric-tree/
 */
/*class TreeNode {
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
*/

/**
 * @author Brian A. Miller
 *
 * https://leetcode.com/u/bamjuggler/
 * https://github.com/brian-a-miller/LeetCode_solutions_Java
 *
 */
public class Problem101_SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if ((left == null) && (right == null)) {
            return true;
        }
        if ((left == null) != (right == null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return (isMirror(left.right, right.left) &&
               isMirror(left.left, right.right));      
    }
}
