package LeeCode;

import java.util.Arrays;

public class code318_最大单词长度乘积 {
    public static void main(String[] args) {
        //给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，
        // 并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
        String[]words={"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(maxProduct(words));
    }


    public static int maxProduct1(String[] words) {
        int n = words.length, idx = 0;
        int[] masks = new int[n];//用26位储存字母,1表示存在,0表示不存在
        for (String w : words) {
            int t = 0;
            for (int i = 0; i < w.length(); i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            masks[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());//如果没有公共字母就记录结果
            }
        }
        return ans;
    }



    //暴力,不过其中用了排序,从大到小排列
    //进行了一定剪枝
    public static int maxProduct(String[] words) {
        int res=0;
        Arrays.sort(words,(s1,s2)->s2.length()-s1.length());
        loop: for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (!check(words[i],words[j])){
                  res=Math.max(res,words[i].length()*words[j].length());
                  continue loop;
                }
            }
        }
        return res;
    }
    //检查两个单词是否有公共字母
    //采用了位运算,26位来储存26个字母的存在性,实现找到公共字母的操作
    public static boolean check(String s1,String s2){
        int num1=0,num2=0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (char c : chars1) {
            num1 |= (1 << (c-'a'));//让出现了的字母的那一位为1
        }
        for (char c : chars2) {
            num2 |= (1 << (c-'a'));//让出现了的字母的那一位为1
        }
        return (num1&num2)!=0;
    }

}
