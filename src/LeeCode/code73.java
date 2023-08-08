package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class code73 {
    public static void main(String[] args) {
        //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
        int[][] matrix={{1,0,0},{4,0,6}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
    //优化思路:第二次遍历只遍历row和line集合
    public static void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> line=new HashSet<>();
        for (int i = 0; i < m; i++) {//将出错的行列添加到集合中
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    row.add(i);
                    line.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {//处理出错的行列
            for (int j = 0; j < n; j++) {
                if (row.contains(i)||line.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
