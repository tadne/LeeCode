package Leecode2;

import java.util.HashSet;
import java.util.Set;

public class code3_无重复字符的最长子串 {
    public static void main(String[] args) {
        //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
        //s 由英文字母、数字、符号和空格组成
        String s="aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
    //优化，发现其实不需要记录字符出现的次数，直接记录位置即可
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128];//idx:字符，val：字符的位置
        for (int j = 0, i = 0; j < n; j++) {
            //i是左指针，指向当前字符的上一次出现的位置
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//记录当前字符的位置
        }
        return ans;
    }



    //常规方法，数组记录重复
    public static int lengthOfLongestSubstring(String s) {
        int[][] arr=new int[128][2];// arr[i][0]: 元素i出现的次数。 arr[i][1]: 元素i上次出现的索引位置
        int len=s.length();
        int l=0,r=0;
        int max=0;
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            arr[c][0]++;
            if (arr[c][0]!=1) {
                while (l<arr[c][1]+1) arr[s.charAt(l++)][0]--;
            }
            arr[c][1]=i;
            max=Math.max(i-l+1,max);
        }
        return max;
    }

}
