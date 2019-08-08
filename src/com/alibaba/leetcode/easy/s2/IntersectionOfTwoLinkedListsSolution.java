package com.alibaba.leetcode.easy.s2;

import java.util.Set;

import java.util.HashSet;

import com.alibaba.leetcode.struct.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * begin to intersect at node c1.
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 
 * Output: Reference of the node with value = 8
 * 
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From
 * the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the
 * intersected node in A; There are 3 nodes before the intersected node in B.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * 
 * The linked lists must retain their original structure after the function returns.
 * 
 * You may assume there are no cycles anywhere in the entire linked structure.
 * 
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 * @author wang
 * @date 2019/08/07
 */
public class IntersectionOfTwoLinkedListsSolution {

    public static void main(String[] args) {

    }

    /**
     * 解法二：双指针法
     * 
     * 创建两个指针a和 b，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 
     * 当 a到达链表的尾部时，将它重定位到链表 B 的头结点 ; 类似的，当b到达链表的尾部时，将它重定位到链表 A的头结点。
     * 
     * 若在某一时刻a和 b相遇，则a和b为相交结点。
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    /**
     * 解法一：将其中一个链表的节点存在hashSet中，遍历另外一个链表检查元素是否存在与hashSet中
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode n1 = headA;
        Set<ListNode> nodes = new HashSet<>();
        while (n1 != null) {
            nodes.add(n1);
            n1 = n1.next;
        }

        n1 = headB;
        while (n1 != null) {
            if (nodes.contains(n1)) {
                return n1;
            }
            n1 = n1.next;
        }

        return null;
    }
}
