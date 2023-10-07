package LeeCode;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.List;

public class code92_反转链表2 {
    public static void main(String[] args) {
        //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode reverse = reverseBetween(head,2,4);
        while (reverse!=null){
            System.out.println(reverse.val);
            reverse=reverse.next;
        }
    }
    //找到left和right两个节点并记录left前一个节点pre,记录right后的节点tail,并将right.next设为null
    //反转从left到right的链表,此时的left节点就是reverse链表的末尾
    //pre.next=reverse,l.next=tail.返回头结点即可
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int tmp=1;
        ListNode l=head,r=head;//双指针
        while (tmp++<=right-left){//让右指针先走
            r=r.next;
        }
        tmp=1;
        ListNode pre=null;
        while (tmp<left){
            if (tmp==left-1) pre=l;//记录left-1对应节点
            l=l.next;
            r=r.next;
            tmp++;
        }//让左右两个指针到达left和right位置
        ListNode tail=r.next;//记录后段不需要反转的链表
        r.next=null;//置空
        if (pre==null) {//如果left=1的情况
            pre = reverse(l);
            l.next=tail;
            return pre;
        } else {//left!=1
            pre.next = reverse(l);
            l.next = tail;
        }
        return head;
    }
    //反转链表
    public static ListNode reverse(ListNode head){
        ListNode pre = null;        //反转后
        ListNode cur = head;        //反转前
        while (cur != null) {
            ListNode next = cur.next;//记录后面要反转的
            cur.next = pre;//反转当前节点和前一个节点
            pre = cur;//交给反转后链表
            cur = next;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
