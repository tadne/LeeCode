package Leecode2;

import java.util.*;

public class code205_同构字符串 {
    public static void main(String[] args) {
        //给定两个字符串 s 和 t ，判断它们是否是同构的。
        //
        //如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
        //
        //每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
        // 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
        //1 <= s.length <= 5 * 10^4
        //t.length == s.length
        //s 和 t 由任意有效的 ASCII 字符组成
        String s="badc";
        String t="baba";
        System.out.println(isIsomorphic1(s, t));
    }
    //int数组做映射
    public static boolean isIsomorphic1(String s, String t) {
       int[] arrS = new int[128];
        Arrays.fill(arrS,-1);
       int[] arrT = new int[128];
       int len = s.length();
        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (arrS[sc]!=-1) {
                if (arrS[sc]!=tc) return false;
            } else if (arrT[tc]!=0) return false;
            arrT[tc]++;
            arrS[sc]=tc;
        }
       return true;
    }


    //map集合做映射
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)){
                if (map.get(sc)!=tc) return false;
            }else {
                if (!set.add(tc)) return false; //如果当前t中的tc字符重复了，说明该字符的映射已经存在
                map.put(sc,tc);
            }
        }
        return true;
    }
}
