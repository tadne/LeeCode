package Leecode2;

import Util.TreeNode;
import Util.TreeNodeUtil;

import java.util.HashMap;
import java.util.Map;

public class code105_前序和中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        //给定两个整数数组 preorder 和 inorder ，
        // 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
        //inorder.length == preorder.length
        //preorder 和 inorder 均 无重复 元素
        //inorder 均出现在 preorder
        //preorder 保证 为二叉树的前序遍历序列
        //inorder 保证 为二叉树的中序遍历序列
        int[] preorder = {3}, inorder = {3};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeNodeUtil.seeTreeNodeByLevel(treeNode);
    }
    //中序遍历： 左树  根   右树
    //前序遍历： 根   左树  右树
    //从前序拿到根节点，拿根节点去中序获取左树的区间，再去前序拿左树的根节点...

    //前序数组的遍历索引
    static int pIdx =0;
    //哈希表在中序中快速找到根节点索引
    static Map<Integer,Integer> map;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,preorder.length-1);
    }

    /**
     * 前序和中序遍历序列构造二叉树
     * @param pre 前序遍历数组
     * @param ino 中序遍历数组
     * @param inL 当前树在中序数组中的区间左
     * @param inR 当前树在中序数组中的区间右
     * @return 结果二叉树
     */
    public static TreeNode buildTree(int[] pre, int[] ino, int inL, int inR){
        //递归结束条件
        //如果左区间大于右区间表示当前树遍历完毕
        if (inL>inR|| pIdx ==pre.length){
            return null;
        }

        //中序遍历中根节点的位置
        int rootIdx=map.get(pre[pIdx]);
        TreeNode root = new TreeNode(ino[rootIdx]);

        //去寻找下一个前序的根节点
        pIdx++;
        root.left=buildTree(pre,ino,inL,rootIdx-1);
        root.right=buildTree(pre,ino,rootIdx+1,inR);
        return root;
    }



}
