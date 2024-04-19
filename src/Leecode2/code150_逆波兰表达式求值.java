package Leecode2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class code150_逆波兰表达式求值 {
    public static void main(String[] args) {
        //给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
        //请你计算该表达式。返回一个表示表达式值的整数。
        //
        //注意：
        //
        //有效的算符为 '+'、'-'、'*' 和 '/' 。
        //每个操作数（运算对象）都可以是一个整数或者另一个表达式。
        //两个整数之间的除法总是 向零截断 。
        //表达式中不含除零运算。
        //输入是一个根据逆波兰表示法表示的算术表达式。
        //答案及所有中间计算结果可以用 32 位 整数表示。
        String[] strings={"4","13","5","/","+"};
        System.out.println(evalRPN(strings));
    }
    //逆波兰表达式的特点是：先给数字再给运算符号
    //栈是先进后出，也叫后进先出，这样就可以不断将前两个数字的运算结果取出和新的要计算的数字进行计算
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                //这里要注意的是，先吐出的值是上一次运算的值，是在数组右边的数
                int right=stack.pop();
                int left=stack.pop();
                switch (token) {
                    case "+" -> stack.push(left + right);
                    case "-" -> stack.push(left - right);
                    case "*" -> stack.push(left * right);
                    case "/" -> stack.push(left / right);
                }
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
