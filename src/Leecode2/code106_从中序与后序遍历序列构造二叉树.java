package Leecode2;

import Util.TreeNode;
import Util.TreeNodeUtil;

import java.util.HashMap;
import java.util.Map;

public class code106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
        int[] inorder = {9,3,15,20,7},postorder = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postorder);
        TreeNodeUtil.seeTreeNodeByLevel(treeNode);
    }
    //从后序获取根节点，从中序获取子树区间，循环重复
    static int pid=0;
    static Map<Integer,Integer> map=new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        pid=postorder.length-1;
        return buildTree(inorder,postorder,0,postorder.length-1);
    }

    /**
     * 前序和中序遍历序列构造二叉树
     * @param inorder 中序遍历数组
     * @param postorder 前序遍历数组
     * @param inL 当前树在中序数组中的区间左
     * @param inR 当前树在中序数组中的区间右
     * @return 结果二叉树
     */
    private static TreeNode buildTree(int[] inorder, int[] postorder, int inL, int inR) {
        //递归结束条件
        //如果左区间大于右区间表示当前树遍历完毕
        if (inL>inR||pid<0){
            return null;
        }

        //中序遍历中根节点的位置
        int rootIdx=map.get(postorder[pid]);
        TreeNode root=new TreeNode(inorder[rootIdx]);
        pid--;

        //去寻找下一个前序的根节点,先右后左，因为后序遍历是 左右根，并且现在pid是逆序遍历
        root.right=buildTree(inorder,postorder,rootIdx+1,inR);
        root.left=buildTree(inorder,postorder,inL,rootIdx-1);

        return root;
    }

}
