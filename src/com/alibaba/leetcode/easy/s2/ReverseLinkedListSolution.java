package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 206. Reverse Linked List
 * 
 * 206. 反转链表
 * 
 * 
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL
 * 
 * Output: 5->4->3->2->1->NULL
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * 
 * @author wang
 * @date 2019/08/15
 */
public class ReverseLinkedListSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.listNodeToStr(
            new ReverseLinkedListSolution().reverseList(ConvertUtils.buildListNode(new int[] {1, 2, 3, 4, 5}))));
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
