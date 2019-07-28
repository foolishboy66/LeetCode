package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 112. Path Sum
 * 
 * 112. 路径总和
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * 
 * @author wang
 * @date 2019/07/28
 */
public class PathSumSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(21);

        System.out.println(new PathSumSolution().hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
