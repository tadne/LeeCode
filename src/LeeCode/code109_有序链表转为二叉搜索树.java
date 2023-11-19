package LeeCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class code109_有序链表转为二叉搜索树 {
    public static void main(String[] args) {
        //给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
        //
        //本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
        ListNode listNode=new ListNode(-10);
        listNode.next=new ListNode(-3);
        listNode.next.next=new ListNode(0);
        listNode.next.next.next=new ListNode(5);
        listNode.next.next.next.next=new ListNode(9);
        TreeNode treeNode = sortedListToBST(listNode);
        System.out.println(treeNode);
    }
    //先遍历链表,获取其中的值
    //然后二分有序集合方式建立二叉搜索树
    //方式比较朴素,速度不快
    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        return generateTreeNodeForMiddle(list, 0, list.size() - 1, null,false);
    }
    public static TreeNode generateTreeNodeForMiddle(List<Integer> list,int start,int end,TreeNode res,boolean flag){
        if (start>end) return res;
        int middle = (start+end)/2;
        if ((start+end)%2==1) {
            if (!flag) middle++;
        }
        res=new TreeNode(list.get(middle));
        res.left = generateTreeNodeForMiddle(list, start, middle-1, res.left,false);//选右边的
        res.right = generateTreeNodeForMiddle(list, middle+1, end, res.right,true);//选左边的
        return res;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
