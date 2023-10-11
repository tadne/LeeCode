package LeeCode;

import java.util.Stack;

public class code114_二叉树展开为链表 {
    public static void main(String[] args) {
        //给你二叉树的根结点 root ，请你将它展开为一个单链表：
        //
        //展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        //展开后的单链表应该与二叉树 先序遍历 顺序相同
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right=new TreeNode(5);
        treeNode.right.right=new TreeNode(6);
        flatten(treeNode);
        while (treeNode!=null){
            System.out.println(treeNode.val);
            treeNode=treeNode.right;
        }
    }

    //递归就是先找到最右边的节点的左子树的最左节点,这个节点是先序遍历中,最后一颗子树要遍历的第一个节点
    //用pre记录不断记录这个节点,回溯形成链表即可
    private static TreeNode pre = null;
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
    public static void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left == null) {//左子树为 null
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
    public static void flatten2(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {// 递归添加右节点
                toVisit.push(cur);
                cur = cur.right;
            }
            cur = toVisit.peek(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问当前节点
            if (cur.left == null || cur.left == pre) {
                toVisit.pop();
                cur.right = pre;
                cur.left = null;
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }
//    作者：windliang
//    链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
