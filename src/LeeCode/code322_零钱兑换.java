package LeeCode;

import java.util.Arrays;
import java.util.Comparator;

public class code322_零钱兑换 {
    public static void main(String[] args) {
        //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        //
        //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        //
        //你可以认为每种硬币的数量是无限的。
    }
    //回溯法,树搜索的好办法,最简单,但是会超时!!!
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        findWay(coins,amount,0);
        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
    // 硬币币值 总金额 零钱数
    public void findWay(int[] coins,int amount,int count){
        if(amount < 0) return;//不合适
        if(amount == 0) res = Math.min(res,count);//取最小值,这里可能看不明白,这里是在所有路径的结果中取最小值
        for (int coin : coins) {
            findWay(coins, amount - coin, count + 1);
        }
    }
    //这个不会超时
    //线性规划,就是  amount的最少硬币数量  =  amount-x的最小数量 + 1
    public int coinChange1(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){//计算i=1开始计算,memo[i],即总金额为i的所需的最少硬币个数
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && memo[i - coin] < min)//如果 所求amount大于等于当前硬币且不是当前最小值
                    min = memo[i - coin] + 1;//将最小值设置为减去当前硬币值的最小数+1去递归
            }
            memo[i] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];//如果最小值不存在,说明不存在硬币满足条件
    }

    //不过我不理解为什么超时了,我感觉这个剪枝效果上更好
    //剪枝
    //amount==0时,因为大面值硬币需要更多小面值硬币替换，继续减少一枚或几枚大硬币搜索出来的答案【如果有】肯定不会更优。
    //amount!=0时,cnt>=ans,那么就要剪枝
    int ans=Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);//排序
        dfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    // 硬币币值 索引 总金额 当前硬币数
    public void dfs(int[] coins,int index,int amount,int cnt){
        if(index<0) return;//小于0不要
        for(int c=amount/coins[index];c>=0;c--){//遍历, 拿金额除最大币值 , 然后从大到小遍历最大币值应该放多少
            int na=amount-c*coins[index];//除去最大币值后的值
            int ncnt=cnt+c;//更新硬币数
            if(na==0){ //剪枝
                ans=Math.min(ans,ncnt);
                break;
            }
            if(ncnt>=ans) break;//剪枝
            dfs(coins,index-1,na,ncnt);//继续递归去遍历去除下一个 最大币值
        }
    }
//    作者：iejepwy
//    链接：https://leetcode.cn/problems/coin-change/solutions/135622/dfsjian-zhi-2ms-ji-bai-100bi-dphuan-kuai-by-iejepw/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
