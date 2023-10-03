package LeeCode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class code20_有效括号 {
    public static void main(String[] args) {
        //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
        //
        //有效字符串需满足：
        //
        //左括号必须用相同类型的右括号闭合。
        //左括号必须以正确的顺序闭合。
        //每个右括号都有一个对应的相同类型的左括号。
        String s="(){}}{";
        System.out.println(isValid(s));
    }
    //用栈,先进后出
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            switch (c){
                case '(':stack.push(')');break;
                case '[':stack.push(']');break;
                case '{':stack.push('}');break;
                case ')':if (stack.isEmpty()||stack.pop()!=c) return false;break;
                case ']':if (stack.isEmpty()||stack.pop()!=c) return false;break;
                case '}':if (stack.isEmpty()||stack.pop()!=c) return false;break;
            }
        }
        return stack.isEmpty();
    }
}
