package Leecode2;

import Util.TreeNode;

public class code129_求根节点到叶节点的数字之和 {
    public static void main(String[] args) {
        //给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
        //每条从根节点到叶节点的路径都代表一个数字：
        //
        //例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
        //计算从根节点到叶节点生成的 所有数字之和 。
        //
        //叶节点 是指没有子节点的节点
    }
    //二叉树、深度搜索
    public static int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        return sumNumbers(root,0);
    }
    public static int sumNumbers(TreeNode root,int sum) {
        sum=sum*10+root.val;
        if (root.left==null&&root.right==null) return sum;
        else if (root.left==null) return sumNumbers(root.right,sum);
        else if (root.right==null) return sumNumbers(root.left,sum);
        else return sumNumbers(root.right,sum)+sumNumbers(root.left,sum);
    }
}
