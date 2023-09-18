package LeeCode;

public class code322 {
    public static void main(String[] args) {
        //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        //
        //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        //
        //你可以认为每种硬币的数量是无限的。
    }

    //回溯法,树搜索的好办法,最简单
    int res = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        findWay(coins,amount,0);
        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
    public void findWay(int[] coins,int amount,int count){
        if(amount < 0) return;//不合适
        if(amount == 0) res = Math.min(res,count);//取最小值
        for (int coin : coins) {
            findWay(coins, amount - coin, count + 1);
        }
    }

    //记忆搜索法,其实就是上面方法的剪枝,不过说实话我没看明白这个方法
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange1(coins, amount, new int[amount]);
    }
    private int coinChange1(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange1(coins, rem - coin, count);
            if (res >= 0 && res < min) min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
    //线性规划,就是  amount的最少硬币数量  =  amount-x的最小数量 + 1
    public int coinChange(int[] coins, int amount) {
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

}
