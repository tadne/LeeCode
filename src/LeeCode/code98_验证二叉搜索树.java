package LeeCode;

import java.util.Deque;
import java.util.LinkedList;

public class code98_验证二叉搜索树 {
    public static void main(String[] args) {
        //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        //
        //有效 二叉搜索树定义如下：
        //
        //节点的左子树只包含 小于 当前节点的数。
        //节点的右子树只包含 大于 当前节点的数。
        //所有左子树和右子树自身必须也是二叉搜索树。
        TreeNode root=new TreeNode(-1);
        root.left=new TreeNode(-1);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.right.left=new TreeNode(5);
        System.out.println(isValidBST2(root));


    }
    //中序遍历的搜索树是绝对递增的,如果不是绝对递增的就不是搜索树
    static int pre=-1;//用来记录上一个节点的值
    static boolean vis=true; //用来判断是不是第一次给pre赋值
    public static boolean isValidBST2(TreeNode root) {
        if (root==null) return true;
        boolean a = isValidBST2(root.left);
        if (vis) {
            pre = root.val;
            vis=false;
        } else {
            if (root.val<=pre) return false;
            pre = root.val;
        }
        boolean b = isValidBST2(root.right);
        return a&&b;
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    //对于右节点,最大值是:正无穷,最小值是:根节点的值
    //对于左节点,最小值是:负无穷,最大值是:根节点的值
    //右节点的左子节点,最大值是: 右节点的父节点,最小值:右节点
    //左节点的右子节点,最大值是: 左节点的父节点,最小值:左节点
    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }


    //用队列实现中序遍历
    //记录当前节点值,变道为当前节点的右节点
    public static boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();//双端队列,左右两端都可以进出
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {//栈不为空或值不为空
            while (root != null) {//右子树不为空就添加所有左节点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//从最小左节点开始吐
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;//记录
            root = root.right;//找从树的左侧最下层开始找右子树
        }
        return true;
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
