package com.alibaba.leetcode.middle.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * 
 * 129. 求根到叶子节点数字之和
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * 1 / \ 2 3 Output: 25
 * 
 * Explanation:
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * 
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * 
 * Input: [4,9,0,5,1] 4 / \ 9 0  / \ 5 1 Output: 1026
 * 
 * Explanation:
 * 
 * The root-to-leaf path 4->9->5 represents the number 495.
 * 
 * The root-to-leaf path 4->9->1 represents the number 491.
 * 
 * The root-to-leaf path 4->0 represents the number 40.
 * 
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * 
 * 
 * @author wang
 * @date 2019/07/31
 */
public class SumRootToLeafNumbersOSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumRootToLeafNumbersOSolution().sumNumbers(root));
    }

    /**
     * 前序遍历的思想递归计算
     * 
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {

        return getSum(root, 0);
    }

    private int getSum(TreeNode root, int sum) {

        if (root == null) {
            return sum;
        }

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return getSum(root.left, sum) + getSum(root.right, sum);
    }
}
