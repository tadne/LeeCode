package LeeCode;

import Util.ListNode;
import Util.ListNodeUtil;

public class code328_奇偶链表 {
    public static void main(String[] args) {
        //给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
        //
        //第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
        //
        //请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
        //
        //你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
        ListNode listNode = ListNodeUtil.arrToListNode(new int[]{1, 2, 3, 4, 5});
        ListNode listNode1 = oddEvenList(listNode);
        ListNodeUtil.printLisNode(listNode1);
    }
    public static ListNode oddEvenList(ListNode head) {
        //初始化,先找到奇数和偶数的指针
        if (head==null||head.next==null) return head;
        ListNode l = head,r = head.next;
        ListNode l1 = l,r1 = r;
        head=head.next.next;
        //开始逐个筛选奇位置和偶位置
        while (head!=null){
            //添加奇位置
            l1.next=head;
            l1=l1.next;
            head = head.next;
            //添加偶位置
            if (head!=null) {
                r1.next = head;
                r1 = r1.next;
                head = head.next;
            }
        }
        r1.next=null;//删除最后一位,链表的长度可能是奇数
        l1.next=r;//合并奇偶两个链表
        return l;
    }
}
