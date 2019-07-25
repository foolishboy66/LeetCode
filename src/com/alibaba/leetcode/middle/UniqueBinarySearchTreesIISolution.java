package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * 
 * Input: 3
 * 
 * Output: [   [1,null,3,2],   [3,2,null,1],   [3,1,null,null,2],   [2,1,3],   [1,null,2,null,3] ]
 * 
 * 
 * @author wang
 * @date 2019/07/24
 */
public class UniqueBinarySearchTreesIISolution {

    public static void main(String[] args) {

        List<TreeNode> trees = new UniqueBinarySearchTreesIISolution().generateTrees(3);
        for (TreeNode treeNode : trees) {
            System.out.println(ConvertUtils.treeNodeToStr(treeNode));
        }
    }

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return recusive(1, n);
    }

    private List<TreeNode> recusive(int start, int end) {

        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {

            List<TreeNode> leftNodes = recusive(start, i - 1);
            List<TreeNode> rightNodes = recusive(i + 1, end);

            for (TreeNode ledtNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = ledtNode;
                    curr.right = rightNode;
                    nodes.add(curr);
                }
            }
        }
        return nodes;
    }
}
