package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 101. Symmetric Tree
 * 
 * 101. 对称二叉树
 * 
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * But the following [1,2,2,null,3,null,3] is not
 * 
 * 
 * @author wang
 * @date 2019/07/26
 */
public class SymmetricTreeSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println(new SymmetricTreeSolution().isSymmetric(root));
    }

    /**
     * 递归：镜像的数他的左子树和右子树也是镜像的
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode l, TreeNode r) {

        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }

        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }
}
