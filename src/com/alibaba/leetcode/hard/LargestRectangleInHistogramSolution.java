package com.alibaba.leetcode.hard;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 * 
 * Example:
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/22
 */
public class LargestRectangleInHistogramSolution {

    public static void main(String[] args) {

        System.out
            .println(new LargestRectangleInHistogramSolution().largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));

        System.out
            .println(new LargestRectangleInHistogramSolution().largestRectangleArea2(new int[] {2, 1, 5, 6, 2, 3}));

        System.out
            .println(new LargestRectangleInHistogramSolution().largestRectangleArea3(new int[] {2, 1, 5, 6, 2, 3}));
    }

    /**
     * 解法一：暴力穷举法，超时无法ac
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }

        return maxArea;
    }

    /**
     * 解法二：使用栈的方式，当遇到不比比栈顶元素大的高度时出栈，计算出栈的面积；保证栈中的高度时递增的。 最后依次出栈，计算高度对应的面积。
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                Integer index = stack.pop();
                maxArea = Math.max(maxArea, heights[index] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            Integer index = stack.pop();
            maxArea = Math.max(maxArea, heights[index] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }

    /**
     * 解法三：分治法
     * 
     * 先找出最矮的方块，计算其面积，然后在该方块两边分别运用此方法寻找最大面积
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }
        return maxArea(heights, 0, heights.length - 1);
    }

    private int maxArea(int[] heights, int start, int end) {

        if (start > end) {
            return 0;
        }

        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }

        return Math.max(heights[minIndex] * (end - start + 1),
            Math.max(maxArea(heights, minIndex + 1, end), maxArea(heights, start, minIndex - 1)));
    }

}
