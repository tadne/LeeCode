package LeeCode;

import java.util.LinkedList;
import java.util.Queue;

public class code909_蛇梯棋 {
    public static void main(String[] args) {
        //n x n 的整数矩阵 board ，方格按从 1 到 n^2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
        //
        //玩家从棋盘上的方格 1 （在最后一行、第一列）出发。
        //每一回合，玩家要从当前方格 curr 出发，按下述要求前进：
        //
        //选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n^2)] 。
        //该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
        //传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
        //当玩家到达编号 n^2 的方格时，游戏结束。
        //r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
        // 编号为 1 和 n^2 的方格上没有蛇或梯子。
        //
        //注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
        //
        //举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
        //返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。
        int[][] arr=
                {{-1,-1,-1,-1,-1,-1}
                ,{-1,-1,-1,-1,-1,-1}
                ,{-1,-1,-1,-1,-1,-1}
                ,{-1,35,-1,-1,13,-1}
                ,{-1,-1,-1,-1,-1,-1}
                ,{-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(arr));
    }

    //可以用一个队列来存储搜索状态，
    // 初始将起点状态 (1,0) 加入队列，表示当前位于起点 1，移动次数为 0。
    // 然后不断取出队首，每次取出队首元素时扩展新状态，即遍历该节点的出边，若出边对应节点未被访问，则将该节点和移动次数加一的结果作为新状态，加入队列。
    // 如此循环直至到达终点或队列为空。
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];//给所有节点设置状态,已经搜索和没有搜索
        Queue<int[]> queue = new LinkedList<>();//队列
        queue.offer(new int[]{1, 0});//放入起点
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n)break;      // 超出边界
                int[] rc = id2rc(nxt, n);   // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) nxt = board[rc[0]][rc[1]];// 存在蛇或梯子
                if (nxt == n * n) return p[1] + 1;//到达
                if (!vis[nxt]) {
                    vis[nxt] = true;//设置为已搜索
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }
    public static int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/snakes-and-ladders/solutions/846328/she-ti-qi-by-leetcode-solution-w0vl/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
