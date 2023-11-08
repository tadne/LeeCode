package LeeCode;

public class code70_爬楼梯 {
    public static void main(String[] args) {
        //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
        //
        //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
        System.out.println(climbStairs(4));
    }
    public static int climbStairs(int n) {//第n阶=第n-1阶+第n-2阶
        int[]dp=new int[n];
        if (n==1) return 1;
        if (n==2) return 2;
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
