package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * 
 * Output: 1->2->2->4->3->5
 * 
 * 
 * @author wang
 * @date 2019/07/23
 */
public class PartitionListSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils
            .listNodeToStr(new PartitionListSolution().partition(ConvertUtils.buildListNode(1, 4, 3, 2, 5, 2), 3)));

    }

    /**
     * 将左右两部分分别存在list中，最后将list中的元素拼接起来
     * 
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        List<ListNode> left = new ArrayList<>();
        List<ListNode> right = new ArrayList<>();
        while (node != null) {
            if (node.val >= x) {
                right.add(node);
            } else {
                left.add(node);
            }
            node = node.next;
        }
        ListNode newHead = null;
        ListNode tmp = null;
        if (left.size() > 0) {
            newHead = left.get(0);
            tmp = newHead;
            for (int i = 1; i < left.size(); i++) {
                tmp.next = left.get(i);
                tmp = tmp.next;
            }
        }
        if (right.size() > 0) {
            int start = newHead == null ? 1 : 0;
            if (newHead == null) {
                newHead = right.get(0);
                tmp = newHead;
            }
            for (int i = start; i < right.size(); i++) {
                tmp.next = right.get(i);
                tmp = tmp.next;
            }
        }
        tmp.next = null;

        return newHead;
    }
}
