package us.hadam.practice.binarytree;

import us.hadam.practice.binarytree.util.TreeNode;

public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode swap = root.right;
        root.right = root.left;
        root.left = swap;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
