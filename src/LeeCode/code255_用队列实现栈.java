package LeeCode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class code255_用队列实现栈 {
    public static void main(String[] args) {

    }
   private static class MyStack {
       Queue<Integer> queue1;
       Queue<Integer> queue2;
       public MyStack() {
           queue1 = new LinkedList<>();
           queue2 = new LinkedList<>();
       }
       public void push(int x) {
           //先放到queue2,再将queue1中元素加入queue2,再交换queue1和queue2
           //其实就是反转了队列中的元素顺序
           queue2.offer(x);
           while (!queue1.isEmpty()) {
               queue2.offer(queue1.poll());
           }
           Queue<Integer> temp = queue1;
           queue1 = queue2;
           queue2 = temp;
       }
       public int pop() {
           return queue1.poll();
       }
       public int top() {
           return queue1.peek();
       }
       public boolean empty() {
           return queue1.isEmpty();
       }
    }
}
