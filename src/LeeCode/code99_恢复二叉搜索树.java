package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code99_恢复二叉搜索树 {
    public static void main(String[] args) {
        //给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(1);
        node.right=new TreeNode(4);
        node.right.left=new TreeNode(2);
        recoverTree(node);
        middleOrderSP(node);
    }

    static boolean flag=false;//作为结束递归信号
    static boolean flag1=false;//作为遇到第一个逆序位置的标志
    static TreeNode pre=null;//维护中序遍历的前一个节点
    static TreeNode l,r;//要交换的节点
    //递归
    public static void recoverTree(TreeNode root) {
        List<TreeNode> pres=new ArrayList<>();
        middleOrder(root);
        swap(l,r);
    }
    //中序遍历
    public static void middleOrder(TreeNode root){
        if (root==null||flag) return;//如果root是null或者已经找到两个要交换的位置了
        middleOrder(root.left);
       if (pre!=null&&root.val < pre.val){//如果出现逆序
           if (flag1){//如果是第二次遇到逆序
               r=root;
               flag=true;
               return;
           }
           l=pre;
           r=root;
           flag1=true;//标记第一次逆序结束
        }
        pre=root;//维护中序遍历的上一个节点
        middleOrder(root.right);
    }
    //交换恢复
    public static void swap(TreeNode pre,TreeNode root){
        int tmp= root.val;
        root.val= pre.val;
        pre.val=tmp;
    }


    public static void middleOrderSP(TreeNode root){
        if (root==null) return;
        middleOrderSP(root.left);
        System.out.println(root.val);
        middleOrderSP(root.right);
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
