package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.struct.TreeNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * 
 * 109. 有序链表转换二叉搜索树
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * Example:
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 
 * 
 * @author wang
 * @date 2019/07/27
 */
public class ConvertSortedListToBinarySearchTreeSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.treeNodeToStr(new ConvertSortedListToBinarySearchTreeSolution()
            .sortedListToBST(ConvertUtils.buildListNode(-10, -3, 0, 5, 9))));

        System.out.println(ConvertUtils.treeNodeToStr(new ConvertSortedListToBinarySearchTreeSolution()
            .sortedListToBST2(ConvertUtils.buildListNode(-10, -3, 0, 5, 9))));
    }

    /**
     * 解法二：使用快慢指针找到根节点，递归构建
     * 
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {

        return buildBinarySearchTree(head, null);
    }

    private TreeNode buildBinarySearchTree(ListNode head, ListNode end) {

        if (head == end) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = buildBinarySearchTree(head, slow);
        root.right = buildBinarySearchTree(slow.next, end);

        return root;
    }

    /**
     * 解法一：将链表转为数组，然后递归构建
     * 
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {

        ListNode n = head;
        List<Integer> list = new ArrayList<>();
        while (n != null) {
            list.add(n.val);
            n = n.next;
        }

        return buildBinarySearchTree(list, 0, list.size() - 1);
    }

    private TreeNode buildBinarySearchTree(List<Integer> nums, int l, int r) {

        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        int rootVal = nums.get(mid);
        TreeNode root = new TreeNode(rootVal);

        root.left = buildBinarySearchTree(nums, l, mid - 1);
        root.right = buildBinarySearchTree(nums, mid + 1, r);

        return root;
    }
}
