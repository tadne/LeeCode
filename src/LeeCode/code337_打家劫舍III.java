package LeeCode;

import Util.TreeNode;

import java.util.*;

public class code337_打家劫舍III {
    public static void main(String[] args) {
        //小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
        //
        //除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
        // 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
        //
        //给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
    }
    //直接递归
    //就是 爷爷节点和孙子节点 与 父节点进行比较,偷钱多的
    //但是这样做会导致,在计算爷爷节点时,父节点和孙子节点也被计算了,孙子当爷爷了还得重新算一遍
    public int rob1(TreeNode root) {
        if (root == null) return 0;
        int max = root.val;
        if (root.left != null)  max += (rob(root.left.left) + rob(root.left.right));
        if (root.right != null) max += (rob(root.right.left) + rob(root.right.right));
        return Math.max(max, rob(root.left) + rob(root.right));
    }


    //任意一个节点,有两种状态,偷和不偷
    //如果偷当前节点,那么最大钱数=当前节点+不偷孩子节点的钱之和
    //如果不偷当前节点,那么最大钱数=偷孩子节点的钱之和
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    //每次递归,目标是找到偷和不偷该节点的最大钱数
    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];//递归停止
        int[] result = new int[2];

        int[] left = robInternal(root.left);//找偷或不偷左节点的最大钱数
        int[] right = robInternal(root.right);//找偷或不偷右节点的最大钱数

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//不偷当前节点,就是偷或不偷孩子节点的最大值之和
        result[1] = left[0] + right[0] + root.val;//偷当前节点,就是不偷孩子节点之和加上当前节点

        return result;
    }
//    作者：房建斌学算法
//    链接：https://leetcode.cn/problems/house-robber-iii/solutions/47828/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
