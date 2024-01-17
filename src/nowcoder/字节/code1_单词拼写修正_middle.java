package nowcoder.字节;

import java.util.Scanner;

public class code1_单词拼写修正_middle {
    //万万没想到之聪明的编辑
    //我叫王大锤，是一家出版社的编辑。
    // 负责校对投稿来的英文稿件，这工作非常烦人，因为每天都要修正无数的拼写错误。但优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：

    //1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
    //2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
    //3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC

    //我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。
    // 用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
    //万万没想到，我被开除了，临走时老板说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。”
    //请实现大锤的自动校对程序
    //数据范围：1≤n≤50 ，每个用例的字符串长度满足 1≤l≤1000
    //时间限制：C/C++ 1秒，其他语言2秒
    //空间限制：C/C++ 32M，其他语言64M
    //输入描述：
    //第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
    //后面跟随N行，每行为一个待校验的字符串。
    //输出描述：
    //N行，每行包括一个被修复后的字符串。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();in.nextLine();
        // 注意 hasNext 和 hasNextLine 的区别
        while (n-->0) { // 注意 while 处理多个 case
            String  s = in.nextLine();
            String right = review(s);
            System.out.println(right);
        }
        //System.out.println(review("yyybeettxjjjpppddsrxxxkkkyyyooowwwwwkyyxxppplllwwwiivvssnrvvvccclyydddhaaayiic"));
        //测试         yyybeettxjjjpppddsrxxxkkkyyyooowwwwwkyyxxppplllwwwiivvssnrvvvccclyydddhaaayiic
        //测试答案      yybeetxjjpddsrxxkyyowwkyyxpplwwivvsnrvvclyydhaayiic
    }
    public static String review(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int before = 1,now = 1;//上一个字符重复长度 当前字符重复长度
        int idx = 1;
        while (idx < len) {
            if (s.charAt(idx) == s.charAt(idx - 1)) {//如果相同长度+1
                now++;
            } else {//不同就维护上一字符长度
                before = now;
                now = 1;
            }
            if (now >= 3 || (now == 2 && before >= 2)) {//如果
                now--;//维护当前重复的实际长度
                idx++;
            } else {
                sb.append(s.charAt(idx++));
            }
        }
        return sb.toString();
    }
}
