package LeeCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class code116_填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        //给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
        //
        //struct Node {
        //  int val;
        //  Node *left;
        //  Node *right;
        //  Node *next;
        //}
        //填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
        //
        //初始状态下，所有 next 指针都被设置为 NULL。
        Node node=null;
        node.left=new Node(2);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right=new Node(3);
        node.right.left=new Node(6);
        node.right.right=new Node(7);
        Node connect = connect(node);
        System.out.println(connect);
    }
    //遍历链表来处理,一个链表一层元素
    //这样的话,我们只要有上一层链表,就能推出下一层链表
    //这里要注意,题目说的是该树为完全二叉树,如果不是完全二叉树,这里需要一定的修改
    public Node connect2(Node root) {
        if (root == null) return null;
        // 维护每一层链表最左边的节点
        Node leftmost = root;
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                // 左右子节点成链表
                head.left.next = head.right;
                // head的right节点和head.next的left节点
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solutions/446938/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    //维护队列长度,一个队列实现层序遍历
    public static Node connect1(Node root) {
        if (root==null) return null;
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        //维护队列的长度
        int size=1;
        while (!queue.isEmpty()){
            //只遍历当前队列的元素
            while (size-->0){
                Node poll = queue.poll();
                if (size!=0) poll.next = queue.peek();//处理next指针,但是要注意size=0时,next会连接到下一层
                //将下一层元素加入队列
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            size=queue.size();
        }
        return root;
    }
    //两个队列交替实现层序遍历
    public static Node connect(Node root) {
        if (root==null) return null;
        //两个队列分别维护两个层
        Queue<Node> queue1=new ArrayDeque<>();
        Queue<Node> queue2=new ArrayDeque<>();
        queue1.add(root);
        while (!queue1.isEmpty()){
            //队列1非空,遍历队列1
            while (!queue1.isEmpty()){
                Node poll = queue1.poll();
                if (!queue1.isEmpty()) poll.next = queue1.peek();//处理next指针
                //将下一层元素放入队列2
                if (poll.left != null) {
                    queue2.add(poll.left);
                }
                if (poll.right != null) {
                    queue2.add(poll.right);
                }
            }
            //队列2非空,遍历队列2
            while (!queue2.isEmpty()){
                Node poll = queue2.poll();
                if (!queue2.isEmpty()) poll.next = queue2.peek();//处理next指针
                //将下一层元素放入队列1
                if (poll.left != null) {
                    queue1.add(poll.left);
                }
                if (poll.right != null) {
                    queue1.add(poll.right);
                }
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
