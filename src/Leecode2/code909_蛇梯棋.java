package Leecode2;

import java.util.LinkedList;
import java.util.Queue;

public class code909_蛇梯棋 {
    public static void main(String[] args) {
        //有个 正方形棋盘，从左下角开始蛇形向上每个格子有个从1开始递增的序号，你从序号1的格子开始，你每步可以从当前格子开始往后走1~6格
        // 你只能按序号升序走，不能往回走（如第5格走到第4格），走到最后一格就结束。每个格子内有传送门或啥都没有，-1代表啥都没有，大于0的数字代表传送门，
        // 传送门意味着可以传送到当前数字的格子去（如当前是35，你就可以传送到序号为35的格子去），
        // 如果你传送过去后的格子内依然是大于0的数字，你不能连续传送，现在要求最少需要几步可以走到终点。

        //注意：因为到达蛇或者梯子后，是强制传送的，所以存在无法到达的情况
        int[][] mtx={
                {1,1,-1},
                {1,1,1},
                {-1,1,1}};
        System.out.println(snakesAndLadders(mtx));
    }
    //广度优先搜索，最短路问题

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1]; //节点状态记录，避免出现环
        Queue<int[]> queue = new LinkedList<>();//队列
        queue.offer(new int[]{1, 0});//放入起点（1,0）：表示起点1和移动次数0
        while (!queue.isEmpty()) {
            int[] p = queue.poll();//获取起点
            for (int i = 1; i <= 6; i++) {
                int nxt = p[0] + i;
                int[] rc = id2rc(nxt, n);   //得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) nxt = board[rc[0]][rc[1]];// 存在蛇或梯子
                if (nxt >= n * n) return p[1] + 1;//可以到达，直接返回
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    /**
     * 根据序号和长度获取行列数组
     * @param id 序号
     * @param n 行长度
     * @return 行列数组
     */
    public static int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
