package Leecode2;

import java.util.Arrays;

public class code130_被围绕的区域 {
    public static void main(String[] args) {
        //给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
        //
        char[][] nums={
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        solve(nums);
        System.out.println(Arrays.deepToString(nums));
    }
    //先将在边框区域的O找到并标记为‘T’
    //再遍历整个矩阵，将O全部标记为X，T全部标记为O即可
    public static void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            dfs(board,0,i);
            dfs(board,board.length-1,i);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == 'O') chars[j]='X';
                else if (chars[j]=='T')chars[j]='O';
            }
        }
    }
    //标记“O”区域块为"T"
    public static void dfs(char[][] board,int i,int j){
        if (i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!='O') return;
        board[i][j]='T';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
