package LeeCode;

import java.util.Arrays;

public class code188_买卖股票的最佳时机IV {
    public static void main(String[] args) {
        //给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
        //
        //设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
        //
        //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    }

    //这个题是基于code123_买卖股票的最佳时机III写的
    //只要理解那个题,这个会变的比较容易
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k], cell = new int[k];
        Arrays.fill(buy, -prices[0]);
        for (int i = 0; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            cell[0] = Math.max(cell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], cell[j - 1] - prices[i]);
                cell[j] = Math.max(cell[j], buy[j] + prices[i]);
            }
        }
        return cell[k - 1];
    }

}
