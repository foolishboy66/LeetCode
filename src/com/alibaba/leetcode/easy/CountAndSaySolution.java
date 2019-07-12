package com.alibaba.leetcode.easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221
 * 
 * 1 is read off as "one 1" or 11.
 * 
 * 11 is read off as "two 1s" or 21.
 * 
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * @author wang
 * @date 2019/07/11
 */
public class CountAndSaySolution {

    public static void main(String[] args) {

        System.out.println(new CountAndSaySolution().countAndSay(1));
        System.out.println(new CountAndSaySolution().countAndSay(2));
        System.out.println(new CountAndSaySolution().countAndSay(3));
        System.out.println(new CountAndSaySolution().countAndSay(4));
        System.out.println(new CountAndSaySolution().countAndSay(5));
    }

    /**
     * 递归实现
     * 
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String lastSay = countAndSay(n - 1);
        if (lastSay.length() == 1) {
            return "1" + lastSay;
        }
        int count = 1;
        String ans = "";
        for (int i = 1; i < lastSay.length(); i++) {
            if (lastSay.charAt(i) == lastSay.charAt(i - 1)) {
                count++;
            } else {
                ans = ans + count + lastSay.charAt(i - 1);
                count = 1;
            }
        }
        ans = ans + count + lastSay.charAt(lastSay.length() - 1);

        return ans;
    }
}
