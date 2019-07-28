package com.alibaba.leetcode.easy.s2;

import java.util.LinkedList;
import java.util.Queue;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * 
 * 104. 二叉树的最大深度
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * return its depth = 3.
 * 
 * 
 * @author wang
 * @date 2019/07/26
 */
public class MaximumDepthOfBinaryTreeSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(new MaximumDepthOfBinaryTreeSolution().maxDepth(root));
        System.out.println(new MaximumDepthOfBinaryTreeSolution().maxDepth2(root));
    }

    /**
     * 解法二：递归求解，根节点最大高度=左子树和右子树中的最大高度+1
     * 
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int lefeMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(lefeMax, rightMax) + 1;
    }

    /**
     * 解法一：层序遍历，遍历一层深度加一
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

}
