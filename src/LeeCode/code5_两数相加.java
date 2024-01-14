package LeeCode;

public class code5_两数相加 {
    public static void main(String[] args) {
        //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        //
        //请你将两个数相加，并以相同形式返回一个表示和的链表。
        //
        //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        //每个链表中的节点数在范围 [1, 100] 内
    }
    //这个题要注意的是要返回的结果集是链表
    //然后,其中要记住的是要对链表长度不一致进行处理,不然得分类讨论很麻烦
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, tail = null;//res是结果集,tail是对res遍历修正
        int carry = 0;//满十进位数字
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;//对数字长度不一致做处理,
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;//加上进位数字
            if (res == null) {//给res赋值作为开头
                res= new ListNode(sum % 10);
                tail = res;
            } else {//用tail不断修正res
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) tail.next = new ListNode(carry);//最后一位
        return res;
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
