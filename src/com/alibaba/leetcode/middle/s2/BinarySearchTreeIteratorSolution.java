package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.alibaba.leetcode.struct.TreeNode;

/**
 * 173. Binary Search Tree Iterator
 * 
 * 173. 二叉搜索树迭代器
 * 
 * mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * BSTIterator iterator = new BSTIterator(root);
 * 
 * iterator.next(); // return 3
 * 
 * iterator.next(); // return 7
 * 
 * iterator.hasNext(); // return true
 * 
 * iterator.next(); // return 9
 * 
 * iterator.hasNext(); // return true
 * 
 * iterator.next(); // return 15
 * 
 * iterator.hasNext(); // return true
 * 
 * iterator.next(); // return 20
 * 
 * iterator.hasNext(); // return false  
 * 
 * Note:
 * 
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the
 * BST when next() is called.
 * 
 * @author wang
 * @date 2019/08/10
 */
public class BinarySearchTreeIteratorSolution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);

        TreeNode right = new TreeNode(15);
        right.left = new TreeNode(9);
        right.right = new TreeNode(20);
        root.right = right;

        BSTIterator2 iterator = new BSTIterator2(root);
        System.out.println(iterator.next());// 返回 3
        System.out.println(iterator.next()); // 返回 7
        iterator.hasNext(); // 返回 true
        iterator.next(); // 返回 9
        iterator.hasNext(); // 返回 true
        iterator.next(); // 返回 15
        iterator.hasNext(); // 返回 true
        iterator.next(); // 返回 20
        iterator.hasNext(); // 返回 false
    }
}

/**
 * 解法二：使用栈保存左节点，迭代时遇到右节点不为null的，则应当将右节点的左节点入栈
 * 
 * @author wang
 * @date 2019/08/10
 */
class BSTIterator2 {

    private Stack<TreeNode> s;

    public BSTIterator2(TreeNode root) {

        s = new Stack<>();
        TreeNode n = root;
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode n = s.pop();
        if (n.right != null) {
            TreeNode r = n.right;
            while (r != null) {
                s.push(r);
                r = r.left;
            }
        }
        return n.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return !s.isEmpty();
    }
}

/**
 * 解法一：使用hashmap保存每一个节点的下一个节点
 * 
 * @author wang
 * @date 2019/08/10
 */
class BSTIterator {

    private Map<TreeNode, TreeNode> cache;

    private TreeNode current;

    private boolean first = true;

    public BSTIterator(TreeNode root) {

        cache = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        inorder(root, ans);
        current = ans.size() == 0 ? null : ans.get(0);
        for (int i = 0; i < ans.size() - 1; i++) {
            cache.put(ans.get(i), ans.get(i + 1));
        }
    }

    private void inorder(TreeNode root, List<TreeNode> ans) {

        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root);
        inorder(root.right, ans);
    }

    /** @return the next smallest number */
    public int next() {

        if (first) {
            first = false;
            return current.val;
        }

        TreeNode node = cache.get(current);
        current = node;
        return node != null ? node.val : Integer.MIN_VALUE;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        if (first) {
            return current != null;
        }

        return cache.get(current) != null;
    }
}
