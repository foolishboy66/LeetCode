package com.alibaba.leetcode.middle.s2;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 148. Sort List
 * 
 * 148. 排序链表
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3
 * 
 * Output: 1->2->3->4
 * 
 * Example 2:
 * 
 * Input: -1->5->3->4->0
 * 
 * Output: -1->0->3->4->5
 * 
 * @author wang
 * @date 2019/08/05
 */
public class SortListSolution {

    public static void main(String[] args) {

        ListNode node = new SortListSolution().sortList(ConvertUtils.buildListNode(new int[] {4, 2, 1, 3}));
        System.out.println(ConvertUtils.listNodeToStr(node));
    }

    /**
     * 归并排序
     * 
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if (left != null) {
            h.next = left;
        } else {
            h.next = right;
        }

        return ans.next;
    }
}
