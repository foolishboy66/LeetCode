package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Example 1:
 * 
 * Input: 1->1->2 Output: 1->2 Example 2:
 * 
 * Input: 1->1->2->3->3 Output: 1->2->3
 * 
 * 
 * @author wang
 * @date 2019/07/22
 */
public class RemoveDuplicatesFromSortedListSolution {

    public static void main(String[] args) {

        ListNode head = ConvertUtils.buildListNode(1, 1, 2);
        System.out
            .println(ConvertUtils.listNodeToStr(new RemoveDuplicatesFromSortedListSolution().deleteDuplicates(head)));

        ListNode head2 = ConvertUtils.buildListNode(1, 1, 2, 3, 3);
        System.out
            .println(ConvertUtils.listNodeToStr(new RemoveDuplicatesFromSortedListSolution().deleteDuplicates(head2)));

        ListNode head3 = ConvertUtils.buildListNode(1, 1, 1);
        System.out
            .println(ConvertUtils.listNodeToStr(new RemoveDuplicatesFromSortedListSolution().deleteDuplicates(head3)));
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
