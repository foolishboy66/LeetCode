package com.alibaba.leetcode.middle;

/**
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
 * represented as a string.
 * 
 * Example 1:
 * 
 * Input: num1 = "2", num2 = "3" Output: "6"
 * 
 * Example 2:
 * 
 * Input: num1 = "123", num2 = "456" Output: "56088" Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contain only digits 0-9. Both num1 and num2 do not
 * contain any leading zero, except the number 0 itself. You must not use any built-in BigInteger library or convert the
 * inputs to integer directly.
 * 
 * 
 * @author wang
 * @date 2019/07/14
 */
public class MultiplyStringsSolution {

    public static void main(String[] args) {

        System.out.println(new MultiplyStringsSolution().multiply("2", "3"));
        System.out.println(new MultiplyStringsSolution().multiply("123", "456"));
        System.out.println(new MultiplyStringsSolution().multiply("9", "9"));
    }

    /**
     * 竖式乘法，每一位相乘的结果存储到数组中
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length() - 1];
        int up = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int temp = res[i + j] + n1 * n2;
                res[i + j] = temp % 10;
                if (i + j > 0) {
                    res[i + j - 1] += temp / 10;
                } else {
                    up = temp / 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (up != 0) {
            sb.append(up);
        }
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
