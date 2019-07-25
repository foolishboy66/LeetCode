package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * 
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 * @author wang
 * @date 2019/07/24
 */
public class ReverseLinkedListIISolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.listNodeToStr(
            new ReverseLinkedListIISolution().reverseBetween(ConvertUtils.buildListNode(1, 2, 3, 4, 5), 2, 4)));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return head;
        }
        int i = 1;
        ListNode node = head;
        ListNode pre = null;
        List<ListNode> reverseList = new ArrayList<>();
        ListNode post = null;
        while (node != null) {
            if (i < m) {
                pre = node;
            } else if (i >= m && i <= n) {
                reverseList.add(node);
            } else {
                if (post == null) {
                    post = node;
                }
            }
            node = node.next;
            i++;
        }
        ListNode tmp = pre;
        if (pre != null) {
            for (int j = reverseList.size() - 1; j >= 0; j--) {
                tmp.next = reverseList.get(j);
                tmp = tmp.next;
            }
            tmp.next = post;
            return head;
        } else {
            ListNode newHead;
            if (!reverseList.isEmpty()) {
                newHead = reverseList.get(reverseList.size() - 1);
                tmp = newHead;
                for (int j = reverseList.size() - 1; j >= 0; j--) {
                    tmp.next = reverseList.get(j);
                    tmp = tmp.next;
                }
                tmp.next = post;
            } else {
                newHead = post;
            }
            return newHead;
        }

    }
}
