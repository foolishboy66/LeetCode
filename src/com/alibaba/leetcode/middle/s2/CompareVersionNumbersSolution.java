package com.alibaba.leetcode.middle.s2;

/**
 * 165. Compare Version Numbers
 * 
 * 165. 比较版本号
 * 
 * Compare two version numbers version1 and version2. If version1 > version2 return 1; if version1 < version2 return
 * -1;otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * 
 * The . character does not represent a decimal point and is used to separate number sequences.
 * 
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of
 * the second first-level revision.
 * 
 * You may assume the default revision number for each level of a version number to be 0. For example, version number
 * 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level
 * revision number are both 0.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1"
 * 
 * Output: -1
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1"
 * 
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * 
 * Output: -1
 * 
 * Example 4:
 * 
 * Input: version1 = "1.01", version2 = "1.001"
 * 
 * Output: 0
 * 
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * 
 * Example 5:
 * 
 * Input: version1 = "1.0", version2 = "1.0.0"
 * 
 * Output: 0
 * 
 * Explanation: The first version number does not have a third level revision number, which means its third level
 * revision number is default to "0"  
 * 
 * Note:
 * 
 * Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
 * 
 * Version strings do not start or end with dots, and they will not be two consecutive dots.
 * 
 * 
 * @author wang
 * @date 2019/08/08
 */
public class CompareVersionNumbersSolution {

    public static void main(String[] args) {

        System.out.println(new CompareVersionNumbersSolution().compareVersion("1.0", "1.0.0"));
        System.out.println(new CompareVersionNumbersSolution().compareVersion("7.5.2.4", "7.5.3"));
    }

    public int compareVersion(String version1, String version2) {

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int len = Math.min(len1, len2);

        for (int i = 0; i < len; i++) {
            int v1 = Integer.parseInt(s1[i]);
            int v2 = Integer.parseInt(s2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        if (len1 > len2) {
            for (int i = len; i < len1; i++) {
                int v = Integer.parseInt(s1[i]);
                if (v > 0) {
                    return 1;
                }
            }
        } else if (len1 < len2) {
            for (int i = len; i < len2; i++) {
                int v = Integer.parseInt(s2[i]);
                if (v > 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}
