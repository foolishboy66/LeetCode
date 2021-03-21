package com.alibaba.leetcode.easy.s2;

/**
 * 231. Power of Two
 * 
 * 231. 2的幂
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * Input: 1
 * 
 * Output: true
 * 
 * Explanation: 20 = 1
 * 
 * Example 2:
 * 
 * Input: 16
 * 
 * Output: true
 * 
 * Explanation: 24 = 16
 * 
 * Example 3:
 * 
 * Input: 218
 * 
 * Output: false
 * 
 * 
 * @author wang
 * @date 2019/08/15
 */
public class PowerOfTwoSolution {

    public static void main(String[] args) {

        System.out.println(new PowerOfTwoSolution().isPowerOfTwo(16));
        System.out.println(new PowerOfTwoSolution().isPowerOfTwo2(16));
    }

    /**
     * 解法二：二进制法
     * 
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {

        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }

        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }

        return n == 0;
    }
}
