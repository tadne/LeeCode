package LeeCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class code331_二叉树的前序序列化 {
    public static void main(String[] args) {
        //序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
        //      9
        //  3      2
        //4   1      6
        //如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
        //给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
        //
        //保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
        //
        //你可以认为输入格式总是有效的
        //
        //例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
        //注意：不允许重建树。
    }
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;//维护遍历字符串的索引
        //用栈来模拟前序遍历树,一个栈位 push(1) 可以表示一个节点, push(2) 表示两个子节点
        //初始化,输入根节点
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) return false;//如果栈是空,说明节点少了
            if (preorder.charAt(i) == ',') {//如果是逗号直接跳过
                i++;
            } else if (preorder.charAt(i) == '#'){//是"#"
                //弹出一个空节点
                int top = stack.pop() - 1;
                if (top > 0) stack.push(top);
                i++;
            } else {//如果是实节点
                while (i < n && preorder.charAt(i) != ',') {//找到下一个逗号
                    i++;
                }
                //弹出节点
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                //放入它的两个子节点
                stack.push(2);
            }
        }
        //如果此时栈是空,那么说明树合法
        return stack.isEmpty();

    }


}
