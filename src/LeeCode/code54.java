package LeeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.FutureTask;

public class code54 {
    public static void main(String[] args) {
        //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
        //
        //{{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}}
        //int[][] matrix={{1,2,3,4},{11,16,15,6},{10,9,8,7}};
       // int[][] matrix={{1,2,3},{4,5,6}};
        int[][] matrix={{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        List<Integer> list=new ArrayList<>();
        //System.out.println(get(list,1,1,matrix));
        //System.out.println(spiralOrder(matrix));



    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int i=0;
        int row= matrix.length;
        int line=matrix[0].length;
        boolean flag=(row==line);
        while (i<=row/2&&i<=line/2){
            int vis = get(res, i, i, matrix, flag, 0);
            if (vis==1) break;
            i++;
        }
        return res;
    }
    //添加一个圈的数据
    public static int get(List<Integer> res, int i, int j, int[][] matrix,boolean flag,int  vis){//其实i和j是相等的,但是这里代码好读一些
        int temp=j;
        int row=matrix.length;
        int line=matrix[0].length;
        if (line>row&&i==row/2&&row%2==0)   return 1;//如果列比行多,并且已经遍历到matrix的最中间那个圈,并且行是偶数
        if (row>line&&j==line/2&&line%2==0) return 1;//如果列比行多,并且已经遍历到matrix的最中间那个圈,并且列是偶数
        for (; temp < line-j; temp++) {//添加上行数据
            res.add(matrix[i][temp]);
        }
        temp=i+1;
        for (; temp < row-i; temp++) {//右列数据
            res.add(matrix[temp][line-j-1]);
        }
        if (!flag&&(i==row/2||j==line/2)) {//如果说,矩阵不是一个正方形,那么最后一圈的元素,只能遍历一次行和列,不然会重复获取最后一行或列
            return 1;
        }
        temp=line-j-2;
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
