package us.hadam.practice.divideconquer;

import us.hadam.practice.binarytree.util.TreeNode;

public class SortArrayToBST {
    int nums[];
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }

    public TreeNode helper(int lower, int upper) {
        if (lower > upper) return null;
        int midpoint = (upper + lower)/2;
        TreeNode root = new TreeNode(nums[midpoint]);
        root.left = helper(lower, midpoint-1);
        root.right = helper(midpoint+1, upper);
        return root;
    }
}
