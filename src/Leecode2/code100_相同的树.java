package Leecode2;

import Util.TreeNode;

public class code100_相同的树 {
    public static void main(String[] args) {
        //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
        //
        //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    }
    //递归、二叉树、深搜
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;//停止条件

        if (p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else return false;
    }
}
