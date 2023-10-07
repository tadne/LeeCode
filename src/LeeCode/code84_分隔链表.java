package LeeCode;


public class code84_分隔链表 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
        //
        //你应当 保留 两个分区中每个节点的初始相对位置。
        //链表中节点的数目在范围 [0, 200] 内
        //-100 <= Node.val <= 100
        //-200 <= x <= 200
        ListNode dummy= new ListNode(2);
        dummy.next= new ListNode(1);
        dummy.next.next= new ListNode(3);
        dummy.next.next.next= new ListNode(2);
        dummy.next.next.next.next=new ListNode(5);
        dummy.next.next.next.next.next=new ListNode(2);
        ListNode listNode = partition(dummy,2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    //找到第一个>=x的节点
    //遍历找到所有比x小的节点并移动回来
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(-101,head);
        ListNode l=dummy;
        while (l.next!=null){//左指针遍历,目标: 找到第一个大于或等于x的的值
            if (l.next.val >= x) {
                ListNode r=l.next;
                while (r.next!=null){//右指针遍历,目标:    找到l后所有比x小的值
                    if (r.next.val<x){
                        //将找到的小于x的值放发l指针后面一位并删除原来位置
                        int num = r.next.val;
                        r.next = r.next.next;
                        l.next = new ListNode(num, l.next);
                        //将左指针放到新交换来的元素上
                        l = l.next;
                    }else r=r.next;
                }
                return dummy.next;
            } else l = l.next;
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
