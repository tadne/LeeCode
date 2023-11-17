package LeeCode;

import java.util.*;

public class code107_二叉树的层序遍历II {
    public static void main(String[] args) {
        //给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(9);
        node.right=new TreeNode(20);
        node.right.left=new TreeNode(15);
        node.right.right=new TreeNode(7);
        System.out.println(levelOrderBottom(node));
    }
    //因为要求的层序遍历是从底向上,这就要求我们需要知道当前遍历的树的层级
    //我们可以依然采用原来的队列自上而下来遍历,最后反转结果集合即可,但其实没必要使用队列
    //我们可以在递归中就将每一层的层级设置好,加入到对应层的结果中即可
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> res=new ArrayList<>();//结果集
       levelOrderBottom(root,res,1);//递归遍历二叉树
       Collections.reverse(res);//反转
       return res;
    }
    //递归加入元素
    public static void levelOrderBottom(TreeNode root, List<List<Integer>> res,int level) {
        if (root==null) return;//递归停止条件
        if (res.size()<level) res.add(null);//如果还没有对应集合,那就传个null留给后面创建
        if (res.get(level-1)==null){//如果是null,就创建对应集合并添加元素即可
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.set(level-1,list);
        }else res.get(level-1).add(root.val);//存在就直接添加元素
        levelOrderBottom(root.left,res,level+1);
        levelOrderBottom(root.right,res,level+1);
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
