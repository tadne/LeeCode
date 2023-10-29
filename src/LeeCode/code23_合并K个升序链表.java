package LeeCode;

import java.util.List;

public class code23_合并K个升序链表 {
    public static void main(String[] args) {
        //给你一个链表数组，每个链表都已经按升序排列。
        //
        //请你将所有链表合并到一个升序链表中，返回合并后的链表。
        //
        //
    }
    //普通合并,直接循环,但是会随着res的变长导致效率低
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode(-1000000);
        for (ListNode list : lists) {
            mergeTwoLists(res, list);
        }
        return res.next;
    }
    //分治合并,就是不断两两合并,最终合并为一个
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    //递归分治,比较常用
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    //递归合并两个有序链表,这代码真的不能再简洁了,真爱
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
