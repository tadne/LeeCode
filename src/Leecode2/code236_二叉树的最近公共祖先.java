package Leecode2;

import Util.TreeNode;
import Util.TreeNodeUtil;

import java.util.List;

public class code236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        //
        //百度百科中最近公共祖先的定义为：
        // “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
        //
        //
        TreeNode treeNode = TreeNodeUtil.generateTreeNodeByArray(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(lowestCommonAncestor(treeNode, treeNode.right.right, treeNode.right.left).val);
    }
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //如果是p或者q就向上传递
        if (root == p || root == q) return root;

        //后序遍历，自底向上！
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        //left和right就是找到的p或者q
        if (left == null) {//如果左树没找到，就在右树
            return right;
        } else if (right == null) {//同理
            return left;
        } else {//都不存在说明，在父节点
            return root;
        }
    }

    //先查找p或者q的位置，然后再分别处理
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        boolean pLeft = getNodeIsExist(root.left, p);
        boolean qRight = getNodeIsExist(root.right, q);
        //p在左子树q在右子树 或 p在右子树q在左子树 或 pq有一个在根部
        if (pLeft == qRight || root == p || root == q) {
            return root;
        } else {//pq在同一子树
            if (!pLeft) return lowestCommonAncestor(root.right,p,q);
            else return lowestCommonAncestor(root.left,p,q);
        }
    }
    public static boolean getNodeIsExist(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return getNodeIsExist(root.left, node) || getNodeIsExist(root.right, node);
    }
}
