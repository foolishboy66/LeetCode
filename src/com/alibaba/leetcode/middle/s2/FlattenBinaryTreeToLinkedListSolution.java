package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 114. Flatten Binary Tree to Linked List
 * 
 * 114. 二叉树展开为链表
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 1 / \ 2 5 / \ \ 3 4 6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/28
 */
public class FlattenBinaryTreeToLinkedListSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        new FlattenBinaryTreeToLinkedListSolution().flatten(root);

        System.out.println(ConvertUtils.treeNodeToStr(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        new FlattenBinaryTreeToLinkedListSolution().flatten3(root2);
        System.out.println(ConvertUtils.treeNodeToStr(root2));
    }

    public void flatten2(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode temp = null;
        preorder(root, temp);
//        root = temp;
    }
    
    
    TreeNode temp;
    public void flatten3(TreeNode root) {

        if (root == null) {
            return;
        }

        if (temp!=null) {
            temp.left = null;
            temp.right = root;
        }
        temp = root;
        TreeNode right = root.right;
        flatten3(root.left);
        flatten3(right);
    }

    private void preorder(TreeNode root, TreeNode temp) {

        if (root == null) {
            return;
        }
        if (temp != null) {
            temp.left = null;
            temp.right = root;
        }
        temp = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        preorder(left, temp);
        preorder(right, temp);
    }

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        TreeNode node = root;
        for (int i = 1; i < ans.size(); i++) {
            node.left = null;
            node.right = new TreeNode(ans.get(i));
            node = node.right;
        }

    }

    private void preorder(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

}
