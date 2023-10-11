package LeeCode;

public class code112_路径总和 {
    public static void main(String[] args) {
        //给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
        // 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
        //
        //叶子节点 是指没有子节点的节点。
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        System.out.println(hasPathSum(treeNode, 1));
    }
    //这个题目恶心在要取sum的同时还要判断当前节点是不是叶子节点
    public  static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        return getPathSumEqTar(root,0,targetSum);
    }
    public static boolean getPathSumEqTar(TreeNode root,int sum,int targetSum) {
        if (root==null) return sum==targetSum;//如果是空说明,到达叶子节点的子节点null了,直接返回
        sum+=root.val;
        if (root.left!=null&&root.right!=null) return getPathSumEqTar(root.left,sum,targetSum)||getPathSumEqTar(root.right,sum,targetSum);//如果两个子节点都存在
        else if (root.left==null) return getPathSumEqTar(root.right,sum,targetSum);//如果只有一个子节点存在,那么继续沿着有节点的路去寻找sum
        else return getPathSumEqTar(root.left,sum,targetSum);
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
