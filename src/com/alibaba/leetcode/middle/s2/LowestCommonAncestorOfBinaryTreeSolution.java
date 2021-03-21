package com.alibaba.leetcode.middle.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * 
 * 236. 二叉树的最近公共祖先
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 
 * Output: 3
 * 
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 
 * Output: 5
 * 
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA
 * definition.  
 * 
 * Note:
 * 
 * All of the nodes' values will be unique.
 * 
 * p and q are different and both values will exist in the binary tree.
 * 
 * @author wang
 * @date 2019/08/17
 */
public class LowestCommonAncestorOfBinaryTreeSolution {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        backTrack(root, p, q);

        return ans;
    }

    /**
     * 带标记的递归回溯法
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean backTrack(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {

            return false;
        }

        int left = backTrack(root.left, p, q) ? 1 : 0;
        int right = backTrack(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        int res = left + right + mid;
        if (res >= 2) {
            this.ans = root;
        }
        return res > 0;
    }
}
