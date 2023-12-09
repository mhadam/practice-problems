package us.hadam.practice.binarytree;

import us.hadam.practice.binarytree.util.TreeNode;

public class IsSymmetric {

  // explainer: consider you can test symmetry by doing a transposition, that may best be thought of
  // as zipping up the inner & outer subtrees into new symmetric, smaller trees
  public static boolean isSymmetricWeird(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    boolean test = (root.left != null && root.right != null && root.left.val == root.right.val);
    return test
        && isSymmetricWeird(new TreeNode(0, root.left.right, root.right.left))
        && isSymmetricWeird(new TreeNode(0, root.left.left, root.right.right));
  }

  public static boolean isSymmetric(TreeNode root) {
    return isMirror(root.left, root.right);
  }

  public static boolean isMirror(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) {
      return true;
    }
    return (n1 != null && n2 != null)
        && (n1.val == n2.val)
        && isMirror(n1.right, n2.left)
        && isMirror(n1.left, n2.right);
  }
}
