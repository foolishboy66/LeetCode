package com.alibaba.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样下标的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * @author wang
 * @date 2019/06/26
 */
public class TwoSumSolution {

    /**
     * 方法一:暴力穷举法
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[] {-1, -1};

        if (nums == null || nums.length < 2) {
            return res;
        }
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    /**
     * 方法二:使用hashmap缓存
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] res = new int[] {-1, -1};

        if (nums == null || nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {

            int left = target - nums[i];

            Integer index;
            if ((index = map.get(left)) != null && index != i) {
                return new int[] {i, map.get(left)};
            }
        }

        return res;
    }

    /**
     * 方法三:最快的解法，使用数组下表保存遍历过的值，数组的对应的值保存值对应的下标
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {

        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[] {indexArrays[index] - 1, i};
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {3, 4};
        int target = 6;

        System.out.println(ConvertUtils.intArrayToStr(new TwoSumSolution().twoSum(nums, target)));
        System.out.println(ConvertUtils.intArrayToStr(new TwoSumSolution().twoSum2(nums, target)));
        System.out.println(ConvertUtils.intArrayToStr(new TwoSumSolution().twoSum3(nums, target)));
    }
}
