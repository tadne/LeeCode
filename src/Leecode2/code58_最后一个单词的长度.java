package Leecode2;

public class code58_最后一个单词的长度 {
    public static void main(String[] args) {
        //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
        //
        //单词 是指仅由字母组成、不包含任何空格字符的最大
        //子字符串
        //
    }
    public int lengthOfLastWord(String s) {
        int len=0;
        int count=0;
        //去掉后置空格
        while (s.charAt(s.length()-1-count)==' ') {
            count++;
        }
        //计算单词长度
        for (int i = s.length()-1-count; i >= 0; i--) {
           if (s.charAt(i)!=' ') len++;
           else break;
        }
        return len;
    }
}
