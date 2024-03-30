package Leecode2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code151_反转字符串中的单词 {
    public static void main(String[] args) {
        //给你一个字符串 s ，请你反转字符串中 单词 的顺序。
        //
        //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
        //
        //返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
        //
        //注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
        String s="   the sky is blue  ";
        System.out.println(reverseWords(s));
    }

    //用工具类
    public static String reverseWords1(String s) {
        // 去除开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }



    //拼接字符串
    public static String reverseWords(String s) {
        StringBuilder res=new StringBuilder();
        boolean start=true;
        int len=s.length();
        for (int i = 0; i < len; i++) {
            while (i<len&&s.charAt(i)==' ') i++;
            if (i==len) break;
            int k=0;
            StringBuilder word=new StringBuilder();
            while (i<len&&s.charAt(i)!=' '){
                word.append(s.charAt(i));
                i++;
            }
            word.append(' ').append(res);
            res=word;
        }
        res.delete(res.length()-1,res.length());
        return res.toString();
    }
}
