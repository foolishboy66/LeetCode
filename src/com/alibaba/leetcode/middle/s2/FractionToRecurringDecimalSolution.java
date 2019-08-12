package com.alibaba.leetcode.middle.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * 166.Fraction to Recurring Decimal
 * 
 * 166. 分数到小数
 * 
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * Example 1:
 * 
 * Input: numerator = 1, denominator = 2
 * 
 * Output: "0.5"
 * 
 * Example 2:
 * 
 * Input: numerator = 2, denominator = 1
 * 
 * Output: "2"
 * 
 * Example 3:
 * 
 * Input: numerator = 2, denominator = 3
 * 
 * Output: "0.(6)"
 * 
 * 
 * @author wang
 * @date 2019/08/09
 */
public class FractionToRecurringDecimalSolution {

    public static void main(String[] args) {

        System.out.println(new FractionToRecurringDecimalSolution().fractionToDecimal(1, 2));
        System.out.println(new FractionToRecurringDecimalSolution().fractionToDecimal(2, 1));
        System.out.println(new FractionToRecurringDecimalSolution().fractionToDecimal(2, 3));
        System.out.println(new FractionToRecurringDecimalSolution().fractionToDecimal(50, -8));
        System.out.println(new FractionToRecurringDecimalSolution().fractionToDecimal(-50, 8));
        System.out.println(new FractionToRecurringDecimalSolution().fractionToDecimal(1, -2147483648));
    }

    /**
     * 记录余数的位置，当余数出现循环时，则商也会出现循环
     * 
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 ^ denominator > 0)) {
            sb.append("-");
        }
        long n = (long)Math.abs((long)numerator);
        long d = (long)Math.abs((long)denominator);

        sb.append(n / d);
        long mod = n % d;
        if (mod == 0) {
            return sb.toString();
        }
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (mod != 0) {
            if (map.containsKey(mod)) {
                sb.insert(map.get(mod), "(");
                sb.append(")");
                break;
            }
            map.put(mod, sb.length());
            mod *= 10;
            sb.append(mod / d);
            mod = mod % d;
        }

        return sb.toString();
    }
}
