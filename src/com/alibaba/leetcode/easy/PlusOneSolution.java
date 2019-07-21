package com.alibaba.leetcode.easy;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array
 * contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2,4]
 * 
 * Explanation: The array represents the integer 123.
 * 
 * Example 2:
 * 
 * Input: [4,3,2,1] Output: [4,3,2,2]
 * 
 * Explanation: The array represents the integer 4321.
 * 
 * 
 * @author wang
 * @date 2019/07/19
 */
public class PlusOneSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils.intArrayToStr(new PlusOneSolution().plusOne(new int[] {4, 3, 2, 1})));
        System.out.println(ConvertUtils.intArrayToStr(new PlusOneSolution().plusOne(new int[] {9, 9, 9, 9, 9})));
    }

    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return digits;
        }

        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        boolean forward = digits[digits.length - 1] > 9;
        for (int i = digits.length - 1; i >= 0 && forward; i--) {
            if (digits[i] > 9) {
                digits[i] = digits[i] % 10;
                if (i > 0) {
                    digits[i - 1] = digits[i - 1] + 1;
                }
            } else {
                forward = false;
            }
        }
        if (forward) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        }

        return digits;
    }
}
