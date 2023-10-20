package algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    //后序遍历: 左右根
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root,res);
        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root==null) return;
        postorderTraversal(root.right);
        postorderTraversal(root.left);
        res.add(root.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
