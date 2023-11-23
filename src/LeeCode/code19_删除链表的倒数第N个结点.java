package LeeCode;

public class code19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);
        ListNode listNode1 = removeNthFromEnd(listNode, 1);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1= listNode1.next;
        }

    }
    //双指针,右指针先走n步(哑巴节点,不然就是n+1步),然后同步走,右指针到末尾,左指针就到位置了,删除即可
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode l=dummy;
        ListNode r=dummy;
        for (int i = 0; i < n; i++) {//右指针先走n步
            r=r.next;
        }
        while (r.next!=null){//同步
            l=l.next;
            r=r.next;
        }
        l.next=l.next.next;//删除
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
