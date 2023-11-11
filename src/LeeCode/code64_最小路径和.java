package LeeCode;

public class code64_最小路径和 {
    public static void main(String[] args) {
        //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        //
        //说明：每次只能向下或者向右移动一步。
        int[][] ints = {
                {1, 2, 3},
                {4, 5, 1},
                {7, 8, 1}};
        System.out.println(minPathSum1(ints));
    }
    //简单递归，超时
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        return minPathSum(grid,0,0,0);
    }
    public static int minPathSum(int[][] grid,int i,int j,int res) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (i== rows-1&&j==columns-1) {
            res+=grid[i][j];
            return res;
        }
        res+=grid[i][j];
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if (i<rows-1){
            a=minPathSum(grid,i+1,j,res);
        }
        if (j<columns-1){
            b=minPathSum(grid,i,j+1,res);
        }
        return Math.min(a,b);
    }
    //设 dp 为大小 m×n 矩阵，其中 dp[i][j] 的值代表直到走到 (i,j) 的最小路径和
    //grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
    //因为一个位置的最小路径和是由它的上边位置的最小路径和和左边最小路径和所决定的
    //然后就可以根据公式发现,直接遍历就可以完成dp的布置
    //还可以发现,其实可以直接修改grid,不需要创建新空间
    public static int minPathSum1(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
//    作者：Krahets
//    链接：https://leetcode.cn/problems/minimum-path-sum/solutions/25943/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static int minPathSum2(int[][] grid) {
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
