package com.alibaba.leetcode.middle;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * @author wang
 * @date 2019/06/27
 */
public class LongestPalindromeSolution {

    /**
     * 方法一：滑动窗口，超时了
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        String ans;
        for (int len = s.length(); len > 0; len--) {
            for (int i = 0, j = len + i - 1; i < s.length() && j < s.length(); i++, j++) {
                if (isPalindrome(ans = s.substring(i, j + 1))) {
                    return ans;
                }
            }
        }

        return s.substring(0, 1);
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int i = 0;
        while (i <= s.length() / 2) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * 方法二：中心对称法
     * 
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        int i = 0;
        while (i < s.length()) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

            i++;
        }

        return s.substring(start, end + 1);
    }

    private int expandCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {

        System.out.println(new LongestPalindromeSolution().isPalindrome("abcsscba"));
        System.out.println(new LongestPalindromeSolution().isPalindrome("bab"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome("abcsscba"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome("babad"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome(
            "\"gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv\""));
        System.out.println(new LongestPalindromeSolution().longestPalindrome2("abcsscba"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome2("babad"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome2("cbbd"));
        System.out.println(new LongestPalindromeSolution().longestPalindrome2(
            "\"gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv\""));
    }
}
