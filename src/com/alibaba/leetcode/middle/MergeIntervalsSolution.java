package com.alibaba.leetcode.middle;

import java.util.Arrays;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6]
 * overlaps, merge them into [1,6]. Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered overlapping. NOTE: input
 * types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * 
 * 
 * @author wang
 * @date 2019/07/17
 */
public class MergeIntervalsSolution {

    public static void main(String[] args) {

        int[][] merge = new MergeIntervalsSolution().merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.toString(merge));
    }

    /**
     * 先按照开始数字排序，判断是否有重叠
     * 
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[count][1]) {
                // 有重叠
                intervals[count][1] = Math.max(intervals[count][1], intervals[i][1]);
            } else {
                count++;
                intervals[count][0] = intervals[i][0];
                intervals[count][1] = intervals[i][1];
            }
        }
        int[][] ans = new int[count + 1][2];
        for (int i = 0; i <= count; i++) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }

        return ans;
    }
}
