package LeeCode;

public class code21_合并两个有序链表 {
    public static void main(String[] args) {
        //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode1.next=new ListNode(2);
        listNode.next.next=new ListNode(4);

        ListNode listNode2 = mergeTwoLists(listNode1, listNode);
        System.out.println(listNode2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);//哑节点避免空值判断
        ListNode tmp=dummy;
        while (list1!=null&&list2!=null){//如果都不是空
            int n1= list1.val;
            int n2= list2.val;
            if (n1>n2){//取小的那个,并移动指针
                tmp.next=new ListNode(n2);
                list2=list2.next;
            }else{
                tmp.next=new ListNode(n1);
                list1=list1.next;
            }
            tmp=tmp.next;
        }
        if (list1==null) tmp.next=list2;//有一个是空值说明另一个不用遍历了,直接引用
        else tmp.next=list1;
        return dummy.next;
    }



    //        作者：腐烂的橘子
//        链接：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/103891/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //递归的极简操作,爱了爱了
    public static ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
