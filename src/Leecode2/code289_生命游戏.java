package Leecode2;

import java.util.Arrays;

public class code289_生命游戏 {
    public static void main(String[] args) {
        //根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
        //
        //给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
        // 每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
        // 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
        //      如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        //      如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        //      如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        //      如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
        //下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
    }
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int[][] cur = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i],0,cur[i],0,n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=rule(i,j,cur,m,n);
            }
        }
    }
    public int rule(int i,int j,int[][] cur,int m,int n){
        int count = 0;
        int tar=cur[i][j];
        for (int l = 0; l < 3; l++) {
            for (int k = 0; k < 3; k++) {
                int row=i-1+k,col=j-1+l;// i-1+k和j-1+l可以遍历到9个位置
                if (row<m&&row>=0&&col<n&&col>=0&&cur[row][col]==1) count++;
            }
        }
        if (tar==1) {
            count--;//如果是1就要去除cur[i][j]这个细胞的存活数
            if (count < 2 || count > 3) return 0;
            else return 1;
        } else return count==3?1:0;
    }

}
