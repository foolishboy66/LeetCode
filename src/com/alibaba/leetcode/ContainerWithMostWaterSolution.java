package com.alibaba.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue
 * section) the container can contain is 49.
 * 
 *  
 * 
 * Example:
 * 
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 * 
 * 
 * @author wang
 * @date 2019/06/30
 */
public class ContainerWithMostWaterSolution {

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWaterSolution().maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new ContainerWithMostWaterSolution().maxArea2(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 解法一：暴力穷举法
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return max;
    }

    /**
     * 解法二：双指针法
     * 
     * 两个指针，一个指向头，一个指向尾，谁小移动谁
     * 
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            max = Math.max(max, Math.min(height[low], height[high]) * (high - low));

            if (height[low] < height[high]) {
                low++;
            } else if (height[low] > height[high]) {
                high--;
            } else {
                // 相等的时候需要再往后看一位，移动后一位大的那个
                if (low < high && height[low + 1] > height[high - 1]) {
                    low++;
                } else {
                    high--;
                }
            }

        }

        return max;
    }
}
