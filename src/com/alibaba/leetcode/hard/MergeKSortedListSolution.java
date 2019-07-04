package com.alibaba.leetcode.hard;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Example:
 * 
 * Input: [   1->4->5,   1->3->4,   2->6 ]
 * 
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 * @author wang
 * @date 2019/07/04
 */
public class MergeKSortedListSolution {

    public static void main(String[] args) {

        ListNode l1 = ConvertUtils.buildListNode(1, 4, 5);
        ListNode l2 = ConvertUtils.buildListNode(1, 3, 4);
        ListNode l3 = ConvertUtils.buildListNode(2, 6);

        ListNode[] lists = new ListNode[] {l1, l2, l3};
        System.out.println(ConvertUtils.listNodeToStr(new MergeKSortedListSolution().mergeKLists(lists)));

        ListNode l4 = ConvertUtils.buildListNode(1, 4, 5);
        ListNode l5 = ConvertUtils.buildListNode(1, 3, 4);
        ListNode l6 = ConvertUtils.buildListNode(2, 6);
        ListNode[] lists2 = new ListNode[] {l4, l5, l6};
        System.out.println(ConvertUtils.listNodeToStr(new MergeKSortedListSolution().mergeKLists2(lists2)));
    }

    /**
     * 解法一：遍历数组，每两个链表合并
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode node = null;
        for (int i = 0; i < lists.length; i++) {
            node = sort2(node, lists[i]);
        }

        return node;
    }

    /**
     * 解法二：归并排序
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return solve(lists, 0, lists.length - 1);
    }

    private ListNode solve(ListNode[] lists, int l, int r) {

        if (l == r) {
            return lists[l];
        }

        int mid = (l + r) >> 1;
        ListNode l1 = solve(lists, l, mid);
        ListNode l2 = solve(lists, mid + 1, r);

        return sort2(l1, l2);
    }

    private ListNode sort2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = sort2(l1.next, l2);
            return l1;
        } else {
            l2.next = sort2(l1, l2.next);
            return l2;
        }
    }

}
