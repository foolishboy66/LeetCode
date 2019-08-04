package com.alibaba.leetcode.hard.s2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 145. Binary Tree Postorder Traversal
 * 
 * 145. 二叉树的后序遍历
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,null,2,3]
 * 
 * 1 \ 2 / 3
 * 
 * Output: [3,2,1]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * @author wang
 * @date 2019/08/04
 */
public class BinaryTreePostorderTraversalSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(3);
        System.out.println(new BinaryTreePostorderTraversalSolution().postorderTraversal(root));
        System.out.println(new BinaryTreePostorderTraversalSolution().postorderTraversal2(root));
    }

    /**
     * 解法二：使用栈的方式递归
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = stack.pop();
                ans.addFirst(n.val);
                if (n.left != null) {
                    stack.push(n.left);
                }
                if (n.right != null) {
                    stack.push(n.right);
                }
            }
        }

        return ans;
    }

    /**
     * 解法一：递归
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }

}
