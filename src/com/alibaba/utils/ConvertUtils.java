package com.alibaba.utils;

import com.alibaba.leetcode.struct.ListNode;

public class ConvertUtils {

    public static String intArrayToStr(int[] arr) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static String listNodeToStr(ListNode node) {

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        while (node != null) {
            sb.append(node.val);
            node = node.next;
            if (node != null) {
                sb.append(" -> ");
            }
        }

        sb.append(")");
        return sb.toString();
    }

}
