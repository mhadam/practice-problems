package us.hadam.practice.binarytree.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    private List<Integer> values;
    private TreeNode head;

    public BinarySearchTree(Integer[] values) {
        new BinarySearchTree(Arrays.stream(values).toList());
    }

    public BinarySearchTree(List<Integer> values) {
        this.values = values;
        this.head = create(values);
    }

    public static List<Integer> getHeights(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        Integer k = 0;
        while (true) {
            while (root != null) {
                stack.add(root);
                k++;
                result.add(k);
                root = root.left;
            }
            root = stack.pop();
            k--;
            result.add(k);
            root = root.right;
        }
//        return result;
    }

    public static TreeNode create(Integer[] values) {
        return create(Arrays.stream(values).toList());
    }

    public static TreeNode create(List<Integer> values) {
        TreeNode root = null;
        for (Integer v: values) {
            if (v == null) {
                continue;
            }
            if (root == null) {
                root = new TreeNode(v);
            } else {
                TreeNode cur = root;
                while (true) {
                    if (v > cur.val) {
                        if (cur.right == null) {
                            cur.right = new TreeNode(v);
                            break;
                        }
                        cur = cur.right;
                    } else if (v < cur.val) {
                        if (cur.left == null) {
                            cur.left = new TreeNode(v);
                            break;
                        }
                        cur = cur.left;
                    }
                }
            }
        }
        return root;
    }
}
