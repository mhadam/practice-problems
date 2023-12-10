package us.hadam.practice.binarytree;

import java.util.*;
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
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    result.addAll(traverse(root.left));
    result.add(root.val);
    result.addAll(traverse(root.right));
    return result;
  }

  public static int kthSmallestIterAgain(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();
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

  public static int kthSmallestRecursive(TreeNode root, int k) {
    List<Integer> vals = traverse(root);
    return vals.get(k - 1);
  }
}
