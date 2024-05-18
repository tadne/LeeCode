package Leecode2;

import Util.TreeNode;

public class code98_验证二叉搜索树 {
    public static void main(String[] args) {
        //给一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        //
        //有效 二叉搜索树定义如下：
        //
        //节点的 左子树 只包含 小于 当前节点的数。
        //节点的右子树 只包含 大于 当前节点的数。
        //所有左子树和右子树自身必须也是二叉搜索树。
    }
    //二叉搜索树和前序遍历有序等价
    //前序遍历：左根右
    Integer pre=null;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    public boolean dfs(TreeNode root){
        if (root==null) return true;
        boolean left = dfs(root.left);
        //如果当前节点不是第一个节点，并且，上一个节点小于等于上一个节点，说明前序遍历顺序错误
        if (pre!=null&&root.val<=pre){
            return false;
        }
        pre=root.val;
        boolean right = dfs(root.right);
        return left&&right;
    }

}
