package LeeCode;

import Util.ListNode;
import Util.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class code206_反转链表 {
    public static void main(String[] args) {
        //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
        //
        ListNode node = ListNodeUtil.arrToListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.printLisNode(reverseList2(node));
    }
    //递归
    public static ListNode reverseList2(ListNode head) {
        return reverseList2(null,head);
    }
    public static ListNode reverseList2(ListNode pre,ListNode cur) {
        if (cur==null) return pre;
        ListNode next = cur.next;//储存下一个节点
        cur.next=pre;//反转
        return reverseList2(cur, next);
    }


    //直接反转
    public ListNode reverseList1(ListNode head) {
        if (head==null) return null;
        ListNode pre=null;
        ListNode cur=head;
        while (cur.next!=null){
            ListNode next = cur.next;//记录下一个
            cur.next=pre;//反转
            //整体前移
            pre=cur;
            cur=next;
        }
        return pre;
    }
    //集合储存
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        ListNode res=new ListNode(list.get(list.size()-1));
        ListNode idx=res;
        for (int i = list.size()-2; i >= 0; i--) {
            idx.next=new ListNode(list.get(i));
            idx=idx.next;
        }
        return res;
    }

}
