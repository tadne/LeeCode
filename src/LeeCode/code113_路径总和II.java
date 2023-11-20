package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code113_路径总和II {
    public static void main(String[] args) {
        //给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
        //
        //叶子节点 是指没有子节点的节点。
        TreeNode node=new TreeNode(5);
        node.right=new TreeNode(8);
        node.right.left=new TreeNode(13);
        node.right.right=new TreeNode(4);
        node.right.right.left=new TreeNode(5);
        node.right.right.right=new TreeNode(1);
        node.left=new TreeNode(4);
        node.left.left=new TreeNode(11);
        node.left.left.left=new TreeNode(7);
        node.left.left.right=new TreeNode(2);
        System.out.println(pathSum(node, 22));
    }
    //回溯法, 采用了前序遍历的模式, 根左右遍历
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        trackBack(root,targetSum,res,list,0);
        return res;
    }
    public static void trackBack(TreeNode root, int targetSum,List<List<Integer>> res,List<Integer> list,int sum) {
        if (root==null) return;
        list.add(root.val);//添加元素
        sum+=root.val;//求和
        if (root.left==null&&root.right==null) {//如果到达叶子节点
            if (sum==targetSum) res.add(new ArrayList<>(list));//就判断一下当前路径是否满足条件
            return;
        }
        if (root.left!=null) {//如果左边不为空
            trackBack(root.left, targetSum, res, list, sum);//继续回溯左边
            list.remove(list.size() - 1);
        }
        if (root.right!=null){//如果右边不为空
            trackBack(root.right, targetSum, res, list, sum);//开始回溯右边
            list.remove(list.size() - 1);
        }
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
