package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 143. Reorder List
 * 
 * 143. 重排链表
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * 
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example 1:
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * @author wang
 * @date 2019/08/04
 */
public class ReorderListSolution {

    public static void main(String[] args) {

        ListNode node = ConvertUtils.buildListNode(1, 2, 3, 4, 5);
        new ReorderListSolution().reorderList(node);
        System.out.println(ConvertUtils.listNodeToStr(node));

        ListNode node2 = ConvertUtils.buildListNode(1, 2, 3, 4);
        new ReorderListSolution().reorderList(node2);
        System.out.println(ConvertUtils.listNodeToStr(node2));

        ListNode node3 = ConvertUtils.buildListNode(1, 2, 3, 4, 5);
        new ReorderListSolution().reorderList2(node3);
        System.out.println(ConvertUtils.listNodeToStr(node3));

        ListNode node4 = ConvertUtils.buildListNode(1, 2, 3, 4);
        new ReorderListSolution().reorderList2(node4);
        System.out.println(ConvertUtils.listNodeToStr(node4));
    }

    /**
     * 解法二：找到链表的中间节点将链表分为两段，将后边一段反转，最后合并两个链表
     * 
     * @param head
     */
    public void reorderList2(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 将链表分成两段
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;

        // 将第二段链表反转
        ListNode pre = null;
        while (h2 != null) {
            ListNode next = h2.next;
            h2.next = pre;
            pre = h2;
            h2 = next;
        }

        // 合并两个链表
        ListNode p1 = head;
        ListNode p2 = pre;
        ListNode n1;
        ListNode n2;
        while (p2 != null) {
            n1 = p1.next;
            n2 = p2.next;
            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }
    }

    /**
     * 解法一：使用list存储链表结果，然后重排链表
     * 
     * @param head
     */
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        int len = nodes.size();
        ListNode curr;
        for (int i = 0; i < len / 2; i++) {
            curr = nodes.get(i);
            ListNode n = nodes.get(len - 1 - i);
            n.next = curr.next;
            curr.next = n;
        }
        ListNode last = nodes.get(len / 2);
        last.next = null;
    }
}
