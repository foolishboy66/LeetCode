package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * 
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * 
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * @author wang
 * @date 2019/07/25
 */
public class ValidateBinarySearchTreeSolution {

    public static void main(String[] args) {

        TreeNode r1 = new TreeNode(2);
        TreeNode pl = new TreeNode(1);
        TreeNode pr = new TreeNode(3);
        r1.left = pl;
        r1.right = pr;
        System.out.println(new ValidateBinarySearchTreeSolution().isValidBST(r1));

        TreeNode r2 = new TreeNode(10);
        TreeNode r2l = new TreeNode(5);
        r2l.left = new TreeNode(15);
        TreeNode r2r = new TreeNode(6);
        r2r.left = new TreeNode(20);
        r2.left = r2l;
        r2.right = r2r;
        System.out.println(new ValidateBinarySearchTreeSolution().isValidBST(r2));
    }

    /**
     * 递归式的dfs
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        if (!isValidBST(root.left, min, root.val) || !isValidBST(root.right, root.val, max)) {
            return false;
        }

        return true;
    }
}
