package com.alibaba.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321 Example 2:
 * 
 * Input: -123 Output: -321 Example 3:
 * 
 * Input: 120 Output: 21 Note: Assume we are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 * 
 * 
 * @author wang
 * @date 2019/06/28
 */
public class ReverseIntegerSolution {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverseStr("123"));
        System.out.println(new ReverseIntegerSolution().reverse(120));
        System.out.println(new ReverseIntegerSolution().reverse(-120));
        System.out.println(new ReverseIntegerSolution().reverse(Integer.MAX_VALUE));
        System.out.println(new ReverseIntegerSolution().reverse(Integer.MIN_VALUE));
        System.out.println(new ReverseIntegerSolution().reverse2(120));
        System.out.println(new ReverseIntegerSolution().reverse2(-120));
        System.out.println(new ReverseIntegerSolution().reverse2(Integer.MAX_VALUE));
        System.out.println(new ReverseIntegerSolution().reverse2(Integer.MIN_VALUE));
    }

    /**
     * 解法一：将整数转为字符串然后反转
     * 
     * @param x
     * @return
     */
    public int reverse(int x) {

        String maxIntStr = Integer.MAX_VALUE + "";
        String minIntStr = (Integer.MIN_VALUE + "").substring(1);

        String s = x + "";
        if (x < 0) {
            s = s.substring(1);
        }
        s = reverseStr(s);
        if ((x < 0 && s.length() == minIntStr.length() && s.compareTo(minIntStr) > 0)
            || (x > 0 && s.length() == maxIntStr.length() && s.compareTo(maxIntStr) > 0)) {
            return 0;
        }
        if (x < 0) {
            s = "-" + s;
        }
        return Integer.parseInt(s);
    }

    /**
     * 解法二：直接取出整数的每一位，翻转的同时判断是否会溢出
     * 
     * @param x
     * @return
     */
    public int reverse2(int x) {

        int pop = 0;
        int res = 0;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)
                || res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            res = res * 10 + pop;
        }

        return res;
    }

    private static String reverseStr(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] cs = s.toCharArray();
        int i = 0;
        char temp;
        while (i < cs.length / 2) {
            temp = cs[i];
            cs[i] = cs[s.length() - i - 1];
            cs[s.length() - i - 1] = temp;
            i++;
        }
        return new String(cs, 0, cs.length);
    }

}
