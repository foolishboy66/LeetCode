package com.alibaba.leetcode.middle.s2;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.leetcode.struct.ListNode;

/**
 * 142. Linked List Cycle II
 * 
 * 142. 环形链表 II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the
 * linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Note: Do not modify the linked list.
 * 
 *   Example 1:
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * 
 * Output: tail connects to node index 1
 * 
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * 
 * Example 2:
 * 
 * Input: head = [1,2], pos = 0
 * 
 * Output: tail connects to node index 0
 * 
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * 
 * Example 3:
 * 
 * Input: head = [1], pos = -1
 * 
 * Output: no cycle
 * 
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * Follow-up: Can you solve it without using extra space?
 * 
 * 
 * @author wang
 * @date 2019/08/04
 */
public class LinkedListCycleIISolution {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode n = new ListNode(2);
        n.next = head;
        head.next = n;
        System.out.println(new LinkedListCycleIISolution().detectCycle(head));

        System.out.println(new LinkedListCycleIISolution().detectCycle2(head));
    }

    /**
     * 先找到快慢指针的相遇节点，相遇节点与头结点每次都走一步，相遇的节点则为环的起始节点
     * 
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode n = head;
        while (n != slow) {
            n = n.next;
            slow = slow.next;
        }
        return n;
    }

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode n = head;
        while (n != null) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
            n = n.next;
        }

        return null;
    }
}
