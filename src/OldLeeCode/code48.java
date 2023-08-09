package OldLeeCode;

import java.util.*;

public class code48 {
    public static void main(String[] args) {
        //给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
        //
        //你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
    public static void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int len = matrix.length;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len - i; j++){//镜像,左上角和右下角换位置
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
        }
//        for (int i = 0; i < len/2; ++i){//给行换位置
//            int[] temp;
//            temp=matrix[i];
//            matrix[i]=matrix[len-i-1];
//            matrix[len-i-1]=temp;
//        }
    }
/**
 * 123
 * 456
 * 789
 *
 *  [9, 6, 3],
 *  [8, 5, 2],
 *  [7, 4, 1]]
 *
 * 963 
 * 852 
 * 741
 *
 */

}
