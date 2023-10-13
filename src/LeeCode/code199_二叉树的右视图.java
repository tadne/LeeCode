package LeeCode;

import java.util.*;

public class code199_二叉树的右视图 {
    public static void main(String[] args) {
        //给定一个二叉树的 根节点 root，
        // 想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.right.right=new TreeNode(4);
        node.left.left=new TreeNode(5);
        System.out.println(rightSideView(node));
    }

    //层序遍历,并记录队列长度
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int count=1;//记录队列长度
        while (!queue.isEmpty()){
            TreeNode pop = queue.poll();
            count--;//弹出即-1
            if (pop.left!=null) queue.add(pop.left);
            if (pop.right!=null) queue.add(pop.right);
            if (count==0) {//等于0说明当前层已经遍历完毕,再次设置队列长度
                res.add(pop.val);
                count=queue.size();
            }
        }
        return res;
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
