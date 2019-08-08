package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * 163.Missing Ranges
 * 
 * 163. 缺失的区间
 * 
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * 
 * 示例：
 * 
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * 
 * @author wang
 * @date 2019/08/08
 */
public class MissingRangesSolution {

    public static void main(String[] args) {

        System.out.println(new MissingRangesSolution().findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new MissingRangesSolution().findMissingRanges(new int[] {0, 1, 3, 50, 75}, -1, 99));

        System.out.println(new MissingRangesSolution().findMissingRanges(new int[] {}, 0, 99));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ans = new ArrayList<>();

        if (lower >= upper - 1) {
            return ans;
        }

        if (nums.length == 0) {
            ans.add(getRange(lower - 1, upper + 1));
            return ans;
        }

        int i = 0;
        while (i < nums.length && nums[i] <= lower) {
            i++;
        }

        while (i < nums.length && nums[i] < upper) {
            if (i == 0) {
                String s = getRange(lower - 1, nums[i]);
                if (s != null) {
                    ans.add(s);
                }
            } else {
                if (nums[i] - nums[i - 1] > 1) {
                    String s = getRange(nums[i - 1], nums[i]);
                    if (s != null) {
                        ans.add(s);
                    }
                }
            }
            i++;
        }

        if (i > 0 && nums[i - 1] < upper) {
            ans.add(getRange(nums[i - 1], upper + 1));
        }

        return ans;
    }

    private String getRange(int lower, int upper) {
        if (upper - lower <= 1) {
            return null;
        }
        if (upper - lower == 2) {
            return lower + 1 + "";
        }
        return (lower + 1) + "->" + (upper - 1);
    }

}
