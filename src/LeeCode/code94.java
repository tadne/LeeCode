package LeeCode;

import java.util.*;

public class code94 {
    public static void main(String[] args) {
        //给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
        
        TreeNode root=new  TreeNode(4);
        root.left=new  TreeNode(2);
        root.left.left=new  TreeNode(1);
        root.left.right=new  TreeNode(3);
        root.right=new  TreeNode(6);
        root.right.right=new  TreeNode(7);
        root.right.left=new  TreeNode(5);
        System.out.println(inorderTraversal(root));
    }
    //    4
    //  2    6
    //1  3  5 7

    //栈
    public static List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();//双端队列,左右两端都可以进出
        List<Integer> res=new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {//右子树不为空就添加所有左节点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//从最小左节点开始吐
            res.add(root.val);
            root = root.right;//找从树的左侧最下层开始找右子树
        }
        return res;
    }

    //递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);//先找到最左那个
        res.add(root.val);
        inorder(root.right, res);//找左的中间穿插找右
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
