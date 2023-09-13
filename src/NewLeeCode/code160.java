package NewLeeCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code160 {
    public static void main(String[] args) {
        //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
        //[4,1,8,4,5]
        //[5,6,1,8,4,5]
        ListNode A=new ListNode(4);
        A.next=new ListNode(1);
        A.next.next=new ListNode(8);
        A.next.next.next=new ListNode(4);
        A.next.next.next.next=new ListNode(5);
        ListNode B=new ListNode(5);
        B.next=new ListNode(6);
        B.next.next=new ListNode(1);
        B.next.next.next=A.next.next;
        System.out.println(getIntersectionNode(A, B).val);
    }


    // 指针 a 指向 A 链表，指针 b 指向 B 链表，依次往后遍历
    // a到末尾，则指向b头节点 继续遍历
    // b到末尾，则指向a头节点 继续遍历
    //比较长的链表指针指向较短链表head时，长度差就消除了
    //如此，只需要将最短链表遍历两次即可找到位置
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    //以上这个方法我是没看懂到什么最后长度差消除了,但是如果自己实现的时候,可以用个计数器嘛,那样复杂度也没什么影响,也很容易

    //哈希表搞定
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode idxA=headA;
        ListNode idxB=headB;
        Set<ListNode> set=new HashSet<>();
        while (idxA!=null||idxB!=null){
            if (idxA!=null) if (!set.add(idxA)) return idxA;
            if (idxB!=null) if (!set.add(idxB)) return idxB;
            idxA=idxA==null?null:idxA.next;
            idxB=idxB==null?null:idxB.next;
        }
        return null;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
