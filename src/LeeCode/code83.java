package LeeCode;

public class code83 {
    public static void main(String[] args) {
        //给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
        //
        //
        ListNode dummy=new ListNode(1);
        dummy.next=new ListNode(2);
        dummy.next.next=new ListNode(3);
        dummy.next.next.next=new ListNode(3);
        //dummy.next.next.next.next=new ListNode(3);
        ListNode listNode = deleteDuplicates(dummy);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
    public static ListNode deleteDuplicates(ListNode head) {//01233
        ListNode dummy=new ListNode(-101,head);
        ListNode idx=dummy;
        while (idx.next!=null&&idx.next.next!=null){
            if (idx.next.val== idx.val){
                idx.next=idx.next.next;
            }else {
                idx=idx.next;
            }
        }
        if (idx.next!=null&&idx.next.val == idx.val){
            idx.next=null;
        }
        return dummy.next;
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
