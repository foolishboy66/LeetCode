package com.alibaba.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * @author wang
 * @date 2019/07/04
 */
public class Merge2SortedListSolution {

    public static void main(String[] args) {

        // Input: 1->2->4, 1->3->4
        // Output: 1->1->2->3->4->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(ConvertUtils.listNodeToStr(new Merge2SortedListSolution().mergeTwoLists2(l1, l2)));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(4);

        ListNode l4 = new ListNode(1);
        l4.next = new ListNode(3);
        l4.next.next = new ListNode(4);
        System.out.println(ConvertUtils.listNodeToStr(new Merge2SortedListSolution().mergeTwoLists(l3, l4)));
    }

    /**
     * 解法一：遍历两个链表，将较小的node放到list中，然后重新组装成新的链表
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        List<ListNode> list = new ArrayList<>();
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                list.add(n1);
                n1 = n1.next;
            } else {
                list.add(n2);
                n2 = n2.next;
            }
        }
        while (n1 != null) {
            list.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            list.add(n2);
            n2 = n2.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        ListNode head = list.get(0);
        ListNode node = head;
        for (int i = 1; i < list.size(); i++) {
            node.next = list.get(i);
            node = node.next;
        }

        return head;
    }

    /**
     * 解法二：递归法
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
