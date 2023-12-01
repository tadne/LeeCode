package LeeCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.IntFunction;

public class code227_基本计算器II {
    public static void main(String[] args) {
        //给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
        //
        //整数除法仅保留整数部分。
        //
        //你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
        //
        //注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
       String s = "3/2";
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        //队列处理符号问题
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            //获取当前数
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    //乘法和除法都要用到上一个数,而且在计算时,乘法和除法要先计算
                    case '*' -> stack.push(stack.pop() * num);
                    default -> stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);//刷新符号
                num = 0;//重置
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/basic-calculator-ii/solutions/648647/ji-ben-ji-suan-qi-ii-by-leetcode-solutio-cm28/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
