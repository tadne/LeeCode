package Leecode2;

import Util.TreeNode;

public class code124_二叉树中的最大路径和 {
    public static void main(String[] args) {
        //二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
        // 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
        //
        //路径和 是路径中各节点值的总和。
        //
        //给你一个二叉树的根节点 root ，返回其 最大路径和 。
    }

    //深度回溯，自底而上查找最大路径和
    //然后注意，对于一条边，我们的选择有：中、左中、右中、左中右  四种选择
    //其中，中、左中、右中都是当前边下的最大和，是可以并入其他边的和的
    //但是左中右，这种情况它不能被并入其他边，不能作为返回值，但是要被记录最大值
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        trackBack(root);
        return max;
    }
    public int trackBack(TreeNode root) {
        if (root==null) return 0;

        int left=trackBack(root.left);
        int right=trackBack(root.right);

        //当前最大和在：左中、右中、中
        int cur=Math.max(Math.max(left,right)+root.val,root.val);
        //最大和在：左中右
        max=Math.max(Math.max(root.val+left+right,cur),max);
        return cur;
    }
}
