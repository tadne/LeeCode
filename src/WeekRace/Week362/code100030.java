package WeekRace.Week362;

public class code100030 {
    public static void main(String[] args) {
        //给你一个大小为 3 * 3 ，下标从 0 开始的二维整数矩阵 grid ，分别表示每一个格子里石头的数目。
        // 网格图中总共恰好有 9 个石头，一个格子里可能会有 多个 石头。
        //
        //每一次操作中，你可以将一个石头从它当前所在格子移动到一个至少有一条公共边的相邻格子。
        //
        //请你返回每个格子恰好有一个石头的 最少移动次数 。
        //grid.length == grid[i].length == 3
        //0 <= grid[i][j] <= 9
        //grid 中元素之和为 9 。
    }
    //4+3*2+2*3+1*2=18 最大情况
    //1*3+2*3+3*2=15
    //1*4+2*4=12
    //找最近的
    //
    //
    public int minimumMoves(int[][] grid) {
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                if (grid[i][j]==0){

                }
            }
        }
        return 0;
    }



}
