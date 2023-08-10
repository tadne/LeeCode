package NewLeeCode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class code2 {
    public static void main(String[] args) {
        //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        //
        //请你将两个数相加，并以相同形式返回一个表示和的链表。
        //
        //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);//head为结果集
            } else {
                tail.next = new ListNode(sum % 10);//tail修正
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {//边界条件
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);//最后一位
        }
        return head;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
