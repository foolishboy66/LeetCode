package com.alibaba.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.leetcode.utils.ConvertUtils;

/**
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] Output: [[1,2],[3,10],[12,16]]
 * 
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. NOTE: input types have been changed on
 * April 15, 2019. Please reset to default code definition to get new method signature.
 * 
 * @author wang
 * @date 2019/07/17
 */
public class InsertIntervalSolution {

    public static void main(String[] args) {

        int[][] insert = new InsertIntervalSolution().insert(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5});
        System.out.println(ConvertUtils.intArrayToStr(insert));

        int[][] insert2 = new InsertIntervalSolution().insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
            new int[] {4, 8});
        System.out.println(ConvertUtils.intArrayToStr(insert2));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int start = 0;
        List<int[]> ans = new ArrayList<>();
        while (start < intervals.length && newInterval[0] > intervals[start][1]) {
            ans.add(intervals[start]);
            start++;
        }

        int[] nums = new int[] {newInterval[0], newInterval[1]};
        while (start < intervals.length && newInterval[1] >= intervals[start][0]) {
            // 有重叠
            nums[0] = Math.min(nums[0], intervals[start][0]);
            nums[1] = Math.max(nums[1], intervals[start][1]);
            start++;
        }
        ans.add(nums);

        while (start < intervals.length) {
            ans.add(intervals[start]);
            start++;
        }

        return ans.toArray(new int[ans.size()][1]);
    }

}
