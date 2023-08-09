package OldLeeCode;

public class code62 {
    public static void main(String[] args) {
        //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        //
        //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
        //
        //问总共有多少条不同的路径？

    }
    //我们用f(i,j) 表示从左上角走到(i,j) 的路径数量，其中i 和j 的范围分别是[0,m) 和[0,n)。
    // 由于我们每一步只能从向下或者向右移动一步，因此要想走到(i,j)，
    // 如果向下走一步，那么会从(i−1,j) 走过来；
    // 如果向右走一步，那么会从(i,j−1) 走过来。
    // 因此我们可以写出动态规划转移方程：f(i,j)=f(i−1,j)+f(i,j−1)
    // 需要注意的是，有边界条件
    // 最终的答案即为f(m−1,n−1)。
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {//让第一行为1
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {//第一列为1
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];//每一个值都等于其下面的+其右边的
            }
        }
        return f[m - 1][n - 1];
    }

    ////从左上角到右下角一共 必须 要m-1次向下,n-1次向右,共m+n-2次.也就是只有从m+n-2次中挑选出m-1次向下即可,组合数...
    public int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
