package LeeCode;


public class code84 {
    public static void main(String[] args) {
        //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
        //
        //你应当 保留 两个分区中每个节点的初始相对位置。
        ListNode dummy= new ListNode(2);
        dummy.next= new ListNode(1);
//        dummy.next.next= new ListNode(3);
//        dummy.next.next.next= new ListNode(2);
//        dummy.next.next.next.next=new ListNode(5);
//        dummy.next.next.next.next.next=new ListNode(2);
        ListNode listNode = partition(dummy,2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    //143252  3
    //012    2
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(-101,head);
        ListNode l=dummy;//左指针
        while (l.next!=null){//遍历
            if (l.next.val >= x) {//找到左边第一个大于x的值
                ListNode r=l.next;//右指针
                while (r.next!=null){//遍历右指针
                    if (r.next.val<x){//找到l后面所有小于x的值
                        //将找到的小于x的值放发哦l指针后面一位并删除原来位置
                        int num=r.next.val;
                        r.next=r.next.next;
                        ListNode temp=new ListNode(num,l.next);
                        l.next=temp;
                        //将左指针放到新交换来的元素上
                        l=l.next;
                        //还原右指针
                        r=l.next;
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
