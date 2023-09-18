package LeeCode;

import java.util.*;

public class code151 {
    public static void main(String[] args) {
        //给你一个字符串 s ，请你反转字符串中 单词 的顺序。
        //
        //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
        //
        //返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
        //
        //注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
        // 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
        String s="  hello world  ";
        System.out.println("|"+reverseWords(s)+"|");
    }
    public static String reverseWords(String s) {
        List<StringBuilder> list=new ArrayList<>();
        for (int i = s.length()-1; i>=0; i--) {
            StringBuilder sb=new StringBuilder();
            for (int j = i; j >=0; j--,i--) {
                if (s.charAt(j)!=' ')  sb.append(s.charAt(j));
                else break;
            }
            if (sb.length()!=0) list.add(sb.reverse());
        }
       StringBuilder res=new StringBuilder();
        for (int i =0; i <list.size(); i++) {
            if (i!= list.size()-1) res.append(list.get(i).append(' '));
            else res.append(list.get(i));
        }
        return res.toString();
    }
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}
