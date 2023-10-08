package LeeCode;

public class code100_相同的树 {
    public static void main(String[] args) {
        //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
        //
        //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    }
    //这个题就递归回溯就完了
    //将你期待的值留给下一次递归返回
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null&&q!=null) {//都不是空
            return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);//判断值是否相等,以及其左右子树是否相等
        } else return p == null && q == null;//都是空就返回true,不都是空就返回false
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
