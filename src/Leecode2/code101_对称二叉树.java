package Leecode2;

import Util.TreeNode;

public class code101_对称二叉树 {
    public static void main(String[] args) {
        //给你一个二叉树的根节点 root ， 检查它是否轴对称。
        //
        //
    }
    //二叉树、遍历、深搜
    //同时遍历左右两子树对比
    public static boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(TreeNode l,TreeNode r) {
        if (l==null&&r==null) return true;
        else if (l!=null&&r!=null){
            if (l.val==r.val){
                return isSymmetric(l.left,r.right)&&isSymmetric(l.right,r.left);
            }else return false;
        }else return false;
    }
}
