package Leecode2;

import Util.ListNode;
import Util.ListNodeUtil;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class code117_填充每个节点的右侧节点指针 {
    public static void main(String[] args) {
        //给定一个二叉树：
        //
        //struct Node {
        //  int val;
        //  Node *left;
        //  Node *right;
        //  Node *next;
        //}
        //填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
        //
        //初始状态下，所有 next 指针都被设置为 NULL 。

    }
    //二叉树层序遍历
    public static Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            Node poll;
            for (int i = 0; i < size; i++) {
                poll=queue.poll();
                if (poll.left!=null)queue.add(poll.left);
                if (poll.right!=null)queue.add(poll.right);
                if (i<size-1) poll.next=queue.peek();//只有队列中有两个元素的时候需要给next赋值
            }
        }
        return root;
    }
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
