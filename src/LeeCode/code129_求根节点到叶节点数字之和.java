package LeeCode;

public class code129_求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        //给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
        //每条从根节点到叶节点的路径都代表一个数字：
        //
        //例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
        //计算从根节点到叶节点生成的 所有数字之和 。
        //
        //叶节点 是指没有子节点的节点。
        StringBuilder stringBuilder=new StringBuilder();
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        System.out.println(sumNumbers(treeNode));
    }
    public static int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        return getPathSum(root,0,0);
    }
    public static int getPathSum(TreeNode root, int sum ,int res) {
        if (root==null) return sum;//如果是空说明,到达叶子节点的子节点null了,直接返回当前路表示的值
        sum=sum*10+root.val;
        if (root.left!=null&&root.right!=null)
            res+= getPathSum(root.left,sum,res)+getPathSum(root.right,sum,res);//如果两个子节点都存在,即存在两条路,将两路的值相加
        else if (root.left==null) res+=getPathSum(root.right,sum,res);//如果只有一个子节点存在,说明只有一条路
        else res+=getPathSum(root.left,sum,res);
        return res;
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
