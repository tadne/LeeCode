package LeeCode;

import Util.TreeNode;
import Util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code437_路径总和III {
    public static void main(String[] args) {
        //给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
        //
        //路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
        List<Integer> list=new ArrayList<>();
        //Collections.addAll(list,10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        //Collections.addAll(list, 5,  3, 2,  3, -2, null, 1);
        Collections.addAll(list, 1,null,2,null,3,null,4,null,5);
        //       10
        //    5    -3
        //  3   2    11
        //3 -2   1
        TreeNode treeNode = TreeNodeUtil.generateTreeNodeByArray(list);
        System.out.println(pathSum(treeNode, 3));
    }

    //深度搜索,暴力搜索
    static int res=0;
    public static int pathSum(TreeNode root, int targetSum) {
        if (root==null) return 0;
        //当前树
        dfs(root,targetSum);
        //子树
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return res;
    }
    public static void dfs(TreeNode root,long targetSum){//用long解决越界问题
        if (root==null) return;
        targetSum-=root.val;
        if (targetSum==0) {
            res++;
        }
        //继续探索
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
    }

}
