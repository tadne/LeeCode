package LeeCode;

import java.util.List;

public class code147_对链表进行插入排序 {
    public static void main(String[] args) {
        //给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
        //
        //插入排序 算法的步骤:
        //
        //插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
        //每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
        //重复直到所有输入数据插入完为止。
        //下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
        //
        //对链表进行插入排序。  05341 -5000   05341 0 03415 3  03145 1
        ListNode listNode=new ListNode(0);
        listNode.next=new ListNode(5);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(1);
        ListNode head = insertionSortList(listNode);
        while (head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {//如果是顺序就不需要排序
                lastSorted = lastSorted.next;
            } else {//不是顺序的 也就是 lastSorted>curr
                //从头遍历找 prev.next>=curr>prev
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                //删除 curr
                lastSorted.next = curr.next;
                //插入 curr 到 prev 后面
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/insertion-sort-list/solutions/491124/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
