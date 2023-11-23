package LeeCode;

public class code82_删除排序链表中的重复元素2 {
    public static void main(String[] args) {
        //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
        //[1,2,3,3,4,4,5]
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(3);
        head.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next=new ListNode(6);
        ListNode dummy = deleteDuplicates(head);
        while (dummy.next!=null){
            dummy=dummy.next;
            System.out.println(dummy.val);
        }

    }
    //注意,题目不是去重,题目说的是要删除所有重复数字的节点,比如 122==>1
    //所以遍历的时候,当前节点是不能被操作的,只能去操作后一个或后两个节点
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);//哑节点
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {//保证下两个存在
            if (cur.next.val == cur.next.next.val) {//后一个和后二个相同
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {//删除重复的后二个
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;//不同就跳过
            }
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
