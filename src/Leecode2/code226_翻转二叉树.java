package Leecode2;

import Util.TreeNode;

public class code226_翻转二叉树 {
    public static void main(String[] args) {
        //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
    }
    //递归、二叉树、深搜
    public TreeNode invertTree(TreeNode root) {
        //停止条件
        if (root==null) return null;

        //交换左右
        TreeNode left = root.left;
        root.left=root.right;
        root.right=left;

        //深度递归
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
