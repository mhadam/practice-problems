package us.hadam.practice.binarytree.util;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public Integer height;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.height = null;
  }
}
