package LeeCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code637_二叉树的层平均值 {
    public static void main(String[] args) {
        //给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
        // 与实际答案相差 10^-5 以内的答案可以被接受。
        TreeNode node=new TreeNode(2147483647);
        node.left=new TreeNode(2147483647);
        node.right=new TreeNode(2147483647);

        System.out.println(averageOfLevels(node));
    }
    //和code199类似,就是层序遍历,记录层的节点数量
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        double sum =0;
        int levelCount =1,count=levelCount;//levelCount层节点数,count用来遍历当前层
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            sum+=poll.val;count--;//弹出一个就count-1
            if (poll.left!=null) queue.add(poll.left);
            if (poll.right!=null) queue.add(poll.right);
            if (count==0){//count=0说明到达当前层的最后一个元素了,该统合计算平均值了
                res.add(sum/levelCount);
                levelCount=queue.size();
                count=levelCount;
                sum=0;
            }
        }
        return res;
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
