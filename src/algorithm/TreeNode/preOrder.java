package algorithm.TreeNode;

import NewLeeCode.code144;

import java.util.ArrayList;
import java.util.List;

public class preOrder {
    //二叉树前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root,res);
        return res;
    }
    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if(root==null) return;
        res.add(root.val);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
