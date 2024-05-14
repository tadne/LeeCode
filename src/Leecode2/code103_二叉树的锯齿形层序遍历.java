package Leecode2;

import Util.TreeNode;

import java.util.*;

public class code103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        //给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
        // （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    }
    //按序遍历，这样会需要记录一层的节点
    //锯齿遍历：从左到右和从右到左两种方向，已知上一层节点，获取下一层节点需要知道方向
    //方向：父节点获取子节点的方向 和 遍历父节点的方向
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;

        //两个队列分别放不同方向的层
        Deque<TreeNode> queue=new ArrayDeque<>();//左
        Deque<TreeNode> queue1=new ArrayDeque<>();//右
        queue.add(root);
        int count=1;//count表示当前层的节点数,用来遍历当前层
        boolean dir=true;//dir表示方向,控制向左遍历还是向右遍历
        List<Integer> list=new ArrayList<>();

        while (!queue.isEmpty()||!queue1.isEmpty()){
            TreeNode poll ;
            if (dir) poll = queue.pollLast();
            else poll=queue1.pollLast();
            list.add(poll.val);
            count--;//弹出一个就count-1

            if (dir) {//父节点方向左，那子节点加入queue1
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



    //递归法，因为是深度搜索，无法按层操作
    //采用数组反转方式实现，但是使用链表结构集合，简化反转复杂度
    //其实可以注意，这样的时间复杂度为O(n)，效率依然很高
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) return res;
        dfs(root,0);
        for (int i = 1; i < res.size(); i+=2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
    private void dfs(TreeNode root, int levelCount) {
        if (root==null) return;
        if (levelCount==res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(levelCount).add(root.val);
        if (root.left != null) dfs(root.left, levelCount + 1);
        if (root.right != null) dfs(root.right, levelCount + 1);
    }
}
