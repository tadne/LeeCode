package LeeCode;

import java.util.Arrays;

public class code304_二维区域和检索_矩阵不可变 {
    public static void main(String[] args) {
        //给定一个二维矩阵 matrix，以下类型的多个请求：
        //
        //计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
        //实现 NumMatrix 类：
        //
        //NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
        //int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
        int[][] mat={
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}};
        NumMatrix numMatrix=new NumMatrix(mat);
        System.out.println(numMatrix.sumRegion(0, 0, 2, 2));
    }
    //一维前缀和
    //二维前缀和比较复杂,不便于无图的讲解,可以去查查对应资料
    private static class NumMatrix {
        int[][] myMatrix;
        public NumMatrix(int[][] matrix) {
            int m=matrix.length,n=matrix[0].length;
            int sum=0;
            myMatrix=new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum+=matrix[i][j];
                    myMatrix[i][j]=sum;
                }
                sum=0;
            }
            System.out.println(Arrays.deepToString(myMatrix));
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum=0;
            for (int i = row1; i < row2+1; i++) {
                if (col1==0) sum+=myMatrix[i][col2];
                else sum+=myMatrix[i][col2]-myMatrix[i][col1-1];
            }
            return sum;
        }
    }

}
