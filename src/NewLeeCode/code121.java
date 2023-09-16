package NewLeeCode;

public class code121 {
    public static void main(String[] args) {
        //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
        //
        //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
        //
        //返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        int r=prices.length-1;//右指针
        int max=0,res=0;
        while (r>=0){//从右边开始找最大值,并计算差值取最大
            max=Math.max(max,prices[r]);
            res=Math.max(res,max-prices[r]);
            r--;
        }
        return res;
    }
}
