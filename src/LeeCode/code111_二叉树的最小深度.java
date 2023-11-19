package LeeCode;

public class code111_二叉树的最小深度 {
    public static void main(String[] args) {
        //给定一个二叉树，找出其最小深度。
        //
        //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
        //
        //说明：叶子节点是指没有子节点的节点。
    }
    //找到最近的叶子节点
    //可以使用前中后序遍历都可以,记录好深度都可以
    //也可以使用层序遍历,不过这样的话有额外空间占用
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        return minDepth(root,1);
    }
    public int minDepth(TreeNode root,int level) {
        if (root.left==null&&root.right==null) return level;
        int left=-1,right=-1;
        if (root.left!=null) left = minDepth(root.left, level + 1);
        if (root.right!=null) right = minDepth(root.right, level + 1);
        if (left==-1) return right;
        else if (right==-1)return left;
        else return Math.min(left,right);
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
