package Leecode2;

import java.util.Arrays;

public class code48_旋转图像 {
    public static void main(String[] args) {
        //给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
        //
        //你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
        int[][]mat=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(mat);
        System.out.println(Arrays.deepToString(mat));
    }
    //123==>    321==>  741
    //456       654     852
    //789       987     963
    //先按行逆序
    //再按反对角线逆序
    public static void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=m;
        for (int[] ints : matrix) {
            int l = 0;
            while (l < m / 2) {
                swap(ints, l, m - 1 - l);
                l++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[m-1-j][m-1-i];
                matrix[m-1-j][m-1-i]=tmp;
            }
            n--;
        }
    }
    public static void swap(int[]arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
