package dev.brianmiller.leet;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Problem226_InvertBinaryTree {

    public static TreeNode invertTree_MySolution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree_MySolution1(root.left);
        invertTree_MySolution1(root.right);
        return root;
    }

    public static TreeNode invertTree_MySolution2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree_MySolution2(root.left);
        invertTree_MySolution2(root.right);

        return root;
    }

    public static TreeNode invertTree_mySolutionIterative(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();

            // swap children
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;

            if (current.left != null) {
                nodeStack.push(current.left);
            }
            if (current.right != null) {
                nodeStack.push(current.right);
            }
        }
        return root;
    }
}

