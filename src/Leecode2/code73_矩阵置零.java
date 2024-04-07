package Leecode2;

public class code73_矩阵置零 {
    public static void main(String[] args) {
        //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //定义两个标记变量，一个标记行是否有0，一个标记列是否有0
        boolean flagCol0 = false, flagRow0 = false;
        for (int[] ints : matrix) {//查看第一列是否有0
            if (ints[0] == 0) {
                flagCol0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {//查看第一行是否有0
            if (matrix[0][j] == 0) {
                flagRow0 = true;
                break;
            }
        }
        //遍历整个数组，如果有nums[i][j]是0，就将第一行nums[i][0]和第一列nums[0][j]设为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //重新遍历，如果第一行后第一列有一个是0，那该位置就是0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //如果第一行或者第一列有0，要将第一行和第一列进行处理
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
