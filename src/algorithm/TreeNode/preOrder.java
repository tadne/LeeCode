package algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class preOrder {
    //二叉树前序遍历 :根左右顺序     二叉树后序遍历和前序几乎一样,就不写了: 是左右根顺序
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
    private static class TreeNode {
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
