package Leecode2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code138_随机链表的复制 {
    public static void main(String[] args) {
        //给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
        //
        //构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
        // 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
        //
        //例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
        //
        //返回复制链表的头节点。
        //
        //用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
        //
        //val：一个表示 Node.val 的整数。
        //random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
        //你的代码 只 接受原链表的头节点 head 作为传入参数。
    }
    private static class RandomNode {
        //我们创建了一个map集合，建立新链表和旧链表的映射
        //然后，开始创建新链表，如果random是新链表中还不存在的节点，那就去提前创建好该节点到map中，如果map中存在就直接获取即可
        //提前创建节点到map中这步操作就会用到深度优先搜索，需要先遍历后面的节点来返回值给前面
        Map<Node, Node> cachedNode = new HashMap<>();//缓存 <head节点，new节点>
        //递归
        public Node copyRandomList(Node head) {
            if (head == null) return null;//递归终止条件
            if (!cachedNode.containsKey(head)) {//如果缓存中没有
                Node headNew = new Node(head.val);
                cachedNode.put(head, headNew);//创建缓存
                //深度搜索来创建节点
                headNew.next = copyRandomList(head.next);
                headNew.random = copyRandomList(head.random);
            }
            return cachedNode.get(head);
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
