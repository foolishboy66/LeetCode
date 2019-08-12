package com.alibaba.leetcode.easy.s2;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 167.Two Sum II - Input array is sorted
 * 
 * 167. 两数之和 II - 输入有序数组
 * 
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2.
 * 
 * Note:
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * Example:
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * 
 * Output: [1,2]
 * 
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 * 
 * @author wang
 * @date 2019/08/09
 */
public class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {

        System.out
            .println(ConvertUtils.intArrayToStr(new TwoSumInputArrayIsSorted().twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out
            .println(ConvertUtils.intArrayToStr(new TwoSumInputArrayIsSorted().twoSum2(new int[] {2, 7, 11, 15}, 9)));
    }

    /**
     * 双指针
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int diff = numbers[l] + numbers[r] - target;
            if (diff == 0) {
                return new int[] {l + 1, r + 1};
            } else if (diff < 0) {
                l++;
            } else {
                r--;
            }
        }

        return new int[] {-1, -1};
    }

    /**
     * 解法一：使用map保存已遍历元素下标
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer index = map.get(target - numbers[i]);
            if (index != null) {
                return new int[] {index + 1, i + 1};
            }
            map.put(numbers[i], i);
        }

        return new int[] {-1, -1};
    }
}
