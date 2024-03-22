package Leecode2;

import java.util.Map;

public class code121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
        //
        //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
        //
        //返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    }
    //思考最大利润：在价格最低的时间买入，在价格最高的时间卖出，但是显然有要求：买入之后才能卖出
    //那么只要知道今天之后的最大价格，那就能算出今天买入的最大利润
    //再比较每一天的买入的最大利润，就可以获得交易的最大利润了。
    public int maxProfit(int[] prices) {
        int r=prices.length-1;
        int max=prices[r];
        int res=0;
        while (r>=0){
            max=Math.max(prices[r],max);
            res=Math.max(res,max-prices[r--]);
        }
        return res;
    }
}
