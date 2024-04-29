package Leecode2;

import Util.TreeNode;

public class code114_二叉树展开为链表 {
    public static void main(String[] args) {
        //给你二叉树的根结点 root ，请你将它展开为一个单链表：
        //
        //展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        //展开后的单链表应该与二叉树 先序遍历 顺序相同。
    }
    //因为要本地修改二叉树root
    //也就是说，如果我们直接前序遍历修改root，会导致root的下层被修改
    //也就是说，我们需要一个从底向上的算法来处理root
    //前序遍历： 根左右，
    //它的逆序就是：右左根
    TreeNode pre;
    public void flatten(TreeNode root) {
        if (root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;//记录上一次遍历的节点
    }
}
