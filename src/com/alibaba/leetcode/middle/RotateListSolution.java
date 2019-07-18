package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * 
 * Output: 4->5->1->2->3->NULL
 * 
 * Explanation: rotate 1 steps to the right: 5->1->2->3->4->NULL rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * 
 * Input: 0->1->2->NULL, k = 4
 * 
 * Output: 2->0->1->NULL
 * 
 * Explanation: rotate 1 steps to the right: 2->0->1->NULL rotate 2 steps to the right: 1->2->0->NULL rotate 3 steps to
 * the right: 0->1->2->NULL rotate 4 steps to the right: 2->0->1->NULL
 * 
 * 
 * @author wang
 * @date 2019/07/18
 */
public class RotateListSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils
            .listNodeToStr(new RotateListSolution().rotateRight(ConvertUtils.buildListNode(1, 2, 3, 4, 5), 2)));
    }

    /**
     * 解法二：先将链表结成环，然后定位到新的头和尾结点，断开对应的头尾节点即可
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        ListNode n = head;
        int count = 1;
        while (n != null && n.next != null) {
            count++;
            n = n.next;
        }
        if (count <= 1 || (k % count == 0)) {
            return head;
        }

        // 连接成环
        n.next = head;
        ListNode tail = head;
        for (int i = 0; i < count - (k % count) - 1; i++) {
            tail = tail.next;
        }
        // tail是新的尾节点，head是新的头结点
        ListNode h = tail.next;
        // 尾节点从环中断开
        tail.next = null;

        return h;
    }

    /**
     * 解法一：先将链表节点存到list中，再操作节点数据
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {

        List<ListNode> nodes = new ArrayList<>();
        ListNode n = head;
        while (n != null) {
            nodes.add(n);
            n = n.next;
        }

        int count;
        if (nodes.size() <= 1 || (count = k % nodes.size()) == 0) {
            return head;
        }
        ListNode node = nodes.get(nodes.size() - count);
        ListNode temp = nodes.get(nodes.size() - 1);
        temp.next = nodes.get(0);
        nodes.get(nodes.size() - count - 1).next = null;

        return node;
    }
}
