package LeeCode;

import Util.TreeNode;
import Util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code404_左叶子之和 {
    public static void main(String[] args) {
        //给定二叉树的根节点 root ，返回所有左叶子之和。
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,3,4,5,-7,-6,null,null,-7,null,-5,null,null,null,-4);
        TreeNode treeNode = TreeNodeUtil.generateTreeNodeByArray(list);
        System.out.println(sumOfLeftLeaves(treeNode));
    }
    //遍历二叉树
    //但是要注意避开直接对root本身讨论,而是在叶子节点的父节点处去加子节点,这样就可以免去对右边节点遍历时无法处理的问题
    static int sum=0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return sum;
        if (root.left!=null&&root.left.right==null&&root.left.left==null) sum+=root.left.val;//左子节点是叶子
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

}
