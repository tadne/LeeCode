package NewLeeCode;

public class code1 {
    public static void main(String[] args) {
        //给你一个字符串 s，找到 s 中最长的回文子串。
        //
        //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
        String s="abccc";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//一个点的回文长度
            int len2 = expandAroundCenter(s, i, i + 1);//两个点的回文长度
            int len = Math.max(len1, len2);//取大
            if (len > end - start) {
                start = i - (len - 1) / 2;//左边
                end = i + len / 2;//右边
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {//找中心
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;//返回当前位置元素扩展后的回文长度
    }

}
