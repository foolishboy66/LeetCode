package com.alibaba.leetcode.middle;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10 Output: 1024.00000
 * 
 * Example 2:
 * 
 * Input: 2.10000, 3 Output: 9.26100
 * 
 * Example 3:
 * 
 * Input: 2.00000, -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * Note:
 * 
 * -100.0 < x < 100.0 n is a 32-bit signed integer, within the range [−231, 231 − 1]
 * 
 * 
 * @author wang
 * @date 2019/07/15
 */
public class PowerNSolution {

    public static void main(String[] args) {

        System.out.println(new PowerNSolution().myPow2(2, 10));
        System.out.println(new PowerNSolution().myPow2(2.1, 3));
        System.out.println(new PowerNSolution().myPow2(2.0, -2));

        System.out.println(new PowerNSolution().myPow(2, 10));
        System.out.println(new PowerNSolution().myPow(2.1, 3));
        System.out.println(new PowerNSolution().myPow(2.0, -2));

        System.out.println(new PowerNSolution().myPow(2.0, Integer.MIN_VALUE));
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        long num = n;
        if (num < 0) {
            num = -num;
            x = 1 / x;
        }

        double temp = x;
        double ans = 1;
        while (num > 0) {
            if (num % 2 == 1) {
                ans *= temp;
            }
            temp = temp * temp;
            num = num >> 1;
        }

        return ans;
    }

    /**
     * 解法一：暴力法会超时
     * 
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double ans = 1;
        if (n < 0) {
            double d = positivePow(x, -n);
            ans = 1 / d;
        } else {
            while (n > 0) {
                ans = ans * x;
                n--;
            }
        }

        return ans;
    }

    public double positivePow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double ans = 1;
        while (n > 0) {
            ans = ans * x;
            n--;
        }

        return ans;
    }
}
