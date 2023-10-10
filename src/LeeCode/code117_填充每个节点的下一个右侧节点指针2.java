package LeeCode;

import java.util.*;

public class code117_填充每个节点的下一个右侧节点指针2 {
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
        Node node=new Node(1);
        node.left=new Node(2);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right=new Node(3);
        node.right.right=new Node(7);
        node.right.left=null;
        Node connect = connect(node);
        //       1
        //  2        3
        //4  5   null  7
    }
    //用队列实现先进先出,实现层序遍历
    public static Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(root);//添加根节点
        while (!queue.isEmpty()){
            int size=queue.size();//记录当前大小,只遍历当前大小长度
            Node pop =null;//临时值方便设置next属性
            for (int i = 0; i < size; i++) {
                pop = queue.poll();
                if (pop.left!=null) queue.offer(pop.left);//加入下一层元素
                if (pop.right!=null) queue.offer(pop.right);
                if (!queue.isEmpty()&&i<size-1) pop.next = queue.peek();//设置属性, i<size-1来保证分层
            }
        }
        return root;
    }

    //就是用链表来代替队列实现层序遍历,因为本身就是要在树中构建链表,所以速度很快
    public Node connect1(Node root) {
        if (root == null) return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作 , 在下一层前面添加一个哑结点（注意这里是访问当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

//    作者：数据结构和算法
//    链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/solutions/429992/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
