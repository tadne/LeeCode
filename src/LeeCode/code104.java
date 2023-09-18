package LeeCode;

public class code104 {
    public static void main(String[] args) {
        //给定一个二叉树 root ，返回其最大深度。
        //
        //二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
        //
        //
    }
    //这种树搜索的关键,在于你要从当前节点着手,而不是从它的子节点着手,不然会陷入怪圈
    public  int maxDepth(TreeNode root) {
        if (root==null) return 0;
        else {
            int l=maxDepth(root.left);
            int r=maxDepth(root.right);
            return Math.max(l,r)+1;
        }
    }


    private class TreeNode {
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
