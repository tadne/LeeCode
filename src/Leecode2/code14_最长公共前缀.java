package Leecode2;

import java.util.Arrays;

public class code14_最长公共前缀 {
    public static void main(String[] args) {
        //编写一个函数来查找字符串数组中的最长公共前缀。
        //
        //如果不存在公共前缀，返回空字符串 ""。
        //1 <= strs.length <= 200
        String [] arr={"ab","a"};
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String[] strs) {
        String  res=strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (res.length()>strs[i].length()){
                res=res.substring(0,strs[i].length());
            }
            for (int j = 0; j < strs[i].length()&&j<res.length(); j++) {
                if (res.charAt(j)!=strs[i].charAt(j)){
                    res=res.substring(0,j);
                }
            }
        }
        return res;
    }
}
