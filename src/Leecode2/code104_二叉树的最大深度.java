package Leecode2;

import Util.TreeNode;

import java.util.Map;

public class code104_二叉树的最大深度 {
    public static void main(String[] args) {
        //给定一个二叉树 root ，返回其最大深度。
        //
        //二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
    }
    //二叉树、递归
    public int maxDepth(TreeNode root) {
        if (root!=null){
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }else return 0;
    }
}
