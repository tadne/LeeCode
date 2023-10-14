package LeeCode;

public class code230_二叉搜索树的第k小元素 {
    public static void main(String[] args) {
        //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
        //树中的节点数为 n 。
        //1 <= k <= n <= 10^4
        //0 <= Node.val <= 10^4
        TreeNode node=new  TreeNode(3);
        node.left=new  TreeNode(1);
        node.left.right=new  TreeNode(2);
        node.right=new  TreeNode(4);
        System.out.println(kthSmallest(node,1));
    }
    //中序遍历,搜索树是递增的
    static int i=0;//记录遍历的个数
    static int val=0;//记录当前遍历节点的值
    public static int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return val;
    }
    public static void dfs(TreeNode root, int k) {
        if (root==null) return;
        dfs(root.left,k);
        if (++i<=k) val= root.val;//当i为k的时候,说明找到了
        else return;//停止递归
        dfs(root.right,k);
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
