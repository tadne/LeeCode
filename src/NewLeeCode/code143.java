package NewLeeCode;

import java.util.ArrayList;
import java.util.List;

public class code143 {
    public static void main(String[] args) {
        //给定一个单链表 L 的头节点 head ，单链表 L 表示为：
        //L0 → L1 → … → Ln - 1 → Ln
        //请将其重新排列后变为：
        //  l1  l2  l3  l4  l5
        //  l1  l5  l2  l4  l3
        //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        //不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
       // head.next.next.next.next=new ListNode(5);
        reverseList(head);
    }
    //先找到链表的中间位置
    //将链表的后半段给反转
    //连接两个链表
    public static void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }
    //找到链表中间点
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //反转链表
    public static ListNode reverseList(ListNode head) {//1234==>1==>21==>321==>4321
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;//临时保存
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    //合并链表
    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }



    //涉及可能比较繁琐的交换,所以干脆用集合处理会很容易
    public static void reorderList(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        //双指针
        int i=0;
        int n=list.size();
        int j=list.size()-1;
        //交换
        while (j>i){
            list.get(i).next=list.get(j);
            list.get(j).next=list.get(i+1);
            i++;
            if (i==n/2) list.get(i).next=null;//在i在集合中间的时候,将右指针的下一个置空
            j--;
        }
        head=list.get(0);
        //遍历
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public void swap(ListNode left,ListNode right){

    }

    private static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


}
