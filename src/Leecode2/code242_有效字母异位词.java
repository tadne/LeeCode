package Leecode2;

public class code242_有效字母异位词 {
    public static void main(String[] args) {
        //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
        //
        //注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
    }
    public static boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c-'a']++;
        }
        for (int i : arr) {
            if (i!=0) return false;
        }
        return true;
    }
}
