package Leecode2;

import Util.TreeNode;

public class code230_二叉搜索树中第k小的元素 {
    public static void main(String[] args) {
        //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
    }
    //前序遍历可得到树节点的升序排列
    int i;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        i=k;
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode root,int k){
        if (root==null) return;
        dfs(root.left,k);
        if (--i==0) {
            res = root.val;
            return;
        }
        dfs(root.right,k);
    }

}
