package com.alibaba.leetcode.middle.s2;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 238. Product of Array Except Self
 * 
 * 238. 除自身以外数组的乘积
 * 
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4]
 * 
 * Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 * 
 * 
 * @author wang
 * @date 2019/08/16
 */
public class ProductOfArrayExceptSelfSolution {

    public static void main(String[] args) {

        System.out.println(ConvertUtils
            .intArrayToStr(new ProductOfArrayExceptSelfSolution().productExceptSelf(new int[] {1, 2, 3, 4})));
    }

    /**
     * 一个数的乘积=这个数左边的数的乘积*这个数右边的数的乘积
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            ans[j] *= k;
            k *= nums[j];
        }
        return ans;
    }
}
