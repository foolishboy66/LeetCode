package com.alibaba.leetcode.middle;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3 Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2 Note:
 * 
 * Both dividend and divisor will be 32-bit signed integers. The divisor will never be 0. Assume we are dealing with an
 * environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose
 * of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * 
 * 
 * @author wang
 * @date 2019/07/07
 */
public class DivideTwoIntegersSolution {

    public static void main(String[] args) {

        System.out.println(new DivideTwoIntegersSolution().divide(10, 3));
        System.out.println(new DivideTwoIntegersSolution().divide(7, -3));
        System.out.println(new DivideTwoIntegersSolution().divide(-2147483648, 1));

        System.out.println(new DivideTwoIntegersSolution().divide2(10, 3));
        System.out.println(new DivideTwoIntegersSolution().divide2(7, -3));
        System.out.println(new DivideTwoIntegersSolution().divide2(-2147483648, 1));

        System.out.println(new DivideTwoIntegersSolution().divide2(1100540749, 1090366779));
    }

    /**
     * 解法一：一个一个累加，会出现超时的问题
     * 
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean greaterThanZero = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int i = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            i++;
        }

        return greaterThanZero ? i : (-i);
    }

    /**
     * 解法二：除数每次成倍地增加，加快减法的执行
     * 
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean greaterThanZero = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int i = 0;
        while (dividend <= divisor) {
            int p = divisor;
            int n = 1;
            while (p >= (Integer.MIN_VALUE >> 1) && dividend <= (p << 1)) {
                p = p << 1;
                n = n << 1;
                dividend -= p;
                i += n;
            }
            if (dividend <= divisor) {
                dividend -= divisor;
                i++;
            }
        }

        return greaterThanZero ? i : (-i);
    }

}
