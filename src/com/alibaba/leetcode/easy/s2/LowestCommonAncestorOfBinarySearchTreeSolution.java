package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * 235. 二叉搜索树的最近公共祖先
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 
 * Output: 6
 * 
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * Example 2:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 
 * Output: 2
 * 
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA
 * definition.  
 * 
 * Note:
 * 
 * All of the nodes' values will be unique.
 * 
 * p and q are different and both values will exist in the BST.
 * 
 * @author wang
 * @date 2019/08/17
 */
public class LowestCommonAncestorOfBinarySearchTreeSolution {
    
    public static void main(String[] args) {

        
        
    }

    /**
     * 若根节点的值比两个节点的值都大，说明最近公共祖先在根节点左边，若根节点的值比两个节点的值都小，说明最近公共祖先在根节点右边
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
