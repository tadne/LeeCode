package LeeCode;

import java.util.HashSet;
import java.util.Set;

public class code345_反转字符串中的元音字母 {
    public static void main(String[] args) {
        //给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
        //
        //元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
        System.out.println(reverseVowels("aA"));
    }
    //双指针,左右指针进行交换实现翻转,中间这段类似快速排序
    public static String reverseVowels(String s) {
        Set<Character> set=Set.of('a','e','i','o','u','A','E','I','O','U');
        char[] chars = s.toCharArray();
        int n=chars.length;
        int l=0,r=n-1;
        while (l<r){
            while (!set.contains(chars[l])&&l<r) l++;
            while (!set.contains(chars[r])&&l<r) r--;
            swap(chars,l,r);
            l++;r--;
        }
        return new String(chars);
    }
    public static void swap(char[] chars,int i,int j){
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }

}
