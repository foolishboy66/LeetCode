package com.alibaba.leetcode.middle.s2;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 156.Binary Tree Upside Down
 * 
 * 156.上下反转二叉树
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same
 * parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left
 * leaf nodes. Return the new root.
 * 
 * Example:
 * 
 * Input: [1,2,3,4,5]
 * 
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * 
 * @author wang
 * @date 2019/08/07
 */
public class BinaryTreeUpsideDownSolution {

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(3);

        TreeNode l = new TreeNode(2);
        l.left = new TreeNode(4);
        l.right = new TreeNode(5);
        head.left = l;
        TreeNode ans = new BinaryTreeUpsideDownSolution().upsideDownBinaryTree(head);

        System.out.println(ConvertUtils.treeNodeToStr(ans));
    }

    /**
     * 自底向上递归调用，root的右节点变成他的左孩子的左孩子，root变成它的左孩子节点的右孩，
     * 
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null || root.left == null) {
            return root;
        }
        TreeNode node = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return node;
    }
}
