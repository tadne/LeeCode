package Week358;

public class code6914 {
    public static void main(String[] args) {
        //给你一个 非空 链表的头节点 head ，表示一个不含前导零的非负数整数。
        //
        //将链表 翻倍 后，返回头节点 head 。
        //[1,8,9]   输出：[3,7,8]
        //[9,9,9]   输出：[1,9,9,8]
        //链表中节点的数目在范围 [1, 104] 内
        //0 <= Node.val <= 9
        //生成的输入满足：链表表示一个不含前导零的数字，除了数字 0 本身。
        ListNode listNode=new ListNode(9);
        listNode.next=new ListNode(9);
        listNode.next.next=new ListNode(9);
        doubleIt(listNode);
        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public static ListNode doubleIt(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode l=dummy;
        ListNode r=l.next;
        do{
            l.val=(r.val*2)/10+l.val;
            r.val=(r.val*2)%10;
            l=l.next;
            r=r.next;
        }while (l.next!=null);
        if (dummy.val!=0) return dummy;
        else return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
