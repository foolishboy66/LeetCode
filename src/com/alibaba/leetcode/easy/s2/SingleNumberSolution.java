package com.alibaba.leetcode.easy.s2;

/**
 * 136. Single Number
 * 
 * 136. 只出现一次的数字
 * 
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1]
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2]
 * 
 * Output: 4
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class SingleNumberSolution {

    public static void main(String[] args) {

        System.out.println(new SingleNumberSolution().singleNumber(new int[] {2, 2, 1}));
        System.out.println(new SingleNumberSolution().singleNumber(new int[] {4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
