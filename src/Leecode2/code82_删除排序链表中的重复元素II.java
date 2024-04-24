package Leecode2;

import Util.ListNode;

public class code82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
    }
    public ListNode deleteDuplicates(ListNode head) {
        //哑节点
        ListNode dummy=new ListNode(-1,head);
        ListNode cur=dummy;
        while (cur.next != null&&cur.next.next!=null){
            //如果出现重复
            if (cur.next.val==cur.next.next.val){
                //以下一个节点为基将后序重复出现的删除
                ListNode tmp=cur.next;
                while (tmp.next != null && tmp.val == tmp.next.val) {
                    tmp.next = tmp.next.next;
                }
                //将下一个节点也删除
                cur.next=tmp.next;
            }else cur=cur.next;
        }
        return dummy.next;
    }
}
