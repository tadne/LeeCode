package Leecode2;

import Util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code102_二叉树的层序遍历 {
    public static void main(String[] args) {
        //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    }

    //递归实现层序遍历
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return result;
        recursion(root,0);
        return result;
    }
    public void recursion(TreeNode root, int levelCount) {
        //新的一层需要初始化
        if (levelCount == result.size()) result.add(new ArrayList<>());
        //当前层添加元素
        result.get(levelCount).add(root.val);
        //递归下一层
        if(root.left!=null) recursion(root.left, levelCount + 1 );
        if(root.right!=null) recursion(root.right, levelCount + 1);
    }


    //队列实现层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int levelCount=1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!=null) queue.add(poll.left);
            if (poll.right!=null) queue.add(poll.right);
            levelCount--;
            if (levelCount==0){
                res.add(new ArrayList<>(list));
                list.clear();
                levelCount=queue.size();
            }
        }
        return res;
    }
}
