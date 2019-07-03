package com.alibaba.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.utils.ConvertUtils;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 
 * 
 * @author wang
 * @date 2019/07/03
 */
public class RemoveNthNodeFromEndOfListSolution {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println(ConvertUtils.listNodeToStr(node));
        System.out
            .println(ConvertUtils.listNodeToStr(new RemoveNthNodeFromEndOfListSolution().removeNthFromEnd(node, 1)));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> list = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (n == list.size()) {
            // 第一个
            return head.next;
        }
        ListNode delNode = list.get(list.size() - n);
        ListNode preNode = list.get(list.size() - n - 1);
        preNode.next = delNode.next;

        return head;
    }
}
