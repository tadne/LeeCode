package Leecode2;

import Util.ListNode;

public class code21_合并两个有序链表 {
    public static void main(String[] args) {
        //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    }
    //递归原地修改
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1==null) return l2;
        else if (l2==null) return l1;
        if (l1.val>=l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }else {
            l1.next=mergeTwoLists(l2,l1.next);
            return l1;
        }
    }
    //循环
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1==null) return l2;
        else if (l2==null) return l1;
        //初始化首部
        ListNode res;
        if (l1.val<=l2.val){
            res=new ListNode(l1.val);
            l1=l1.next;
        }else {
            res=new ListNode(l2.val);
            l2=l2.next;
        }
        ListNode tail=res;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tail.next=new ListNode(l1.val);
                tail=tail.next;
                l1=l1.next;
            }else {
                tail.next=new ListNode(l2.val);
                tail=tail.next;
                l2=l2.next;
            }
        }
        if (l1==null) tail.next=l2;
        else tail.next=l1;
        return res;
    }
}
