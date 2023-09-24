package WeekRace.Week364;

public class code8048 {
    public static void main(String[] args) {
        //给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
        //你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
        //
        //以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
        //
        //注意 返回的结果字符串 可以 含前导零。
    }
    public static String maximumOddBinaryNumber(String s) {
        StringBuilder res=new StringBuilder();
        int len = s.length();
        int count=0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)=='1') count++;
        }
        int i = 0;
        for (int j = 0; j < count-1; j++,i++) {
            res.append('1');
        }
        for (; i < len-1; i++) {
            res.append('0');
        }
        res.append('1');
        return res.toString();
    }
}
