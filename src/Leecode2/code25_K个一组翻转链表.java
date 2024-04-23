package Leecode2;

import Util.ListNode;
import Util.ListNodeUtil;

public class code25_K个一组翻转链表 {
    public static void main(String[] args) {
        //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
        //
        //k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
        //
        //你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
        ListNode node = ListNodeUtil.arrToListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.printLisNode(reverseKGroup(node,2));
    }
    //可以注意到有的方法的返回值为数组形式，这是为了在数组长度为1时停止，也就是在反转到末尾时停止
    //对于这点也可以通过一个全局的boolean来处理

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1,head);
        return dfs(dummy,k);
    }

    /**
     * 每 k 个节点一组翻转
     * @param dummy 哑节点
     * @param k 间隔翻转的数量
     * @return 反转后的链表
     */
    public static ListNode dfs(ListNode dummy, int k) {
        if (dummy==null) return null;
        ListNode[] listNodes = reverseK(dummy.next, k);
        if (listNodes.length==1) return dummy.next;
        listNodes[1].next=dfs(listNodes[1],k);
        return listNodes[0];
    }

    /**
     * 反转链表的前k个节点
     * @param head 头节点
     * @param k 反转的数量
     * @return 数组【反转后的头节点，反转后的第k个节点】
     */
    public static ListNode[] reverseK(ListNode head, int k) {
        ListNode r=head;
        while (r!=null&&k-->1){
            r=r.next;
        }
        //如果不足k个停止
        if (r==null||k!=0) return new ListNode[]{head};
        ListNode next=r.next;
        r.next=null;
        ListNode[] reverse = reverse(head);
        reverse[1].next=next;
        return reverse;
    }

    /**
     * 反转整个链表
     * @param head 头节点
     * @return 返回数组【反转后的头节点，反转后的尾节点】
     */
    public static ListNode[] reverse(ListNode head){
        ListNode pre=null,cur=head;
        while (cur!=null){
            ListNode next= cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return new ListNode[]{pre,head};
    }
}
