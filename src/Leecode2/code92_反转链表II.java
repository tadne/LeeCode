package Leecode2;

import Util.ListNode;
import Util.ListNodeUtil;

public class code92_反转链表II {
    public static void main(String[] args) {
        //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
        ListNode node = ListNodeUtil.arrToListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.printLisNode(reverseBetween(node,1,2));
    }
    //双指针，链表
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //哑节点，避免初始位置的讨论
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode l=dummy,r=dummy;
        int idx=0;
        //让l指针到达left左边
        while (idx<left-1){
            idx++;
            l=l.next;
            r=r.next;
        }
        //让r指针到达right节点
        while (idx++<right){
            r=r.next;
        }
        //先保存r指针后面的节点，然后临时删除r后面的
        ListNode next=r.next;
        r.next=null;
        //反转l-r之间的节点，然后再接回临时储存的节点
        l.next=reverse(l.next);
        while (l.next!=null){
            l=l.next;
        }
        l.next=next;
        return dummy.next;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre=null,cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }




}
