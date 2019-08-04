package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 144. Binary Tree Preorder Traversal
 * 
 * 144. 二叉树的前序遍历
 * 
 * 
 * iven a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3]
 * 
 * 1 \ 2 / 3
 * 
 * Output: [1,2,3]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author wang
 * @date 2019/08/04
 */
public class BinaryTreePreorderTraversalSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(3);
        System.out.println(new BinaryTreePreorderTraversalSolution().preorderTraversal(root));
        
        System.out.println(new BinaryTreePreorderTraversalSolution().preorderTraversal2(root));
    }

    /**
     * 解法二：使用栈进行迭代
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = stack.pop();
                ans.add(n.val);
                if (n.right != null) {
                    stack.push(n.right);
                }
                if (n.left != null) {
                    stack.push(n.left);
                }
            }
        }

        return ans;
    }

    /**
     * 解法一：递归
     * 
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}
