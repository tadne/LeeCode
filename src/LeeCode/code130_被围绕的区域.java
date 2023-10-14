package LeeCode;

import java.util.Arrays;

public class code130_被围绕的区域 {
    public static void main(String[] args) {
        //给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
        //任何边界上的 'O' 都不会被填充为 'X'。
        // 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
        char[][] board = {
                { 'O', 'X', 'X', 'X'},
                { 'X', 'O', 'O', 'X'},
                { 'X', 'X', 'O', 'X'},
                { 'X', 'O', 'X', 'X'}};
        solve(board);
    }
    //题目说了边界上的O不会被填充
    //我们只要遍历边界,找到这些O和与这个O相邻的O,标记它们
    //然后填充所有没有被标记的O即可
    static int m,n;
    public static void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        for (int i = 0; i < n; i++) {//遍历边界找O
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for (int i = 0; i < m; i++) {//遍历边界找O
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    //找到当前的0所处区域,并将它填为X
    public static void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') return;//遇到X或A或边界停止
        board[r][c] = 'A';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}
