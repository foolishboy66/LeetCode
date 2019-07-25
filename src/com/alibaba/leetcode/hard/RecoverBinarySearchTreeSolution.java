package com.alibaba.leetcode.hard;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Follow up:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/25
 */
public class RecoverBinarySearchTreeSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        n1.right = n2;

        new RecoverBinarySearchTreeSolution().recoverTree(root);
        System.out.println(ConvertUtils.treeNodeToStr(root));
        
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(1);
        new RecoverBinarySearchTreeSolution().recoverTree(root2);
        System.out.println(ConvertUtils.treeNodeToStr(root2));
    }

    /**
     * 交换的可能性：
     * 
     * 1、根节点与左子树中的某个节点交换--左子树中最大的数与根节点交换即可恢复
     * 
     * 2、根节点与右子树中的某个节点交换--右子树中最小的数与根节点交换即可恢复
     * 
     * 3、左子树与右子树中的某个节点交换--左子树中最大的数与右子树中最小的数交换即可恢复
     * 
     * 4、左子树中的某两个节点交换--递归左子树，重复1、2、3即可恢复
     * 
     * 5、右子树中的某两个节点交换--递归右子树，重复1、2、3即可恢复
     * 
     * @param root
     */
    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode maxLeft = getMaxLeft(root.left);
        TreeNode minRight = getMinRight(root.right);
        
        if (maxLeft != null && minRight != null && maxLeft.val > minRight.val) {
            // 左子树与右子树中的某个节点交换
            int tmp = maxLeft.val;
            maxLeft.val = minRight.val;
            minRight.val = tmp;
        }

        if (maxLeft != null && maxLeft.val > root.val) {
            // 根节点与左子树中的某个节点交换
            int tmp = maxLeft.val;
            maxLeft.val = root.val;
            root.val = tmp;
        }
        if (minRight != null && minRight.val < root.val) {
            // 根节点与右子树中的某个节点交换
            int tmp = minRight.val;
            minRight.val = root.val;
            root.val = tmp;
        }

        recoverTree(root.left);
        recoverTree(root.right);
    }

    private TreeNode getMinRight(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = getMinRight(root.left);
        TreeNode right = getMinRight(root.right);

        TreeNode min = root;
        if (left != null && left.val < min.val) {
            min = left;
        }
        if (right != null && right.val < min.val) {
            min = right;
        }

        return min;
    }

    private TreeNode getMaxLeft(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = getMaxLeft(root.left);
        TreeNode right = getMaxLeft(root.right);

        TreeNode max = root;
        if (left != null && left.val > max.val) {
            max = left;
        }
        if (right != null && right.val > max.val) {
            max = right;
        }

        return max;
    }
}
