package com.alibaba.leetcode.easy;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * 
 * 
 * @author wang
 * @date 2019/07/25
 */
public class SameTreeSolution {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1);
        TreeNode pl = new TreeNode(2);
        TreeNode pr = new TreeNode(3);
        p.left = pl;
        p.right = pr;

        TreeNode q = new TreeNode(1);
        TreeNode ql = new TreeNode(2);
        TreeNode qr = new TreeNode(3);
        q.left = ql;
        q.right = qr;

        System.out.println(new SameTreeSolution().isSameTree(p, q));
    }

    /**
     * 递归式的dfs
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if ((p == null) ^ (q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

}
