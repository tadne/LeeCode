package LeeCode;

import java.util.Arrays;

public class code409_最长回文串 {
    public static void main(String[] args) {
        //给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
        //
        //在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
        //s 只由小写 和/或 大写英文字母组成
    }
    //用数组排序,时间复杂度 O(n)
    public int longestPalindrome1(String s) {
        int[] arr=new int['z'+1];
        int res=0;
        int carry=0;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            int tmp = arr[i] % 2;
            res+=arr[i]-tmp;
            if (tmp==1) carry=1;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            int tmp = arr[i] % 2;
            res+=arr[i]-tmp;
            if (tmp==1) carry=1;
        }
        return res+carry;
    }
    //直接排序
    public int longestPalindrome(String s) {
        int res=0;
        int mid=0;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for ( int i = 0;i < chars.length; i++) {
            if (i<chars.length-1&&chars[i]==chars[i+1]) {
                res+=2;
                i++;
            }else mid=1;
        }
        return res+mid;
    }
}
