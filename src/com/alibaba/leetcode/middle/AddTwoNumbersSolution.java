package com.alibaba.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.struct.ListNode;
import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * 输出：7 -> 0 -> 8
 * 
 * 原因：342 + 465 = 807
 * 
 * @author wang
 * @date 2019/06/26
 */
public class AddTwoNumbersSolution {

    /**
     * 解法1:分别遍历两个链表，将数据保存到list中对应位置分别相加保存到数组，数组去掉最高位的0之后保存到list，最后将list转为链表
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        ListNode node1 = l1;
        while (node1 != null) {
            list1.add(node1.val);
            node1 = node1.next;
        }

        List<Integer> list2 = new ArrayList<>();
        ListNode node2 = l2;
        while (node2 != null) {
            list2.add(node2.val);
            node2 = node2.next;
        }

        int maxLength = Math.max(list1.size(), list2.size());
        int[] arr = new int[maxLength + 1];
        for (int k = 0; k < maxLength; k++) {
            int bit1 = 0;
            if (k < list1.size()) {
                bit1 = list1.get(k);
            }
            int bit2 = 0;
            if (k < list2.size()) {
                bit2 = list2.get(k);
            }
            int res = bit1 + bit2 + arr[k];
            if (res > 9) {
                res -= 10;
                arr[k + 1] = 1;
            }

            arr[k] = res;
        }

        List<Integer> list = new ArrayList<>();
        boolean headerZero = true;
        for (int k = arr.length - 1; k >= 0; k--) {
            if (arr[k] != 0 || !headerZero) {
                headerZero = false;
                list.add(arr[k]);
            }
        }
        if (list.isEmpty()) {
            list.add(0);
        }

        ListNode head = new ListNode(list.get(list.size() - 1));
        ListNode node = head;
        if (list.size() >= 2) {
            for (int k = list.size() - 2; k >= 0; k--) {
                node.next = new ListNode(list.get(k));
                node = node.next;
            }
        }

        return head;
    }

    /**
     * 解法2:同时遍历两个链表，将对应位置数据相加保存到list，再将list转为链表
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode n1 = l1;
        ListNode n2 = l2;
        boolean up = false;
        List<Integer> list = new ArrayList<>();
        while (n1 != null || n2 != null) {
            int v1 = 0;
            int v2 = 0;
            int v3 = up ? 1 : 0;
            if (n1 != null) {
                v1 = n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                v2 = n2.val;
                n2 = n2.next;
            }

            int sum = v1 + v2 + v3;
            if (sum > 9) {
                up = true;
            } else {
                up = false;
            }
            list.add(sum % 10);
        }
        if (up) {
            list.add(1);
        }

        ListNode head = new ListNode(list.get(0));
        ListNode node = head;
        for (int k = 1; k < list.size(); k++) {
            node.next = new ListNode(list.get(k));
            node = node.next;
        }

        return head;
    }

    /**
     * 解法3:同时遍历两个链表，将对应位置数据相加直接构造出链表节点
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

        ListNode n1 = l1;
        ListNode n2 = l2;
        boolean up = false;
        int i = 0;
        ListNode head = null;
        ListNode node = null;
        while (n1 != null || n2 != null) {
            int v1 = 0;
            int v2 = 0;
            int v3 = up ? 1 : 0;
            if (n1 != null) {
                v1 = n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                v2 = n2.val;
                n2 = n2.next;
            }

            int sum = v1 + v2 + v3;
            if (sum > 9) {
                sum -= 10;
                up = true;
            } else {
                up = false;
            }
            if (i == 0) {
                head = new ListNode(sum);
                node = head;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }
            i++;
        }
        if (up) {
            node.next = new ListNode(1);
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        // l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        System.out.println(ConvertUtils.listNodeToStr(new AddTwoNumbersSolution().addTwoNumbers(l1, l2)));
        System.out.println(ConvertUtils.listNodeToStr(new AddTwoNumbersSolution().addTwoNumbers2(l1, l2)));
        System.out.println(ConvertUtils.listNodeToStr(new AddTwoNumbersSolution().addTwoNumbers3(l1, l2)));

    }

}