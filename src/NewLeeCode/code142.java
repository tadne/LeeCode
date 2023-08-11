package NewLeeCode;

import java.util.HashSet;

public class code142 {
    public static void main(String[] args) {
        //给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
        //
        //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        // 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        // 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
        //
        //不允许修改 链表。
    }

    //双指针
    //设起点为0,到达环入口距离为a,    在入环后慢指针走过的距离为b,   这些可以得到快指针在环中走了 a+2b的距离.
    //如此得到  a+b是环的长度的倍数,    而从起点到入口距离为a     当快慢指针交汇时,可以得到指针再走a步就能到交汇点
    //那么就得到:      让起点和指针一起走,一定会相遇在入口
    public ListNode detectCycle1(ListNode head) {
        if (head==null) return null;
        ListNode l=head;
        ListNode r=head;
        do {
            if (r == null || r.next == null) return null;
            l = l.next;
            r = r.next.next;
        } while (l != r);//找到交汇点
        r=head;
        while (r != l) {
            r = r.next;
            l = l.next;
        }
        return r;

    }

    //哈希
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        HashSet<ListNode> hashSet=new HashSet<>();
        while (head.next!=null){
            if (!hashSet.add(head))return head;
            head=head.next;
        }
        return null;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
