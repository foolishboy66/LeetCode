package com.alibaba.leetcode.easy;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is
 * returned.
 * 
 * Example 1:
 * 
 * Input: 4 Output: 2
 * 
 * Example 2:
 * 
 * Input: 8 Output: 2
 * 
 * Explanation: The square root of 8 is 2.82842..., and since   the decimal part is truncated, 2 is returned.
 * 
 * 
 * @author wang
 * @date 2019/07/19
 */
public class SqrtSolution {

    public static void main(String[] args) {

        System.out.println(new SqrtSolution().mySqrt(15));
    }

    /**
     * 二分法
     * 
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }
        int l = 1;
        int r = x >> 1;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            long sum = mid * mid;
            if (sum == x) {
                return (int)mid;
            } else if (sum > x) {
                r = (int)(mid - 1);
            } else {
                l = (int)mid;
            }
        }

        return l;
    }
}
