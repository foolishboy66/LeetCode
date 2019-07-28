package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 110. Balanced Binary Tree
 * 
 * 110. 平衡二叉树
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]
 * 
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]
 * 
 * Return false.
 * 
 * 
 * @author wang
 * @date 2019/07/27
 */
public class BalancedBinaryTreeSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(new BalancedBinaryTreeSolution().isBalanced(root));
    }

    /**
     * 递归
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right)
            && (Math.abs(getDepth(root.right) - getDepth(root.left)) <= 1);
    }

    private int getDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
