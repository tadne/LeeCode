package WrittenExamination.微派;

import java.util.List;
import java.util.Stack;

public class code2 {
    public static void main(String[] args) {
        //给一个队列，只能再使用另一个队列作为储存
        //将这个队列升序排序
        Stack<Integer> stack=new Stack<>();
        List<Integer> list=List.of(5,1,4,2,3);
        stack.addAll(list);
        System.out.println(sortStack(stack));
    }
    //差不多就是两个栈来回倒，当主栈顶元素小于辅助栈顶元素的时候，将主栈元素放入辅助栈
    //当辅助栈顶元素大于主栈顶元素的时候，将辅助栈元素放入主栈
    public static Stack<Integer> sortStack(Stack<Integer> input){
        Stack<Integer> other=new Stack<>();
        while (!input.empty())
        {
            int temp = input.peek();
            input.pop();
            //如果辅助栈不为空且当前元素比辅助栈栈顶元素小，则将辅助栈中元素弹出压入主栈中
            while (!other.empty() && other.peek() > temp) {
                input.push(other.peek());
                other.pop();
            }
            //如果辅助栈为空或者当前元素比辅助栈栈顶元素大，则将当前元素直接压入辅助栈中
            other.push(temp);
        }
        return other;
    }

}
