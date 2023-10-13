package LeeCode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class code103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        //给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
        TreeNode node=new  TreeNode(1);
        node.left=new  TreeNode(2);
        node.right=new  TreeNode(3);
        node.left.left=new  TreeNode(4);
        node.left.right=new  TreeNode(5);
        node.right.left=new  TreeNode(6);
        node.right.right=new  TreeNode(7);
        System.out.println(zigzagLevelOrder(node));
    }
    //创建两个队列,一个管从左到右,另一个管从右到左
    //如果是从左到右遍历,得到的层节点就应该是从左到右的
    //如果是从右到左遍历,得到的层节点是应该就从右到左的
    //所以,从右到左给到从左到右队列中的数据时反向的,导致从左到右的队列也要从队列右边作为出口
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> queue=new ArrayDeque<>();//从左到右队列
        Deque<TreeNode> queue1=new ArrayDeque<>();//从右到左队列
        queue.add(root);
        int count=1;//count表示当前层的节点数,用来遍历当前层
        boolean dir=true;//fir表示方向,控制向左遍历还是向右遍历
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()||!queue1.isEmpty()){
            TreeNode poll ;
            if (dir) poll = queue.pollLast();
            else poll=queue1.pollLast();
            list.add(poll.val);
            count--;//弹出一个就count-1
            if (dir) {
                if (poll.left != null) queue1.add(poll.left);
                if (poll.right != null) queue1.add(poll.right);
            }else {
                if (poll.right != null) queue.add(poll.right);
                if (poll.left != null) queue.add(poll.left);
            }
            if (count == 0) {//count=0说明到达当前层的最后一个元素了,该转换遍历方向了
                if (dir) count = queue1.size();
                else count=queue.size();
                dir = !dir;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
    //优化思路,我怎么看都感觉可以用一个队列解决问题,因为二者可以都选择的是从右到左为出口,但是没想好该怎么合并两个
    //当前其实出口和入口是可以人为规定的,你也可以做到让从右到左的队列输出给从左到右的队列是顺序的,只要改变入口即可
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
