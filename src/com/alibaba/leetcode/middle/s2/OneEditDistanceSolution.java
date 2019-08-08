package com.alibaba.leetcode.middle.s2;

/**
 * 161.One Edit Distance
 * 
 * 161.相隔为 1 的编辑距离
 * 
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 * 
 * 注意：
 * 
 * 满足编辑距离等于 1 有三种可能的情形：
 * 
 * 1.往 s 中插入一个字符得到 t    
 * 
 * 2.从 s 中删除一个字符得到 t    
 * 
 * 3.在 s 中替换一个字符得到 t
 * 
 * 示例 1：
 * 
 * 输入: s = "ab", t = "acb" 输出: true 解释: 可以将 'c' 插入字符串 s 来得到 t。
 * 
 * 示例 2:
 * 
 * 输入: s = "cab", t = "ad" 输出: false 解释: 无法通过 1 步操作使 s 变为 t。
 * 
 * 示例 3:
 * 
 * 输入: s = "1203", t = "1213" 输出: true 解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。
 * 
 * @author wang
 * @date 2019/08/08
 */
public class OneEditDistanceSolution {

    public static void main(String[] args) {

        System.out.println(new OneEditDistanceSolution().isOneEditDistance("ab", "acb"));
        System.out.println(new OneEditDistanceSolution().isOneEditDistance("cab", "ad"));
        System.out.println(new OneEditDistanceSolution().isOneEditDistance("1203", "1213"));
        System.out.println(new OneEditDistanceSolution().isOneEditDistance("1234", "12345"));
        System.out.println(new OneEditDistanceSolution().isOneEditDistance("12345", "1234"));
        System.out.println(new OneEditDistanceSolution().isOneEditDistance("1245", "1234"));
    }

    public boolean isOneEditDistance(String s, String t) {

        int distance = 0;
        int len1 = s.length();
        int len2 = t.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (len1 == len2) {
            int i = 0;
            while (i < len1) {
                if (s.charAt(i) != t.charAt(i)) {
                    distance++;
                }
                i++;
            }
        } else {
            int i = 0;
            int j = 0;
            while (i < len1 || j < len2) {
                if (i < len1 && j < len2) {
                    if (s.charAt(i) != t.charAt(j)) {
                        distance++;
                        if (len1 > len2) {
                            i++;
                        } else {
                            j++;
                        }
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    while (i < len1) {
                        i++;
                        distance++;
                    }
                    while (j < len2) {
                        j++;
                        distance++;
                    }
                }
            }
        }

        return distance == 1;
    }
}
