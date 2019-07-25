package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author wang
 * @date 2019/07/24
 */
public class BinaryTreeInorderTraversalSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;

        System.out.println(new BinaryTreeInorderTraversalSolution().inorderTraversal(root));

        TreeNode root2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        right2.left = new TreeNode(3);
        root2.right = right2;

        System.out.println(new BinaryTreeInorderTraversalSolution().inorderTraversal2(root2));
    }

    /**
     * 解法一：递归
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        recursive(ans, root);

        return ans;
    }

    private void recursive(List<Integer> ans, TreeNode root) {

        if (root == null) {
            return;
        }

        recursive(ans, root.left);
        ans.add(root.val);
        recursive(ans, root.right);
    }

    /**
     * 解法二：基于栈的方式
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }

        return ans;
    }
}
