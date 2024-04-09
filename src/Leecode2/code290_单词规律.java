package Leecode2;

import java.util.HashSet;
import java.util.Set;

public class code290_单词规律 {
    public static void main(String[] args) {
        //给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
        //
        //这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
        //pattern 只含小写英文字母
        //1 <= s.length <= 3000
        //s 只包含小写英文字母和 ' '
        //s 不包含 任何前导或尾随对空格
        //s 中每个单词都被 单个空格 分隔
    }
    //数组映射
    public boolean wordPattern(String pattern, String s) {
        int len=pattern.length();
        //
        String[] words = s.split(" ");
        if (len!=words.length) return false;
        String[] map=new String[26];
        Set<String> set=new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            int c = pattern.charAt(i)-'a';
            if (map[c]!=null) {
                if (!map[c].equals(words[i])) return false;
            }else {
                if (!set.add(words[i])) return false;
                map[c] = words[i];
            }
        }
        return true;
    }
}
