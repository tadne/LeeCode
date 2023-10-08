package LeeCode;

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
    //回溯递归
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left==null&&right==null) return true;//都是空,对称
        if (left==null||right==null) return false;//只有一个空,不对称
        if (left.val != right.val) return false;//不相等,不对称
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);//比较子节点
    }

    //回溯递归,和上面的区别不大
    public static boolean isSymmetric1(TreeNode root) {
       return isSymmetric1(root.left,root.right);
    }
    public static boolean isSymmetric1(TreeNode left,TreeNode right) {
        if (left!=null&&right!=null) {
            return left.val == right.val
                    && isSymmetric1(left.left, right.right)
                    && isSymmetric1(left.right, right.left);
        }
        else return left == null && right == null;
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
