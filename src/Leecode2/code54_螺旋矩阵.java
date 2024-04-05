package Leecode2;

import java.util.ArrayList;
import java.util.List;

public class code54_螺旋矩阵 {
    public static void main(String[] args) {
        //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
        int[][] arr={{1,2,4},{5,7,8}};
        System.out.println(spiralOrder(arr));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i <= matrix.length/2&&i<=matrix[0].length/2; i++) {
            int cycle = getCycle(res, matrix, i, i);
            if (cycle==1) break;
        }
        return res;
    }
    public static int getCycle(List<Integer> res, int[][] matrix, int i, int j){
        int row=matrix.length;
        int col=matrix[0].length;
        int temp=j;
        if (row!=col) {
            if (i == row / 2 && row % 2 == 0)
                return 1;//列比行多、当前是最中间的圈、行是偶数
            else if (j == col / 2 && col % 2 == 0)
                return 1;//列比行多、当前是最中间那个圈、列是偶数
        }
        for (; temp < col-j; temp++) {//添加上行数据
            res.add(matrix[i][temp]);
        }
        temp=i+1;
        for (; temp < row-i; temp++) {//右列数据
            res.add(matrix[temp][col-j-1]);
        }
        if (row!=col&&(i==row/2||j==col/2)) {//如果说,矩阵不是一个正方形,那么最后一圈的元素,只能遍历一次行和列,不然会重复获取最后一行或列
            return 1;
        }
        temp=col-j-2;
        for (; temp >=j; temp--) {//下行数据
            res.add(matrix[row-i-1][temp]);
        }
        temp=row-i-2;
        for (; temp >i; temp--) {//左列数据
            res.add(matrix[temp][j]);
        }
        return 0;
    }
}
