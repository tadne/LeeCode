package LeeCode;

public class code375_猜数字游戏II {
    public static void main(String[] args) {
        //我们正在玩一个猜数游戏，游戏规则如下：
        //
        //我从 1 到 n 之间选择一个数字。
        //你来猜我选了哪个数字。
        //如果你猜到正确的数字，就会 赢得游戏 。
        //如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
        //每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
        //给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
    }

    //动态规划 用 f(i,j) 表示在范围 [i,j]内确保胜利的最少金额
    //为了保证猜中,要计算f(1,n)
    //f(1,n)=x+max(f(1,x−1),f(x+1,n)),其中 x 是所猜数字
    //接下来为了保证最小,就可以遍历从f(i,j)范围遍历 x ,找到最小
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {//前两个循环维护二维数组
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {//维护最小现金数
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
