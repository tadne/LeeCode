package Leecode2;

public class code122_买卖股票的最佳时机II {
    public static void main(String[] args) {
        //给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
        //
        //在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
        //
        //返回 你能获得的 最大 利润 。
    }
    //因为可以同一天买入和卖出，那么显然只要升序就买，降序就卖避开所有降价即可
    public int maxProfit(int[] prices) {
        int sum=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]) sum+=prices[i]-prices[i-1];
        }
        return sum;
    }
}
