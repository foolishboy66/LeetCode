package com.alibaba.leetcode.middle.s2;

import java.util.Stack;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 * 
 * 230. 二叉搜索树中第K小的元素
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * 
 * 3 / \ 1 4 \   2
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 
 * 5 / \ 3 6 / \ 2 4 / 1
 * 
 * Output: 3
 * 
 * Follow up:
 * 
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
 * would you optimize the kthSmallest routine?
 * 
 * 
 * @author wang
 * @date 2019/08/15
 */
public class KthSmallestElementInBSTSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        left.right = new TreeNode(2);
        root.left = left;
        root.right = new TreeNode(4);

        System.out.println(new KthSmallestElementInBSTSolution().kthSmallest(root, 1));
    }

    /**
     * 中序遍历的方式
     * 
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode n = root;
        while (n != null || !stack.isEmpty()) {

            while (n != null) {
                stack.push(n);
                n = n.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                count++;
                if (count == k) {
                    return node.val;
                }
                n = node.right;
            }
        }
        return -1;
    }
}
