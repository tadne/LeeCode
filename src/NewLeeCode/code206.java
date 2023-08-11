package NewLeeCode;

import java.util.ArrayList;
import java.util.List;

public class code206 {
    public static void main(String[] args) {
        //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
        //
    }
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        ListNode res=new ListNode(list.get(list.size()-1));
        ListNode idx=res;
        for (int i = list.size()-2; i >= 0; i--) {
            idx.next=new ListNode(list.get(i));
            idx=idx.next;
        }
        return res;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
