package LeeCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class code123_买卖股票的最佳时机III {
    public static void main(String[] args) {
        //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
        //
        //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
        //
        //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
        //
        //
        int[]prices={2,4,1};
        System.out.println(maxProfit(prices));
    }
    //在任意一天,有五种状态,: 未购买,购买一次,买卖一次,买第二次,卖第二次
    //未购买说明利润是0,不考虑
    //如果知道前一天的状态,该怎么知道第二天?
    //buy1表示买入第一次的最大利润
    //buy2表示买入第二次的最大利润
    //ceil1表示卖出第一次的最大利润
    //ceil2表示卖出第二次的最大利润
    //总之,全过程是在不停计算你身上的收入和花销,最终得到的结果自然是总收入
    //这个题的关键是放出视角,将收入看做目标,而不是着眼于单次交易最大小值
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);//买入第一次,花掉 prices[i]的钱= -prices[i]
            sell1 = Math.max(sell1, buy1 + prices[i]);//卖出第一次, 获得的利润就是 : buy1+prices[i]
            buy2 = Math.max(buy2, sell1 - prices[i]);//买入第二次,要加入第一次卖出的利润
            sell2 = Math.max(sell2, buy2 + prices[i]);//卖出第二次,要加入第二次买入的花销
        }
        return sell2;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solutions/552695/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
