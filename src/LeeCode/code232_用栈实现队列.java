package LeeCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class code232_用栈实现队列 {
    public static void main(String[] args) {
        //请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
        //
        //实现 MyQueue 类：
        //
        //void push(int x) 将元素 x 推到队列的末尾
        //int pop() 从队列的开头移除并返回元素
        //int peek() 返回队列开头的元素
        //boolean empty() 如果队列为空，返回 true ；否则，返回 false
        MyQueue queue=new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue);
        System.out.println(queue);
    }
   private static class MyQueue {
       Deque<Integer> stack1;
       Deque<Integer> stack2;
       public MyQueue() {
           stack1 = new ArrayDeque<>();
           stack2 = new ArrayDeque<>();
       }
       //直接放入栈1
       public void push(int x) {
           stack1.push(x);
       }

       //弹出时,如果栈2是空,就将栈1的值全部给栈2,并且反转顺序
       public int pop() {
           if (stack2.isEmpty()) {
               while (!stack1.isEmpty()) {
                   stack2.push(stack1.pop());
               }
           }
           return stack2.pop();
       }
       public int peek() {
           if (stack2.isEmpty()) {
               while (!stack1.isEmpty()) {
                   stack2.push(stack1.pop());
               }
           }
           return stack2.peek();
       }

       public boolean empty() {
           return stack1.isEmpty() && stack2.isEmpty();
       }

       private void in2out() {
           while (!stack1.isEmpty()) {
               stack2.push(stack1.pop());
           }
       }
   }
}
