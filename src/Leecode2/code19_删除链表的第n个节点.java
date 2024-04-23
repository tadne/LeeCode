package Leecode2;

import Util.ListNode;

public class code19_删除链表的第n个节点 {
    public static void main(String[] args) {
        //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    }
    //双指针
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //哑节点
        ListNode dummy=new ListNode(-1,head);
        ListNode l=dummy,r=dummy;
        while (n-->0) r=r.next;
        while (r.next!=null){
            l=l.next;
            r=r.next;
        }
        l.next=l.next.next;
        return head;
    }
}
