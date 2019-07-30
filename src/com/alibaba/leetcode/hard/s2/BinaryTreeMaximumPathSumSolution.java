package com.alibaba.leetcode.hard.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * 
 * 124. 二叉树中的最大路径和
 * 
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * 
 * Example 1:
 * 
 * Input: [1,2,3]
 * 
 * 1 / \ 2 3
 * 
 * Output: 6
 * 
 * Example 2:
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 *   -10    / \   9  20     /  \    15   7
 * 
 * Output: 42
 * 
 * 
 * @author wang
 * @date 2019/07/30
 */
public class BinaryTreeMaximumPathSumSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        System.out.println(new BinaryTreeMaximumPathSumSolution().maxPathSum(root));
    }

    int max = Integer.MIN_VALUE;

    /**
     * 自顶向下递归计算以某节点node作为定点所能获取的最大路径
     * 
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {

        getMaxTreeNode(root);
        return max;
    }

    private int getMaxTreeNode(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(getMaxTreeNode(root.left), 0);
        int right = Math.max(getMaxTreeNode(root.right), 0);

        int currMax = root.val + left + right;
        max = Math.max(max, currMax);

        return root.val + Math.max(left, right);
    }

}
