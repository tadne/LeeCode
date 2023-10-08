package LeeCode;

public class code226_翻转二叉树 {
    public static void main(String[] args) {
        //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        TreeNode treeNode1 = invertTree(treeNode);
        System.out.println(treeNode1);
    }


    public static TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
