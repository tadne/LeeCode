package NewLeeCode;

public class code101 {
    public static void main(String[] args) {
        //给你一个二叉树的根节点 root ， 检查它是否轴对称。
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left==null&&right==null) return true;
        if (left==null||right==null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
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
