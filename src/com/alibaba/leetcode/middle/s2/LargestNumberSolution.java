package com.alibaba.leetcode.middle.s2;

import java.util.Arrays;

/**
 * 179. Largest Number
 * 
 * 179. 最大数
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * Example 1:
 * 
 * Input: [10,2]
 * 
 * Output: "210"
 * 
 * Example 2:
 * 
 * Input: [3,30,34,5,9]
 * 
 * Output: "9534330"
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * 
 * @author wang
 * @date 2019/08/11
 */
public class LargestNumberSolution {

    public static void main(String[] args) {

        System.out.println(new LargestNumberSolution().largestNumber(new int[] {10, 2}));
        System.out.println(new LargestNumberSolution().largestNumber(new int[] {3, 30, 34, 5, 9}));
        System.out.println(new LargestNumberSolution().largestNumber(new int[] {0, 0}));
    }

    /**
     * 按照两个数字的字符串组合在字符串中的大小顺序排序后连接即可
     * 
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }
        Arrays.sort(arr, (a, b) -> -(a + b).compareTo((b + a)));

        StringBuilder sb = new StringBuilder();
        if (arr[0].equals("0")) {
            return "0";
        }

        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
