import java.util.Arrays;

public class code59 {
    public static void main(String[] args) {
        //给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
        //rotate(matrix);
        //System.out.println(Arrays.deepToString(generateMatrix(3)));

        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
    //思路:   一圈一圈赋值
    public static int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int row=0;//第一圈
        int first=1;//开始数字
        for (int i = 0; i <= n/2; i++) {// 一共 (n/2)+1 圈
            first = setCir(res, first, row);
            row++;
        }
        return  res;
    }
    //给一圈赋值
    public static int setCir(int[][] res,int first,int row){
        for (int i = row; i < res.length-row; i++) {//上面行
            res[row][i]=first;
            first++;
        }
        for (int i = row+1; i < res.length-row; i++) {//右边列
            res[i][res.length-1-row]=first;
            first++;
        }
        for (int i = res.length-2-row;i >=row ; i--) {//下面行
            res[res.length-1-row][i]=first;
            first++;
        }
        for (int i = res.length-2-row;i >row ; i--) {//左边列
            res[i][row]=first;
            first++;
        }
        return first;
    }
}
