package com.alibaba.leetcode.easy.s2;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 237. Delete Node in a Linked List
 * 
 * 237. 删除链表中的节点
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * 
 * Given linked list -- head = [4,5,1,9], which looks like following
 * 
 * 
 * Example 1:
 * 
 * Input: head = [4,5,1,9], node = 5
 * 
 * Output: [4,1,9]
 * 
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your
 * function.
 * 
 * Example 2:
 * 
 * Input: head = [4,5,1,9], node = 1
 * 
 * Output: [4,5,9]
 * 
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your
 * function.  
 * 
 * Note:
 * 
 * The linked list will have at least two elements.
 * 
 * All of the nodes' values will be unique.
 * 
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * 
 * Do not return anything from your function.
 * 
 * 
 * @author wang
 * @date 2019/08/16
 */
public class DeleteNodeInLinkedListSolution {

    public static void main(String[] args) {

        ListNode head = ConvertUtils.buildListNode(4, 5, 1, 9);
        ListNode node = head.next.next;
        new DeleteNodeInLinkedListSolution().deleteNode(node);
        System.out.println(ConvertUtils.listNodeToStr(head));
    }

    /**
     * 链表元素的值左移一位即可
     * 
     * @param node
     */
    public void deleteNode(ListNode node) {

        ListNode n = node;
        ListNode last = null;
        while (n.next != null) {
            if (n.next.next == null) {
                last = n;
            }
            n.val = n.next.val;
            n = n.next;
        }
        last.next = null;
    }
}
