package LeeCode;

import java.util.HashSet;

public class code141 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head ，判断链表中是否有环。
        //
        //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        // 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        // 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
        //
        //如果链表中存在环 ，则返回 true 。 否则，返回 false 。
        ListNode listNode=new ListNode(1);
        listNode.next=listNode;
        System.out.println(hasCycle(listNode));
    }
    //快慢指针,快指针比慢指针快,如果快指针和慢指针重合,说明有环
    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;//无环
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    //哈希表,效率不高,不过比较好想
    public static boolean hasCycle(ListNode head) {
        if (head==null) return false;
        HashSet<ListNode> hashSet=new HashSet<>();
        while (head.next!=null){
            if (!hashSet.add(head)) return true;
            head=head.next;
        }
        return false;
    }


   private static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}
