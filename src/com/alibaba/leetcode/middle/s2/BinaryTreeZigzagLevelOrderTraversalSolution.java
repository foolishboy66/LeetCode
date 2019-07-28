package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 
 * 103. 二叉树的锯齿形层次遍历
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 * return its zigzag level order traversal as: [ [3], [20,9], [15,7] ]
 * 
 * 
 * @author wang
 * @date 2019/07/26
 */
public class BinaryTreeZigzagLevelOrderTraversalSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(new BinaryTreeZigzagLevelOrderTraversalSolution().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;

        while (!queue.isEmpty()) {

            int len = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (order) {
                    temp.add(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            order = !order;
            ans.add(temp);
        }

        return ans;
    }
}
