package com.alibaba.leetcode.hard;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples:
 * 
 * "0" => true
 * 
 * " 0.1 " => true
 * 
 * "abc" => false
 * 
 * "1 a" => false
 * 
 * "2e10" => true
 * 
 * " -90e3   " => true
 * 
 * " 1e" => false
 * 
 * "e3" => false
 * 
 * " 6e-1" => true
 * 
 * " 99e2.5 " => false
 * 
 * "53.5e93" => true
 * 
 * " --6 " => false
 * 
 * "-+3" => false
 * 
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one. However, here is a list of characters that can be in a valid decimal number:
 * 
 * Numbers 0-9 Exponent - "e" Positive/negative sign - "+"/"-" Decimal point - "." Of course, the context of these
 * characters also matters in the input.
 * 
 * Update (2015-02-10): The signature of the C++ function had been updated. If you still see your function signature
 * accepts a const char * argument, please click the reload button to reset your code definition.
 * 
 * 
 * @author wang
 * @date 2019/07/18
 */
public class ValidNumberSolution {

    public static void main(String[] args) {

        System.out.println(new ValidNumberSolution().isNumber("95a54e53"));
        System.out.println(new ValidNumberSolution().isNumber(" --6"));
        System.out.println(new ValidNumberSolution().isNumber("53.5e93"));
        System.out.println(new ValidNumberSolution().isNumber(".1"));

        System.out.println(new ValidNumberSolution().isNumber2("95a54e53"));
        System.out.println(new ValidNumberSolution().isNumber2(" --6"));
        System.out.println(new ValidNumberSolution().isNumber2("53.5e93"));
        System.out.println(new ValidNumberSolution().isNumber2(".1"));
    }

    /**
     * 有限状态机
     * 
     * @param s
     * @return
     */
    public boolean isNumber2(String s) {

        int state = 0;
        // 去除头尾的空格
        s = s.trim();
        // 遍历所有字符，当做输入
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                // 输入正负号
                case '+':
                case '-':
                    if (state == 0) {
                        state = 1;
                    } else if (state == 4) {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                // 输入数字
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    // 根据当前状态去跳转
                    switch (state) {
                        case 0:
                        case 1:
                        case 2:
                            state = 2;
                            break;
                        case 3:
                            state = 3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            state = 5;
                            break;
                        case 7:
                            state = 8;
                            break;
                        case 8:
                            state = 8;
                            break;
                        default:
                            return false;
                    }
                    break;
                // 小数点
                case '.':
                    switch (state) {
                        case 0:
                        case 1:
                            state = 7;
                            break;
                        case 2:
                            state = 3;
                            break;
                        default:
                            return false;
                    }
                    break;
                // e
                case 'e':
                    switch (state) {
                        case 2:
                        case 3:
                        case 8:
                            state = 4;
                            break;
                        default:
                            return false;
                    }
                    break;
                default:
                    return false;

            }
        }
        // 橙色部分的状态代表合法数字
        return state == 2 || state == 3 || state == 5 || state == 8;
    }

    /**
     * 解法一：直接匹配法
     * 
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        if (s == null || "".equals((s = s.trim()))) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasE = false;
        boolean hasPoint = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasNumber = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if (c == 'e') {
                if (hasE || !hasNumber) {
                    return false;
                }
                numberAfterE = false;
                hasE = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return hasNumber && numberAfterE;
    }
}
