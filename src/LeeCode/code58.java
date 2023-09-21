package LeeCode;

public class code58 {
    public static void main(String[] args) {
        //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
        //
        //单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

    }
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
    public int lengthOfLastWord1(String s) {
        int res=0;
        for (int i = s.length()-1; i>=0; i--) {//倒着遍历
            if (s.charAt(i)!=' ') res++;
            else if (i<s.length()-1&&s.charAt(i)==' '&&s.charAt(i+1)!=' ') break;
        }
        return res;
    }
}
