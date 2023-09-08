package NewLeeCode;

public class code203 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    }
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {//下一个是就删
                temp.next = temp.next.next;
            } else {//不是就遍历下一个
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return head;
        head.next=removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
