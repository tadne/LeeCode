package LeeCode;

import java.util.HashMap;
import java.util.Map;

public class code290_单词规律 {
    public static void main(String[] args) {
        //给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
        //
        //这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    //和第205题一模一样,都是要建立一对一映射
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int len=pattern.length();
        if (len != words.length) return false;//长度不同就没有一对一映射了
        Map<String, Character> sp = new HashMap<>();
        Map<Character, String> ps = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c=pattern.charAt(i);
            Character put = sp.put(words[i],c);//获取的是上一个字符对应的字符串
            String put1 = ps.put(c, words[i]);//获取的是上一个字符串对应的字符
            if (put1 != null && !put1.equals(words[i]) || put != null && put != c) {//比较上一个和现在的区别
                return false;
            }
        }
        return true;
    }
}
