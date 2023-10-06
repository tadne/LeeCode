package LeeCode;

import java.util.HashMap;
import java.util.Map;

public class code138_随机链表的复制 {
    public static void main(String[] args) {
        //给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
        //构造这个链表的 深拷贝。
        // 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
        // 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
        // 复制链表中的指针都不应指向原链表中的节点 。
        //例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
        //返回复制链表的头节点。
        //用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
        //val：一个表示 Node.val 的整数。
        //random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
        //你的代码 只 接受原链表的头节点 head 作为传入参数。
        //[7,null],[13,0],[11,4],[10,2],[1,0]
        Node node=new Node(7);
        node.next=new Node(13);
        node.next.next=new Node(11);
        node.next.next.next=new Node(10);
        node.next.next.next.next=new Node(1);
        node.random=null;
        node.next.random=node;
        node.next.next.random=node.next.next.next.next;
        node.next.next.next.random=node.next.next;
        node.next.next.next.next.random=node;
        Node node1 = copyRandomList(node);
        System.out.println(node1);
    }

    //这个题的关键在于:     我们在给random赋值的时候,这个值可能还没有被创建出来
    //办法:   回溯法+Map:
    //      Map:    <head,newHead>:     键存旧链表,值存新链表
    //      回溯:     如果这个random值没有被创建,那么就递归取创建.等到之后回到当前层的时候,自然会将值返回给对应random
    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList1(Node head) {
        if (head == null) return null;//递归终止条件
        if (!cachedNode.containsKey(head)) {//如果缓存中没有
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);//创建缓存
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }
        return cachedNode.get(head);
    }


    //笨办法的直接遍历
    public static Node copyRandomList(Node head) {
        Node dummy=new Node(0);
        Node d1=dummy;
        Node h1=head;
        while (h1!=null){//先复制val值
            d1.next=new Node(h1.val);
            d1=d1.next;
            h1=h1.next;
        }
        h1=head;
        d1=dummy.next;
        while (h1!=null){//再遍历复制random
            d1.random=getRandomNodeForDummy(head, h1 , dummy.next);
            h1=h1.next;
            d1=d1.next;
        }
        return dummy.next;
    }
    public static Node getRandomNodeForDummy(Node head,Node h1,Node d2){
        Node random = h1.random;
        if (random==null) return null;
        while (true){
            if (random==head) return d2;
            head=head.next;
            d2=d2.next;
        }
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
