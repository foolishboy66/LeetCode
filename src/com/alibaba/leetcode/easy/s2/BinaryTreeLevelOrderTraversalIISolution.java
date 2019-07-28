package com.alibaba.leetcode.easy.s2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 107. Binary Tree Level Order Traversal II
 * 
 * 107. 二叉树的层次遍历 II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 * return its bottom-up level order traversal as:
 * 
 * [ [15,7], [9,20], [3] ]
 * 
 * @author wang
 * @date 2019/07/27
 */
public class BinaryTreeLevelOrderTraversalIISolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(new BinaryTreeLevelOrderTraversalIISolution().levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int num = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.addFirst(tmp);
        }

        return ans;
    }
}
