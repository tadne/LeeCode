package LeeCode;

import java.util.Arrays;
import java.util.HashSet;

public class code73 {
    public static void main(String[] args) {
        //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
        int[][] matrix={{1,0,0},{4,0,6}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        //100
        //406
    }
    public static void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
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
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) flag = true;//第一行是否有0
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {//如果矩阵内有0就赋值到第一行和第一列中
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //为了防止每一列的第一个元素被提前更新，需要从最后一行开始，倒序地处理矩阵元素
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {//第一列不遍历,
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {//第一行或列有0
                    matrix[i][j] = 0;
                }
            }
            if (flag) matrix[i][0] = 0;//如果第一行有0,就将第一行全部置0
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
