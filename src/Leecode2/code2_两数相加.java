package Leecode2;

import Util.ListNode;

public class code2_两数相加 {
    public static void main(String[] args) {
        //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        //
        //请你将两个数相加，并以相同形式返回一个表示和的链表。
        //
        //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = null, tail = null;
        while (l1 != null || l2 != null) {
            //取数，如果为空即为0
            int left = l1 == null ? 0 : l1.val;
            int right = l2 == null ? 0 : l2.val;
            int sum = left + right + carry;
            carry = sum / 10;
            if (res == null) {//初始情况
                res = new ListNode(sum % 10);
                tail = res;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return res;
    }
}
