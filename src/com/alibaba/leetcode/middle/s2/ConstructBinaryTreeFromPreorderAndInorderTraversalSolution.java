package com.alibaba.leetcode.middle.s2;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * 105. 从前序与中序遍历序列构造二叉树
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7]
 * 
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * @author wang
 * @date 2019/07/26
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.treeNodeToStr(new ConstructBinaryTreeFromPreorderAndInorderTraversalSolution()
            .buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7})));
    }

    /**
     * 递归分治法：前序遍历中的元素是根节点，该元素恰好在中序遍历的数组中作为左右子树的分割元素
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return partition(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode partition(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
        Map<Integer, Integer> map) {

        if (preEnd == preStart) {
            return null;
        }

        // 构造当前的根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 获取当前根节点在中序遍历中的位置
        Integer index = map.get(rootVal);

        int left = index - inStart;

        // 构造左子树
        root.left = partition(preorder, preStart + 1, preStart + 1 + left, inorder, inStart, index, map);
        // 构造右子树
        root.right = partition(preorder, preStart + 1 + left, preEnd, inorder, index + 1, inEnd, map);

        return root;
    }

}
