package com.alibaba.leetcode.easy.s2;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 113. Path Sum II
 * 
 * 113. 路径总和 II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * Return:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/28
 */
public class PathSumIISolution {

    public static void main(String[] args) {

        TreeNode root = ConvertUtils.buildTreeNodeFromPreorderAndInorder(new int[] {5, 4, 11, 7, 2, 8, 13, 4, 5, 1},
            new int[] {7, 11, 2, 4, 5, 13, 8, 5, 4, 1});
        System.out.println(new PathSumIISolution().pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(root, ans, sum, new ArrayList<>());

        return ans;
    }

    private void dfs(TreeNode root, List<List<Integer>> ans, int sum, List<Integer> temp) {

        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ans.add(new ArrayList<>(temp));
            }
        }

        dfs(root.left, ans, sum - root.val, temp);
        dfs(root.right, ans, sum - root.val, temp);
        temp.remove(temp.size() - 1);
    }
}
