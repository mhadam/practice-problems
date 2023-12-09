package us.hadam.practice.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import us.hadam.practice.binarytree.util.TreeNode;

public class KthSmallest {
  public static int kthSmallestIterative(TreeNode root, int k) {
    Deque<TreeNode> stack = new LinkedList<>();
    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }

  public static List<Integer> traverse(TreeNode root) {
    return null;
  }

  public static int kthSmallestRecursive(TreeNode root, int k) {
    List<Integer> vals = traverse(root);
    return vals.get(vals.size() - k);
  }
}
