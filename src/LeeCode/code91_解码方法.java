package LeeCode;

public class code91_解码方法 {
    public static void main(String[] args) {
        //一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
        //'A' -> "1"
        //'B' -> "2"
        //...
        //'Z' -> "26"
        //要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。如: "11106" 可以映射为：
        //"AAJF" ，将消息分组为 (1 1 10 6)
        //"KJF" ，将消息分组为 (11 10 6)
        //注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
        //
        //给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
        //
        //题目数据保证答案肯定是一个 32 位 的整数。
        System.out.println(numDecodings("2101"));
    }
    //动态规划,用fi表示前i个字符的解码方法数
    //两种情况,
    // 一: 使用了一个字符,只要这个字符不是0就可以被解码,所以解码方法数不变,               fi=fi-1
    // 二: 使用了两个字符,只要这两个字符的前一个字符不是0并且小于26,就可以被解码,所以      fi=fi-2
    public int numDecodings1(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {//只选一个字符
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {//选两个字符
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/decode-ways/solutions/734344/jie-ma-fang-fa-by-leetcode-solution-p8np/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //暴力递归,超时了
    static int res=0;
    public static int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        trackBack(s,0);
        return res;
    }
    public static void trackBack(String s,int idx){
        if (idx==s.length()){
             res++;
             return ;
        }
        if (idx<=s.length()-2) {
            String substring = s.substring(idx, idx + 2);//截取两位
            if (substring.charAt(0)=='0') return;//前一位是0
            int i=Integer.parseInt(substring);
            if (i<=26&&i>=1)  trackBack(s,idx+2);
        }
        if (s.charAt(idx)!='0')  trackBack(s,idx+1);
    }


}
