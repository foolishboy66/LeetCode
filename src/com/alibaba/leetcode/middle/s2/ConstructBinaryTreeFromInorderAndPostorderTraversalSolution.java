package com.alibaba.leetcode.middle.s2;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * 106. 从中序与后序遍历序列构造二叉树
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3] Return the following binary tree:
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/27
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversalSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.treeNodeToStr(new ConstructBinaryTreeFromInorderAndPostorderTraversalSolution()
            .buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3})));

        System.out.println(ConvertUtils.treeNodeToStr(new ConstructBinaryTreeFromInorderAndPostorderTraversalSolution()
            .buildTree(new int[] {1, 2, 3, 4, 5}, new int[] {2, 1, 5, 4, 3})));
    }

    /**
     * 后序遍历的倒序序列中的每个元素是树的根节点
     * 
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return partition(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode partition(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
        Map<Integer, Integer> map) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 构造当前的根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 获取当前根节点在中序遍历中的位置
        Integer index = map.get(rootVal);
        // 右子树的节点数
        int right = inEnd - index;
        // 左子树的节点数
        int left = index - inStart;

        root.left = partition(inorder, inStart, index - 1, postorder, postStart, postStart + left - 1, map);
        root.right = partition(inorder, index + 1, inEnd, postorder, postEnd - right, postEnd - 1, map);

        return root;
    }

}
