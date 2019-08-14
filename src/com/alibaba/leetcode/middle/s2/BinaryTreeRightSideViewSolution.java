package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 199. Binary Tree Right Side View
 * 
 * 199. 二叉树的右视图
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4]
 * 
 * Output: [1, 3, 4]
 * 
 * Explanation:
 * 
 * 1 <---
 * 
 * / \
 * 
 * 2 3 <---
 * 
 * \ \
 * 
 * 5 4 <---
 * 
 * @author wang
 * @date 2019/08/14
 */
public class BinaryTreeRightSideViewSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(5);

        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(4);

        root.left = left;
        root.right = right;

        System.out.println(new BinaryTreeRightSideViewSolution().rightSideView(root));
    }

    /**
     * 层序遍历的方式
     * 
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }

        }
        return ans;
    }
}
