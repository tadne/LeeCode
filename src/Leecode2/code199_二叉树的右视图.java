package Leecode2;

import Util.TreeNode;

import java.util.*;

public class code199_二叉树的右视图 {
    public static void main(String[] args) {
        //给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    }
    //因为存在左树比右树高的情况，这样就导致了必须将整个树都遍历一遍，不然无法知道树的高度

    //使用根右左顺序遍历保证遍历的当前层的第一个节点是第一个出现
    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    private void dfs(TreeNode root, int depth) {
        if (root==null) return;
        if (ans.size()==depth) ans.add(root.val);//如果大小和深度一致，那说明当前处于当前层所遍历的第一个

        //先右后左保证当前层遍历的第一个是最右边的
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }


    //用栈来维护，进行层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> stack=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        if (root==null) return ans;
        stack.add(root);
        int count=1;
        while (!stack.isEmpty()){
            TreeNode poll = stack.poll();
            count--;
            if (poll.left!=null) stack.add(poll.left);
            if (poll.right!=null) stack.add(poll.right);
            if (count==0){
                ans.add(poll.val);
                count=stack.size();
            }
        }
        return ans;
    }

}
