package com.alibaba.leetcode;

/**
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical
 * digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are ignored and have no
 * effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * Only the space character ' ' is considered as whitespace character. Assume we are dealing with an environment which
 * could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of
 * the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned. Example 1:
 * 
 * Input: "42" Output: 42 Example 2:
 * 
 * Input: " -42" Output: -42 Explanation: The first non-whitespace character is '-', which is the minus sign.   Then
 * take as many numerical digits as possible, which gets 42. Example 3:
 * 
 * Input: "4193 with words" Output: 4193 Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit. Example 4:
 * 
 * Input: "words and 987" Output: 0 Explanation: The first non-whitespace character is 'w', which is not a numerical  
 * digit or a +/- sign. Therefore no valid conversion could be performed. Example 5:
 * 
 * Input: "-91283472332" Output: -2147483648 Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.   Thefore INT_MIN (−231) is returned.
 * 
 * @author wang
 * @date 2019/06/29
 */
public class StringToIntegerSolution {

    public static void main(String[] args) {

        System.out.println(new StringToIntegerSolution().myAtoi("42"));
        System.out.println(new StringToIntegerSolution().myAtoi("   -42"));
        System.out.println(new StringToIntegerSolution().myAtoi("   4193 with words"));
        System.out.println(new StringToIntegerSolution().myAtoi("words and 987"));
        System.out.println(new StringToIntegerSolution().myAtoi("-91283472332"));
        System.out.println(new StringToIntegerSolution().myAtoi("2147483648"));
        System.out.println(new StringToIntegerSolution().myAtoi("  0000000000012345678"));
        System.out.println(new StringToIntegerSolution().myAtoi("-000000000000001"));
    }

    public int myAtoi(String str) {

        if (str == null || (str = str.trim()).length() == 0) {
            return 0;
        }

        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isDigit(c) || (sb.length() == 0 && ('-' == c || '+' == c))) {
                sb.append(c);
            } else {
                break;
            }
        }
        String s = sb.toString();
        if (s == null || "".equals(s.trim()) || "+".equals(s) || "-".equals(s)) {
            return 0;
        }

        String maxIntStr = Integer.MAX_VALUE + "";
        String minIntStr = (Integer.MIN_VALUE + "").substring(1);
        String prefix = "";
        String tmp;
        if (s.startsWith("+")) {
            prefix = "+";
            tmp = s.substring(1);
            tmp = trimInvalidZero(tmp);
            if (tmp.length() > maxIntStr.length()
                || (tmp.length() == maxIntStr.length() && tmp.compareTo(maxIntStr) > 0)) {
                return Integer.MAX_VALUE;
            }
        } else if (s.startsWith("-")) {
            prefix = "-";
            tmp = s.substring(1);
            tmp = trimInvalidZero(tmp);
            if (tmp.length() > minIntStr.length()
                || (tmp.length() == minIntStr.length() && tmp.compareTo(minIntStr) > 0)) {
                return Integer.MIN_VALUE;
            }
        } else {
            tmp = trimInvalidZero(s);
            if (tmp.length() > maxIntStr.length()
                || (tmp.length() == maxIntStr.length() && tmp.compareTo(maxIntStr) > 0)) {
                return Integer.MAX_VALUE;
            }
        }
        s = prefix + tmp;

        return Integer.parseInt(s);
    }

    private String trimInvalidZero(String tmp) {

        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '0' && start) {
                continue;
            }
            start = false;
            sb.append(tmp.charAt(i));
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}
