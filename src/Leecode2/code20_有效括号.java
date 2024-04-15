package Leecode2;

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
        String s="()[]{}";
        System.out.println(isValid(s));
    }
    //先进后出栈，刚好符合符号匹配的规则
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.add(c);
                case '[' -> stack.add(c);
                case '{' -> stack.add(c);
                case ')' -> {
                    if(stack.isEmpty()||stack.pop()!='(') return false;
                }
                case ']' -> {
                    if(stack.isEmpty()||stack.pop()!='[') return false;
                }
                case '}' -> {
                    if(stack.isEmpty()||stack.pop()!='{') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
