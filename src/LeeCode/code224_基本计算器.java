package LeeCode;

import java.util.Deque;
import java.util.LinkedList;

public class code224_基本计算器 {
    public static void main(String[] args) {
        //给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
        //
        //注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
        //提示：
        //1 <= s.length <= 3 * 105
        //s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
        //s 表示一个有效的表达式
        //'+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
        //'-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
        //输入中不存在两个连续的操作符
        //每个数字和运行的计算将适合于一个有符号的 32位 整数
    }
    //因为是加减法计算器,所以括号其实不是关键,符号才是
    //将所有括号去掉,要做的是将符号分发给每一个数字
    //然后将它们加起来就是结果
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        int sign = 1;   //符号
        ops.push(sign); //先放好符号
        int ret = 0;    //结果
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {//空格跳过
                i++;
            } else if (s.charAt(i) == '+') {//＋号就摆正符号
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {//-号就摆正符号
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {// ( 括号进栈   就是引入符号,给括号内的数字分发符号
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {//  ) 括号出栈  就是将符号去掉,等待下一个符号进栈
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {//如果是数字
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/basic-calculator/solutions/646369/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }
}
