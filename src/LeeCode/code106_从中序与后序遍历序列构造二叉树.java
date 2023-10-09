package LeeCode;

import java.util.Map;

public class code106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
        // postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

        //1 <= inorder.length <= 3000
        //postorder.length == inorder.length
        //-3000 <= inorder[i], postorder[i] <= 3000
        //inorder 和 postorder 都由 不同 的值组成
        //postorder 中每一个值都在 inorder 中
        //inorder 保证是树的中序遍历
        //postorder 保证是树的后序遍历
    }
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 从后序遍历的最后一个元素开始
        int post_idx = postorder.length - 1;
        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            indexMap.put(val, idx++);
        }
        return helper(0, inorder.length - 1,inorder,postorder,post_idx);
    }
    public TreeNode helper(int in_left, int in_right,int[] inorder,int[] postorder,int post_idx) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) return null;
        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        // 根据 root 所在位置分成左右两棵子树
        int index = indexMap.get(root_val);
        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right,inorder,postorder,post_idx);
        // 构造左子树
        root.left = helper(in_left, index - 1,inorder,postorder,post_idx);
        return root;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/426738/cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou-zao-14/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
