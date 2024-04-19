package Leecode2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class code224_基本计算器 {
    public static void main(String[] args) {
        //给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
        //
        //注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
        //提示：
        //
        //1 <= s.length <= 3 * 105
        //s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
        //s 表示一个有效的表达式
        //'+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
        //'-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
        //输入中不存在两个连续的操作符
        //每个数字和运行的计算将适合于一个有符号的 32位 整数
    }
    public int calculate(String s) {
        Deque<Integer> stack=new LinkedList<>();//符号存储
        int res=0;
        int sign=1;//当前符号
        stack.push(sign);
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (c==' '){
                continue;
            }else if (c=='+'){//符号不变
                if (!stack.isEmpty()) sign=stack.peek();
            }else if (c=='-'){//符号改变
                if (!stack.isEmpty()) sign=-stack.peek();
            }else if (c=='('){//左括号就将当前符号储存，之后括号内的值都使用这个符号
                stack.push(sign);
            }else if (c==')'){//右括号就将该符号丢弃
                stack.pop();
            }else {//数字就获取当前值并按照当前符号添加
                long num=0;
                while (i<s.length()&&Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i++)-'0';
                }
                res+=sign*num;
                //维护循环
                i--;
            }
        }
        return res;
    }
}
