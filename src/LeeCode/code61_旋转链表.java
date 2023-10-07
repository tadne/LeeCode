package LeeCode;

import java.util.List;

public class code61_旋转链表 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 1;//计数器
        ListNode iter = head;//指针
        while (iter.next != null) {//到结尾看看长度
            iter = iter.next;
            n++;
        }
        int add = n - k % n;//计算真实要移动的数量
        if (add == n) return head;//移动n的整数倍次,不变
        iter.next = head;//成环
        while (add > 0) {//找到真实结果的结束点
            add--;
            iter = iter.next;
        }
        ListNode res = iter.next;//开始点,也就是结束点的下一个
        iter.next = null;//断开环
        return res;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
