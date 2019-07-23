package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5
 * 
 * Example 2:
 * 
 * Input: 1->1->1->2->3 Output: 2->3
 * 
 * 
 * @author wang
 * @date 2019/07/22
 */
public class RemoveDuplicatesFromSortedListIISolution {

    public static void main(String[] args) {

        ListNode head = ConvertUtils.buildListNode(1, 2, 3, 3, 4, 4, 5);
        ListNode node = new RemoveDuplicatesFromSortedListIISolution().deleteDuplicates(head);
        System.out.println(ConvertUtils.listNodeToStr(node));

        ListNode head2 = ConvertUtils.buildListNode(1, 1, 1, 2, 3, 3, 4, 4, 5);
        ListNode node2 = new RemoveDuplicatesFromSortedListIISolution().deleteDuplicates(head2);
        System.out.println(ConvertUtils.listNodeToStr(node2));

        ListNode head3 = ConvertUtils.buildListNode(1, 2, 2);
        ListNode node3 = new RemoveDuplicatesFromSortedListIISolution().deleteDuplicates(head3);
        System.out.println(ConvertUtils.listNodeToStr(node3));

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        ListNode newHead = null;
        ListNode pre = null;
        ListNode n = null;
        while (node != null) {
            if ((pre == null || pre.val != node.val) && (node.next == null || node.next.val != node.val)) {
                if (newHead == null) {
                    newHead = node;
                    n = newHead;
                } else {
                    n.next = node;
                    n = n.next;
                }
            }
            pre = node;
            node = node.next;
        }
        if (n != null) {
            n.next = null;
        }

        return newHead;
    }
}
