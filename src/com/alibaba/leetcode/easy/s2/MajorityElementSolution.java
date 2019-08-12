package com.alibaba.leetcode.easy.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * 
 * 169. 求众数
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2
 * ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Example 1:
 * 
 * Input: [3,2,3]
 * 
 * Output: 3
 * 
 * Example 2:
 * 
 * Input: [2,2,1,1,1,2,2]
 * 
 * Output: 2
 * 
 * @author wang
 * @date 2019/08/09
 */
public class MajorityElementSolution {

    public static void main(String[] args) {

        System.out.println(new MajorityElementSolution().majorityElement(new int[] {3}));
        System.out.println(new MajorityElementSolution().majorityElement(new int[] {3, 2, 3}));
        System.out.println(new MajorityElementSolution().majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));

        System.out.println(new MajorityElementSolution().majorityElement2(new int[] {3}));
        System.out.println(new MajorityElementSolution().majorityElement2(new int[] {3, 2, 3}));
        System.out.println(new MajorityElementSolution().majorityElement2(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 解法二：计数器法，遇到相同的count+1，遇到不同的count-1，count=0的时候换一个
     * 
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {

        int num = nums[0];
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                num = i;
            }
            if (num == i) {
                count++;
            } else {
                count--;
            }
        }

        return num;
    }

    /**
     * 解法一：哈希表
     * 
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            Integer time = count.getOrDefault(nums[i], 0) + 1;
            if (time > len / 2) {
                return nums[i];
            }
            count.put(nums[i], time);
        }

        return nums[0];
    }
}
