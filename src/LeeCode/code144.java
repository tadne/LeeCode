package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code144 {
    public static void main(String[] args) {
        //给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
       preorderTraversal(root,res);
       return res;
    }
    public void preorderTraversal(TreeNode root,List<Integer> res) {
        if(root==null) return;
        res.add(root.val);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
