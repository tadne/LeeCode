package LeeCode;

import java.util.*;

public class code5_最长回文子串 {
    public static void main(String[] args) {
        //给你一个字符串 s，找到 s 中最长的回文子串。
        //
        //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串
    }
    //中心扩展,就是不断遍历以一个点向外扩展
    //时间复杂度: O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);//获取到当前一个/两个点位为中心扩展得到的长度
            if (len > end - start) {//如果长度大于 end-start ,就是找到新的最长串了,这时就将start和end放到该子串的左右即可
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/longest-palindromic-substring/solutions/255195/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
