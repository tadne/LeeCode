package NewLeeCode;

public class code64 {
    public static void main(String[] args) {
        //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        //
        //说明：每次只能向下或者向右移动一步。
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        minPathSum(ints);
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];//计算每一个位置的最小路径和
        dp[0][0] = grid[0][0];//初始化
        for (int i = 1; i < rows; i++) {//第一行和     123====>136
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {//第一列和     123====>136
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];//用第一行和第一列的最小路径和,可以找到每一个位置的最小路径和
            }
        }
        return dp[rows - 1][columns - 1];
    }
    //
}
