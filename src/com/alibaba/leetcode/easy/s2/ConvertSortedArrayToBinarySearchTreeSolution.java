package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * 108. 将有序数组转换为二叉搜索树
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * Example:
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 
 * 
 * @author wang
 * @date 2019/07/27
 */
public class ConvertSortedArrayToBinarySearchTreeSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.treeNodeToStr(
            new ConvertSortedArrayToBinarySearchTreeSolution().sortedArrayToBST(new int[] {-10, -3, 0, 5, 9})));
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return buildBinarySearchTree(nums, 0, nums.length - 1);
    }

    /**
     * 根节点位于数组的中位数，根节点左边构造左子树，右边构造右子树
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode buildBinarySearchTree(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        int rootVal = nums[mid];
        TreeNode root = new TreeNode(rootVal);

        root.left = buildBinarySearchTree(nums, l, mid - 1);
        root.right = buildBinarySearchTree(nums, mid + 1, r);

        return root;
    }
}
