package Leecode2;

import Util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code637_二叉树的层平均值 {
    public static void main(String[] args) {
        //给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
    }
    //二叉树层序遍历，栈实现
    public List<Double> averageOfLevels(TreeNode root) {
        if (root==null) return null;
        List<Double> avgList=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int levelCount=1,tmpCount=levelCount;//记录层节点数
        double sum=0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left!=null)queue.add(poll.left);
            if (poll.right!=null)queue.add(poll.right);
            sum+=poll.val;
            tmpCount--;
            if (tmpCount==0){
                avgList.add(sum/levelCount);
                sum=0;
                levelCount=queue.size();
                tmpCount=levelCount;
            }
        }
        return avgList;
    }
}
