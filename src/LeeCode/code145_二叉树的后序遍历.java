package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code145_二叉树的后序遍历 {
    public static void main(String[] args) {
        //给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root, List<Integer> res){
        if (root==null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
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
