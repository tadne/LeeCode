package Leecode2;

import java.util.*;

public class code155_最小栈 {
    public static void main(String[] args) {
        //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
        //
        //实现 MinStack 类:
        //
        //MinStack() 初始化堆栈对象。
        //void push(int val) 将元素val推入堆栈。
        //void pop() 删除堆栈顶部的元素。
        //int top() 获取堆栈顶部的元素。
        //int getMin() 获取堆栈中的最小元素。
    }
}
//用数组实现，也可以用其他的，主要是需要两个集合来分别存储元素和最小元素
class MinStack {
    List<Integer> minStack;
    List<Integer> stack;
    public MinStack() {
        stack=new ArrayList<>();
        minStack=new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty()||val<=minStack.get(minStack.size()-1)) minStack.add(val);
    }

    public void pop() {
        Integer remove = stack.remove(stack.size() - 1);
        if (Objects.equals(remove, minStack.get(minStack.size()-1))) minStack.remove(minStack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}
