package LeeCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class code150_逆波兰表达式求值 {
    public static void main(String[] args) {
        //给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式也叫后缀表达式（将运算符写在操作数之后）。
        //请你计算该表达式。返回一个表示表达式值的整数。
        //注意：
        //有效的算符为 '+'、'-'、'*' 和 '/' 。
        //每个操作数（运算对象）都可以是一个整数或者另一个表达式。
        //两个整数之间的除法总是 向零截断 。
        //表达式中不含除零运算。
        //输入是一个根据逆波兰表示法表示的算术表达式。
        //答案及所有中间计算结果可以用 32 位 整数表示。
        //tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]    =====>  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        //
        //逆波兰表达式：一种后缀表达式，所谓后缀就是指算符写在后面。
        //平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
        //该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
        //逆波兰表达式主要有以下两个优点：
        //去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
        //适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中

    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (String token : tokens) {
            if (isNumber(token)) {//将数字放入栈
                stack.push(Integer.parseInt(token));
            } else {//如果是运算符,就找两个数字出来
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {//并将运算结果再次放入栈中
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num1 / num2);
                }
            }
        }
        return stack.pop();
    }
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation/solutions/667892/ni-bo-lan-biao-da-shi-qiu-zhi-by-leetcod-wue9/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
