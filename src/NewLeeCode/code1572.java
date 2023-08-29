package NewLeeCode;

public class code1572 {
    public static void main(String[] args) {
        //给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
        //
        //请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
        int[][] mat=new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum(mat));

    }
    private static int diagonalSum(int[][] mat) {
        int len = mat.length;
        if (len==1) return mat[0][0];
        int sum=0;
        if (len%2==1) sum=-mat[len/2][len/2];
        int i=0,j=0;
        while (i<len&&j<len){
            sum+=mat[i][j];
            sum+=mat[len-i-1][j];
            i++;
            j++;
        }
        return sum;
    }
}
