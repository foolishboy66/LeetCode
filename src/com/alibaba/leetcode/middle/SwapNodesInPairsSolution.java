package com.alibaba.leetcode.middle;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 *  
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author wang
 * @date 2019/07/04
 */
public class SwapNodesInPairsSolution {

    public static void main(String[] args) {

        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);

        System.out.println(ConvertUtils.listNodeToStr(new SwapNodesInPairsSolution().swapPairs(n)));
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode l = head;
        ListNode preNode = null;
        while (l != null && l.next != null) {
            swap(l, l.next, preNode);
            preNode = l;
            l = l.next;
        }

        return node;
    }

    private void swap(ListNode n1, ListNode n2, ListNode preNode) {
        n1.next = n2.next;
        n2.next = n1;
        if (preNode != null) {
            preNode.next = n2;
        }
    }
}
