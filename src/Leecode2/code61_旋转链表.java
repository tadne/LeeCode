package Leecode2;

import Util.ListNode;
import Util.ListNodeUtil;

public class code61_旋转链表 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
        ListNode node = ListNodeUtil.arrToListNode(new int[]{1,1,1});
        ListNodeUtil.printLisNode(rotateRight1(node,0));
    }
    //在操作k的同时获取链表的长度,如果k大于链表长度再对链表进行重新遍历
    public static ListNode rotateRight1(ListNode head, int k) {
        ListNode dummy=new ListNode(-1,head);
        //双指针
        ListNode l=dummy,r=dummy;
        int tmp=k;
        int len=0;
        //标记k是否大于链表长度
        boolean flag=true;
        //遍历k
        while (tmp-->0){
            if (r.next==null){//如果k大于链表的长度
                if (len==0) return null;
                k%=len;
                flag=false;
                break;
            }
            len++;
            r=r.next;
        }
        if (k==0||(r.next==null&&flag)) return head;//k是0或者k刚好等于链表长度
        if (!flag){//k小于链表长度
            r=dummy;
            while (k-->0) r=r.next;
        }
        while (r.next!=null){
            r=r.next;
            l=l.next;
        }
        ListNode next=l.next;
        l.next=null;
        r.next=head;
        return next;
    }


    //由于k可能比链表长度长,先获取链表的长度
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode dummy=new ListNode(-1,head);
        ListNode l=dummy,r=dummy;
        int len=0;
        while (r.next!=null){
            len++;
            r=r.next;
        }
        r=dummy;
        if (len==0) return null;
        k%=len;
        if (k==0) return head;
        while (k-->0) r = r.next;
        if (k==0) return head;
        while (r.next!=null){
            l=l.next;
            r=r.next;
        }
        ListNode next=l.next;
        l.next=null;
        r.next=head;
        return next;
    }



}
