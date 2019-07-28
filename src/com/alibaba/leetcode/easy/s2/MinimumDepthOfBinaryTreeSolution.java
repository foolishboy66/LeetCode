package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * 
 * 111. 二叉树的最小深度
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * return its minimum depth = 2.
 * 
 * @author wang
 * @date 2019/07/28
 */
public class MinimumDepthOfBinaryTreeSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(new MinimumDepthOfBinaryTreeSolution().minDepth(root));

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);

        System.out.println(new MinimumDepthOfBinaryTreeSolution().minDepth(r2));
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }
    }
}
