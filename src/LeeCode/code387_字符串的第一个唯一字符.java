package LeeCode;

import Util.TreeNode;

import java.util.*;

public class code387_字符串的第一个唯一字符 {
    public static void main(String[] args) {
        //给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
        // s中只含小写字母
        System.out.println(firstUniqChar("loveleetcode"));
    }
    //数组计数  lc:3ms
    public static int firstUniqChar(String s) {
        int[] arr=new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
           arr[c-'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i]-'a']==1) return i;
        }
        return -1;
    }
    //哈希表计数 lc:24ms
    public int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        Set<Character> charsSet=new HashSet<>();
        Set<Character> idxSet=new HashSet<>();//存重复的字符
        for (char c : chars) {
            boolean add = charsSet.add(c);
            if (!add) idxSet.add(c);}
        for (int i = 0; i < chars.length; i++) {
            if (!idxSet.contains(chars[i])) return i;
        }
        return -1;
    }
}
