package com.alibaba.leetcode.easy.s2;

/**
 * 172. Factorial Trailing Zeroes
 * 
 * 172. 阶乘后的零
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * 
 * Example 1:
 * 
 * Input: 3
 * 
 * Output: 0
 * 
 * Explanation: 3! = 6, no trailing zero.
 * 
 * Example 2:
 * 
 * Input: 5
 * 
 * Output: 1
 * 
 * Explanation: 5! = 120, one trailing zero.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author wang
 * @date 2019/08/10
 */
public class FactorialTrailingZeroesSolution {

    public static void main(String[] args) {

        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes(3));
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes(5));
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes(30));
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes(1808548329));
        
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes2(3));
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes2(5));
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes2(30));
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes2(1808548329));
    }

    /**
     * 解法一：计算n这个数中有多少个5，超时无法ac
     * 
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {

        int ans = 0;
        int num = 5;
        while (n >= num) {
            int count = 0;
            int tmp = 5;
            while (num >= tmp && num % tmp == 0) {
                count++;
                tmp *= 5;
            }
            ans += count;
            num += 5;
        }

        return ans;
    }

    /**
     * 解法二：换一种方式计算n这个数中有多少个5
     * 
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {

        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }

        return ans;
    }
}
