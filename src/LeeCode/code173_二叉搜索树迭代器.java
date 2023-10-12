package LeeCode;

import java.util.*;

public class code173_二叉搜索树迭代器 {
    public static void main(String[] args) {
        //实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
        //BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。
        // BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
        //boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
        //int next()将指针向右移动，然后返回指针处的数字。
        //注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
        //
        //你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
        //树中节点的数目在范围 [1, 105] 内
        //0 <= Node.val <= 106
        //最多调用 105 次 hasNext 和 next 操作
    }
    static class  BSTIterator {
        //左根右
        public void inorder(TreeNode root,List<Integer> res){//中序遍历,将数据按顺序放入集合
            if (root==null) return;
            if (root.left!=null) inorder(root.left,res);
            res.add(root.val);
            if (root.right!=null) inorder(root.right,res);
        }
        private static final ArrayList<Integer> list=new ArrayList<>();
        private static int idx=0;
        public BSTIterator(TreeNode root) {
            inorder(root,list);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx < list.size();
        }
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
