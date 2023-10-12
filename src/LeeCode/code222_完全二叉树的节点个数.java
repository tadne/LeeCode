package LeeCode;

import java.util.*;

public class code222_完全二叉树的节点个数 {
    public static void main(String[] args) {
        //给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
        //
        //完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
        // 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
    }
    int count=0;
    public int countNodes(TreeNode root) {//直接全部遍历,找到所有节点
        if (root==null) return count;
        countNodes(root.left);
        count++;
        countNodes(root.right);
        return count;
    }
    //如果想要优化的话,emm,提供几个思路,一种是二分查找,用两个队列先进先出存最左列和最右边列,每次吐队列的第i个...
    //...

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
