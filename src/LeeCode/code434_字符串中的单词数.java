package LeeCode;

public class code434_字符串中的单词数 {
    public static void main(String[] args) {
        //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
        //
        //请注意，你可以假定字符串里不包括任何不可打印的字符。
    }
    //简单过滤
    public int countSegments(String s) {
        int ans = 0;
        int re = 0;//连续字符状态
        for (char c : s.toCharArray()) {
            if (c != ' '&&re==0) {//如果不是空格且是连续字符的第一个，结果+1
                ans++;
                re = 1;
            } else if (c==' ') re=0;//如果是空格，就刷新连续字符状态
        }
        return ans;
    }
}
