package LeeCode;

import java.util.List;

public class code82 {
    public static void main(String[] args) {
        //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
        //[1,2,3,3,4,4,5]
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next=new ListNode(6);
        ListNode dummy = deleteDuplicates(head);
        while (dummy.next!=null){
            dummy=dummy.next;
            System.out.println(dummy.val);
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {//保证下两个存在
            if (cur.next.val == cur.next.next.val) {//后一个和后二个相同
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {//不同删除重复的后二个
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;//跳过重复的后一个
            }
        }
        return dummy.next;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
