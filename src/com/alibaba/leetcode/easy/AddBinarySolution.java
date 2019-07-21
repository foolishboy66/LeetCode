package com.alibaba.leetcode.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1" Output: "100"
 * 
 * Example 2:
 * 
 * Input: a = "1010", b = "1011" Output: "10101"
 * 
 * 
 * @author wang
 * @date 2019/07/19
 */
public class AddBinarySolution {

    public static void main(String[] args) {

        System.out.println(new AddBinarySolution().addBinary("1010", "1011111"));
    }

    /**
     * 先将低位数补0，再每一位相加，注意进位
     * 
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB);
        if (lenA > lenB) {
            b = getNZeros(lenA - lenB) + b;
        } else if (lenA < lenB) {
            a = getNZeros(lenB - lenA) + a;
        }

        boolean carry = false;
        String res = "";
        for (int i = len - 1; i >= 0; i--) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            int c = charA + charB - 2 * '0';
            if (carry) {
                c++;
                carry = false;
            }
            if (c > 1) {
                res = c - 2 + res;
                carry = true;
            } else {
                res = c + res;
            }
        }
        if (carry) {
            return "1" + res;
        }
        return res;
    }

    private String getNZeros(int len) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
