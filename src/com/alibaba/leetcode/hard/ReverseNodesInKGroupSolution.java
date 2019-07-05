package com.alibaba.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the list's nodes, only nodes itself maybe
 * changed.
 * 
 * 
 * @author wang
 * @date 2019/07/05
 */
public class ReverseNodesInKGroupSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.listNodeToStr(
            new ReverseNodesInKGroupSolution().reverseKGroup(ConvertUtils.buildListNode(1, 2, 3, 4, 5), 2)));
        System.out.println(ConvertUtils.listNodeToStr(
            new ReverseNodesInKGroupSolution().reverseKGroup(ConvertUtils.buildListNode(1, 2, 3, 4, 5), 3)));
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode node = head;
        ListNode preNode = null;
        int i = 0;
        ListNode ans = null;
        while (node != null) {
            List<ListNode> list = swapKNodes(preNode, node, k);
            preNode = list.get(1);
            node = preNode.next;
            if (i == 0) {
                ans = list.get(0);
            }
            i++;
        }

        return ans;
    }

    private List<ListNode> swapKNodes(ListNode preNode, ListNode node, int k) {

        ListNode n = node;
        List<ListNode> list = new ArrayList<>();
        int i = 0;
        while (n != null && i < k) {
            list.add(n);
            i++;
            n = n.next;
        }
        if (list.size() < k) {
            return Arrays.asList(node, list.get(list.size() - 1));
        }
        if (preNode != null) {
            preNode.next = list.get(k - 1);
        }
        ListNode next = list.get(k - 1).next;
        for (int j = list.size() - 1; j > 0; j--) {
            list.get(j).next = list.get(j - 1);
        }
        list.get(0).next = next;

        return Arrays.asList(list.get(k - 1), list.get(0));
    }

}
