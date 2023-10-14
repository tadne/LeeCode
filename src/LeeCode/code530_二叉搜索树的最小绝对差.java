package LeeCode;

public class code530_二叉搜索树的最小绝对差 {
    public static void main(String[] args) {
        //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
        //
        //差值是一个正数，其数值等于两值之差的绝对值。
        //树中节点的数目范围是 [2, 10^4]
        //0 <= Node.val <= 10^5
        TreeNode node=new TreeNode(1);
        node.right=new TreeNode(5);
        node.right.left=new TreeNode(3);
        System.out.println(getMinimumDifference(node));
    }
    static int pre=-1,ans=Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if (root!=null) pre=root.val;
        dfs(root);
        return ans;
    }
    //二叉树中序遍历,中序遍历的搜索树是递增的
    public static void dfs(TreeNode root) {
        if (root==null) return;
        dfs(root.left);
        if (pre == -1) {//如果是第一次,就直接赋值,不用管大小
            pre = root.val;
        } else {//递归取最小绝对值
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
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
