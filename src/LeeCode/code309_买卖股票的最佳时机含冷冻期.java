package LeeCode;

import java.util.Map;

public class code309_买卖股票的最佳时机含冷冻期 {
    public static void main(String[] args) {
        //给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
        //设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
        //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
        int[]arr=new int[]{5,2,3,0,3,5,6,8,1,5};
        System.out.println(maxProfit(arr));
    }
    //dp[i][j]: 第i天在j状态下的最大收益
    //dp[i][0]:第i天不持有也不卖出
    //dp[i][1]:第i天持有或者买入
    //dp[i][2]:第i天卖出
    //最后一天的最大收益有两种可能，而且一定是“不持有”状态下的两种可能,比较大小即可
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;

        int [][] dp=new int[n][3];

        //初始化
        dp[0][0]=0;             //0天0交易
        dp[0][1]=-1*prices[0];  //0天买入
        dp[0][2]=0;             //0天买入后卖出

        for(int i=1;i<n;i++){
            //当前没有持股
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);//前几天卖出
            //当前持股
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//今天买入或者前几天买入
            //今天卖出
            dp[i][2]=dp[i-1][1]+prices[i]; //今天卖出
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
}
