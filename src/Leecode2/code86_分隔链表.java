package Leecode2;

import Util.ListNode;
import Util.ListNodeUtil;

public class code86_分隔链表 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
        //
        //你应当 保留 两个分区中每个节点的初始相对位置。
        ListNode node = ListNodeUtil.arrToListNode(new int[]{1, 4, 3, 0, 5, 2});
        ListNodeUtil.printLisNode(partition(node,2));
    }
    //双指针,链表
    public static ListNode partition(ListNode head, int x) {
        //哑节点
        ListNode dummy=new ListNode(-1,head);
        ListNode big=new ListNode(-1);
        //cur中只包含小于x的节点,big中包含大于等于x的节点
        ListNode b1=big,cur=dummy;
        while (cur.next != null){
            //如果下一个节点大于等于x
            while (cur.next!=null&&cur.next.val>=x){
                //将大的移动到big后
                b1.next=cur.next;
                //在cur中删除下一个节点
                cur.next=cur.next.next;
                //在big中删除下一个后面的节点
                b1.next.next=null;
                //移动b1指针
                b1=b1.next;
            }
            //if条件保证cur不为null
            if (cur.next!=null) cur=cur.next;
        }
        cur.next=big.next;
        return dummy.next;
    }
}
