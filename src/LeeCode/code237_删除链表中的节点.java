package LeeCode;

public class code237_删除链表中的节点 {
    public static void main(String[] args) {
        //有一个单链表的 head，我们想删除它其中的一个节点 node。
        //
        //给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
        //
        //链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
        //
        //删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
        //
        //给定节点的值不应该存在于链表中。
        //链表中的节点数应该减少 1。
        //node 前面的所有值顺序相同。
        //node 后面的所有值顺序相同。
        //链表中节点的数目范围是 [2, 1000]
        //-1000 <= Node.val <= 1000
        //链表中每个节点的值都是 唯一 的
        //需要删除的节点 node 是 链表中的节点 ，且 不是末尾节点
    }
    //其实就是说,这个题目的要求是在原链表中删除node节点
    //但是显然,只给node节点是不可能删除node节点本身的,只能修改node节点
    //也就是说,如果将node节点修改成下一个节点的样子,再将node节点的下一个节点删除
    //就相当于删除了node节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
