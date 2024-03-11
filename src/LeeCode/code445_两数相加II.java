package LeeCode;

import Util.ListNode;

public class code445_两数相加II {
    public static void main(String[] args) {
        //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
        //
        //你可以假设除了数字 0 之外，这两个数字都不会以零开头
    }
    //就是反转链表,两数相加,然后再次反转链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;//采用第三空间来实现相加
        l1 = revNode(l1);
        l2 = revNode(l2);//反转链表
        int carry=0;//余数
        while (l1!=null||l2!=null||carry!=0){//两数相加
            int v1= l1==null?0:l1.val;
            int v2= l2==null?0:l2.val;
            carry=(v1+v2+carry);
            cur=cur.next=new ListNode(carry%10);
            carry/=10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return revNode(dummy.next);//反转结果
    }
    //反转链表
    public ListNode revNode(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


}
