public class code63 {
    public static void main(String[] args) {
//一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//网格中的障碍物和空位置分别用 1 和 0 来表示。\
        int[][] ints=new int[3][3];
        ints[0][1]=1;
        System.out.println(uniquePathsWithObstacles(ints));

    }
    //首先从第一行开始遍历,f[0]已经进行初始化,想到达obstacleGrid[0][j]只能够从左往右走,
    // f[j]的默认值都是零,经过f[j] += f[j - 1] (此时i=0也就是在第一行)的第一次循环完成后第一行的所有值就已经确定了,。
    // 现在f[i]数组中保存的值就是从起点出发到第一行第i个网格有多少条不同的路径。
    // 之后继续循环，当i=1也就是遍历到第二行，第二个网格的值计算方式为上方的网格值加上左边网格的值，
    // 左边网格值已经确定，为f[j-1]，而上方网格的值就是上一轮循环中的f[j].
    // 两个值相加得到第二行第二个网格的值并将f[j]中的数据覆盖，依次循环将f[j]中的数据全部替换，
    // 此时f[j]中就保存了从起点出发到第二行第j个网格有多少条不同的路径。
    // 继续循环直到完成，最后的结果就是从起点到终点有多少条不同的路径。
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;//行
        int m = obstacleGrid[0].length;//列
        int[] f = new int[m];//分支函数,f用来记录第i行第j列的格子为终点时的路径数目
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;//如果起点就是障碍物
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {//有障碍物,就设0
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 ) {//没障碍物
                    f[j] =f[j] + f[j - 1];//这里的f[j]代表第i-1行j列的路径数,f[j-1]代表第i行j列的路径数
                }
            }
        }
        System.gc();
        return f[m-1];

    }

}
