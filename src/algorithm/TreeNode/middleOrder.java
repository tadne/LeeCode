package algorithm.TreeNode;



import java.util.ArrayList;
import java.util.List;

public class middleOrder {
    //二叉树中序遍历 :左根右顺序
    public List<Integer> inorderTraversal1( TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    public void inorder( TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);//先找到最左那个
        res.add(root.val);
        inorder(root.right, res);//找左的中间穿插找右
    }
    private class TreeNode {
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
