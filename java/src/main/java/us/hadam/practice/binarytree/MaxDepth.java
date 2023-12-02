package us.hadam.practice.binarytree;

import us.hadam.practice.binarytree.util.TreeNode;

public class MaxDepth {
    // [3,9,20,null,null,15,7]
    // output 3
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
