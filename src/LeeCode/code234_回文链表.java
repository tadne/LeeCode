package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code234_回文链表 {
    public static void main(String[] args) {
        //给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
    }
    public boolean isPalindrome(ListNode head) {
       StringBuilder sb=new StringBuilder();
        while (head!=null){
            sb.append(head.val);
            head=head.next;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
