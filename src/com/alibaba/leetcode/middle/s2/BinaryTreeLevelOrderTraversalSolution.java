package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 102. Binary Tree Level Order Traversal
 * 
 * 102. 二叉树的层次遍历
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 * return its level order traversal as: [ [3], [9,20], [15,7] ]
 * 
 * 
 * @author wang
 * @date 2019/07/26
 */
public class BinaryTreeLevelOrderTraversalSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(new BinaryTreeLevelOrderTraversalSolution().levelOrder(root));
        System.out.println(new BinaryTreeLevelOrderTraversalSolution().levelOrder(null));
    }

    /**
     * 使用队列存储每一层的节点
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(temp);
        }

        return ans;
    }

}
