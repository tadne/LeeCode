package LeeCode;

import Util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class code382_链表随机节点 {
    public static void main(String[] args) {
        //给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
        //
        //实现 Solution 类：
        //
        //Solution(ListNode head) 使用整数数组初始化对象。
        //int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        Solution s=new Solution(node);
        System.out.println(s.getRandom());
    }
    //就是存进数组,然后随机即可
    private static class Solution {

        public static List<ListNode> list;
        public static Random r;
        public Solution(ListNode head) {
            list=new ArrayList<>();
            r=new Random();
            while (head!=null){
                list.add(head);
                head=head.next;
            }
        }

        public int getRandom() {
            return list.get(r.nextInt(list.size())).val;
        }
    }

}
