package LeeCode;

public class code1_最长回文子串 {
    public static void main(String[] args) {
        //给你一个字符串 s，找到 s 中最长的回文子串。
        //
        //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
        String s="abccc";
        System.out.println(longestPalindrome1(s));
    }
    //采用中心扩展法
    //就是遍历字符串,选择i或者选择i和i+1作为中心找最长的回文字符串
    public static String longestPalindrome1(String s) {
        int len=0,right=0;//只获取回文子串的右边索引和长度,因为回文子串的右边索引的计算公式不会随中心选择变化而变化 idx=i+len/2
        for (int i = 0; i < s.length(); i++) {
            int expand1 = expand(s, i, i);
            int expand2 = expand(s, i, i + 1);
            int max=Math.max(expand1,expand2);
            if (max>len) {
                right=i+max/2;
                len=max;
            }
        }
        return s.substring(right-len+1,right+1);
    }
    //寻找最长的回文字符串
    public static int expand(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
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
