package com.alibaba.leetcode.middle.s2;

/**
 * 137. Single Number II
 * 
 * 137. 只出现一次的数字 II
 * 
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,3,2]
 * 
 * Output: 3
 * 
 * Example 2:
 * 
 * Input: [0,1,0,1,0,1,99]
 * 
 * Output: 99
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class SingleNumberIISolution {

    public static void main(String[] args) {

        System.out.println(new SingleNumberIISolution().singleNumber(new int[] {2, 2, 3, 2}));
        System.out.println(new SingleNumberIISolution().singleNumber(new int[] {0, 1, 0, 1, 0, 1, 99}));

        System.out.println(new SingleNumberIISolution().singleNumber2(new int[] {2, 2, 3, 2}));
        System.out.println(new SingleNumberIISolution().singleNumber2(new int[] {0, 1, 0, 1, 0, 1, 99}));
        System.out.println(new SingleNumberIISolution().singleNumber2(new int[] {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2}));
    }

    /**
     * 解法二：采用通用解法
     * 
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {

        return singleNumber(nums, 3);
    }

    /**
     * 通用解法，采用32位的二进制位保存整数的32个二进制位，二进制位出现n次则抵消为0，最后剩下的则是仅出现一次的数
     * 
     * @param nums
     * @param count
     * @return
     */
    public int singleNumber(int[] nums, int n) {

        int[] bit = new int[32];
        for (int num : nums) {
            int i = 1;
            int j = 31;
            while (j >= 0) {
                if ((num & i) != 0) {
                    bit[j]++;
                }
                i = i << 1;
                j--;
            }
        }

        int ans = 0;
        int i = 1;
        int j = 31;
        while (j >= 0) {
            if (bit[j] % n != 0) {
                ans ^= i;
            }
            i = i << 1;
            j--;
        }

        return ans;
    }

    /**
     * one,two,three分别表示出现了一次、两次、三次的数
     * 
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int one = 0;
        int two = 0;
        int three = 0;

        for (int i : nums) {
            two |= one & i;
            one ^= i;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
