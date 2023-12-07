package LeeCode;

public class code279_完全平方数 {
    public static void main(String[] args) {
        //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
        //
        //完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    }
    //动态规划
    //dp[i]表示最少要多少个数的平方表示i
    //那么就有,dp[i]=min(dp[i-j*j])+1   其中j=1,2,..,t  t*t<=i<(t+1)(t+1)
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        for (int i = 1; i <= n; i++) {//找最少的那个可以表示i的平方和排列
            int min=Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }
        return dp[n];
    }

}
