package us.hadam.practice.binarytree;

import us.hadam.practice.binarytree.util.TreeNode;

public class IsSameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == q && p == null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
