package Leecode2;

import Util.TreeNode;

public class code530_二叉搜索树的最小绝对值差 {
    public static void main(String[] args) {
        //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
        //
        //差值是一个正数，其数值等于两值之差的绝对值。
        //
        //
    }
    //二叉搜索树：中序遍历：（根左右）可得升序节点排序
    int pre=-1;
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root==null) return 0;
        dfs(root);
        return min;
    }
    public void dfs(TreeNode root){
        if (root==null) return ;
        dfs(root.left);
        if (pre!=-1){
            min=Math.max(min,root.val-pre);
        }
        pre=root.val;
        dfs(root.right);
    }


}
