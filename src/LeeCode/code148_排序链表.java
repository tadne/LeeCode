package LeeCode;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class code148_排序链表 {
    public static void main(String[] args) {
        //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
        //
        //
        int [] arr=new int[]{3,2,3,1,2,2,2,2,2,2,1,3,1,2,1,3,3,3,2,3,1,1,2,3,3,1,2,1,1,2,3,2,3,3,2,1,3,3,3,1,2,2,2,3,2,3,3,1,3,1,3,1,3,2,3,3,1,3,2,2,2,2,1,3,1,2,2,3,3,1,2,2,3,2,2,1,1,1,3,2,3,3,2,3,1,1,1,2,1,2,1,3,1,1,1,1,1,1,2,3,2,3,1,3,3,2,1,3,3,2,2,3,2,3,1,2,1,2,1,2,2,3,2,1,3,2,2,3,3,1,1,1,3,3,3,2,2,3,2,2,2,3,1,2,1,1,3,1,3,3,3,2,1,3,2,2,3,1,3,3,2,1,2,3,3,1,2,3,2,1,1,3,1,2,1,3,2,1,1,3,1,3,2,1,2,1,1,2,2,2,3,1,3,1,3,1,1,1,2,3,2,1,3,2,1,3,2,2,2,1,1,1,3,3,1,1,3,3,2,2,2,1,1,2,1,2,1,3,3,3,1,1,1,1,2,1,1,3,2,1,1,3,3,3,3,1,2,3,3,2,1,2,1,3,2,3,1,2,1,1,2,3,2,3,2,3,3,2,1,1,3,2,1,2,2,3,3,3,3,2,2,2,1,3,3,3,2,1,3,3,2,1,1,3,2,1,2,2,2,3,1,1,1,3,3,2,3,3,3,3,2,3,2,2,3,1,1,1,3,2,3,2,2,1,1,3,1,3,1,1,2,2,1,3,3,3,2,1,1,3,3,1,2,2,3,3,1,1,1,3,2,3,2,3,3,2,1,1,1,1,2,3,2,3,3,1,1,3,1,2,1,1,2,2,2,2,1,3,1,3,3,3,3,3,3,3,1,3,3,2,1,1,2,2,1,2,3,2,3,1,3,1,1,3,2,1,2,1,2,2,3,1,2,1,3,2,1,3,2,3,3,2,3,3,1,3,2,2,1,3,2,2,3,2,2,2,1,2,3,2,3,3,3,2,3,1,3,3,1,3,3,3,3,1,2,2,2,1,3,3,3,2,3,1,1,2,3,3,3,1,3,3,1,2,3,1,3,1,3,2,1,1,3,3,3,2,2,3,3};
        ListNode listNode=new ListNode(arr[0]);
        ListNode tmp=listNode;
        for (int i = 1; i < arr.length; i++) {
            tmp.next=new ListNode(arr[i]);
            tmp=tmp.next;
        }
        ListNode listNode1 = sortList(listNode);
        while (listNode1!=null) {
            System.out.print(listNode1.val+" ");
            listNode1=listNode1.next;
        }
    }

    //    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/sort-list/solutions/492301/pai-xu-lian-biao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //逻辑就是,将链表划分为n个链表,然后逐个重复合并
    public ListNode sortList1(ListNode head) {
        if (head == null) return head;
        int length = 0;
        ListNode node = head;
        while (node != null) {//先计算出链表的长度
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);//哑节点
        for (int subLength = 1; subLength < length; subLength <<= 1) {//循环合并2的倍数长度的链表
            ListNode prev = dummyHead, curr = dummyHead.next;//左边链表的左右
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {//将左边链表的右边向右移动sunLength长度,也就是扩展一倍
                    curr = curr.next;
                }
                ListNode head2 = curr.next;//取出右边链表的左边节点
                curr.next = null;//截断左边链表
                curr = head2;//开始对右边链表截取
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {//让右边链表获得等同左边链表的长度或者获取后面所有节点
                    curr = curr.next;
                }
                ListNode next = null;//记录右边链表的右边节点
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);//合并左右两个链表
                prev.next = merged;//将合并后链表加入排序后行列
                while (prev.next != null) {//将排序后链表节点移动到末尾
                    prev = prev.next;
                }
                curr = next;//修改右边链表的头节点为合并前右边链表的右边节点
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {//合并两个有序链表
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    //通过了,但是超过时间限制,暴力插入
    public static ListNode sortList(ListNode head) {
        if (head==null) return null;
        ListNode dummy=new ListNode(0,new ListNode(head.val));
        ListNode r=dummy.next;
        head=head.next;
        while (head!=null){
            if (head.val<dummy.next.val) {
                ListNode tmp=new ListNode(head.val);
                tmp.next=dummy.next;
                dummy.next=tmp;
            }else if (r.val<head.val){
                r.next=new ListNode(head.val);
                r=r.next;
            }else {
               ListNode l=dummy.next;
               while (l.next!=null&&l.next.val <= head.val){
                   l=l.next;
               }
               ListNode tmp=new ListNode(head.val);
                tmp.next=l.next;
                l.next=tmp;
            }
            head=head.next;
        }
        return dummy.next;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
