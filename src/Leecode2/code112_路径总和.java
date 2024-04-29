package Leecode2;

import Util.TreeNode;

public class code112_路径总和 {
    public static void main(String[] args) {
        //给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
        // 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
        //
        //叶子节点 是指没有子节点的节点。
    }

    //二叉树、深度搜索
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) return targetSum == root.val;
        else if (root.left == null) return dfs(root.right, targetSum - root.val);
        else if (root.right == null) return dfs(root.left, targetSum - root.val);
        else return dfs(root.right, targetSum - root.val) || dfs(root.left, targetSum - root.val);
    }
}
