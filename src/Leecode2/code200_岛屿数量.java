package Leecode2;

public class code200_岛屿数量 {
    public static void main(String[] args) {
        //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
        //
        //岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
        //
        //此外，你可以假设该网格的四条边均被水包围。
    }
    public int numIslands(char[][] grid) {
        int num=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1') num++;
                deleteCurIsland(grid,i,j);
            }
        }
        return num;
    }
    public void deleteCurIsland(char[][] grid,int i,int j){
        if (i<grid.length&&j<grid[0].length&&i>0&&j>0&&grid[i][j]=='1'){
            grid[i][j]='0';
            deleteCurIsland(grid, i+1, j);
            deleteCurIsland(grid, i, j+1);
            deleteCurIsland(grid, i-1, j);
            deleteCurIsland(grid, i, j-1);
        }
    }
}
