package LeeCode;

import java.util.*;

public class code242 {
    public static void main(String[] args) {
        //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
        //若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
        String s="aacc";
        String t="ccac";
        System.out.println(isAnagram2(s, t));
    }
    //用数组存,效率高些
    public static boolean isAnagram2(String s, String t) {
        int m = s.length(),n=t.length();
        if (m!=n) return false;
        int[] ints=new int[26];
        for (int i = 0; i < n; i++) {//存入t,其实长度相同,所以存t还是存s是一样的
            ints[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < m; i++) {
            int c = --ints[s.charAt(i) - 'a'];//先减,再取值
            if (c<0) return false;
        }
        return true;
    }

    //直接排序
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //用map集合计数
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> mapS=new HashMap<>();
        HashMap<Character,Integer> mapT=new HashMap<>();
        addNumChar(s,mapS);
        addNumChar(t,mapT);
        if (mapS.size()!=mapT.size()) return false;
        return mapT.equals(mapS);
    }
    //将s分为存入map计数
    public static void addNumChar(String s,HashMap<Character,Integer> map){
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
    }

}
