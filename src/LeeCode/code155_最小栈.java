package LeeCode;

import java.util.*;
import java.util.function.ToIntFunction;

public class code155_最小栈 {
    public static void main(String[] args) {
        //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
        //
        //实现 MinStack 类:
        //MinStack() 初始化堆栈对象。
        //void push(int val) 将元素val推入堆栈。
        //void pop() 删除堆栈顶部的元素。
        //int top() 获取堆栈顶部的元素。
        //int getMin() 获取堆栈中的最小元素。栈:先进后出
        //"MinStack","push","push","push","getMin","pop","getMin"
        //-2^31 <= val <= 2^31 - 1
        //pop、top 和 getMin 操作总是在 非空栈 上调用
        //push, pop, top, and getMin最多被调用 3 * 10^4 次
    }
}
//朴素的用集合做,然后直接遍历删除
class MinStack{
    private static ArrayList<Integer> stack;
    public MinStack(){
        stack=new ArrayList<>();
    }
    void push(int val){
        stack.add(val);
    }
    void pop(){
        if (stack.size()>0) {
            stack.remove(stack.size() - 1);
        }
    }
    int top(){
        if (stack.size()>0){
            return stack.get(stack.size()-1);
        }else return 0;
    }
    int getMin(){
        int min=stack.get(0);
        for (Integer integer : stack) {
            min=Math.min(min,integer);
        }
        return min;
    }
}
//用两个栈做,一个是辅助栈来维护最小值
class MinStack1{
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public MinStack1() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek()) min_stack.push(x);//只记录最小元素
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek())) min_stack.pop();//如果相等才pop
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }
//    作者：Krahets
//    链接：https://leetcode.cn/problems/min-stack/solutions/9036/min-stack-fu-zhu-stackfa-by-jin407891080/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
//朴素的用集合+辅助栈做   hhhh维护我自己做栈的尊严
class MinStack2{
    private static ArrayList<Integer> stack;
    private Stack<Integer> min_stack;
    public MinStack2(){
        stack=new ArrayList<>();
        min_stack = new Stack<>();
    }
    void push(int val){
        stack.add(val);
        if(min_stack.isEmpty() || val <= min_stack.peek()) min_stack.push(val);//只记录最小元素
    }
    void pop(){
        Integer remove = stack.remove(stack.size() - 1);
        if(remove.equals(min_stack.peek())) min_stack.pop();//如果相等才pop
    }
    int top(){
        return stack.get(stack.size()-1);
    }
    int getMin(){
        return min_stack.peek();
    }
}

