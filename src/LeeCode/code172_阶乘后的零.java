package LeeCode;

import java.math.BigInteger;

public class code172_阶乘后的零 {
    public static void main(String[] args) {
        //给定一个整数 n ，返回 n! 结果中尾随零的数量。
        //
        //提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
        System.out.println(trailingZeroes(30));
   //     test(24);
    }
    //要计算这个题目,首先我们要知道一个数的阶乘中,哪些数字导致出现0
    // 我们知道只有 5的偶倍数 能出现0,而且乘法中的0是不会随着计算丢失的
    // 其中还得注意,类似25=5*5会出现两个5的因子个数
    // 也就是说 n/5 可以计算出所有个位数含有 5 和 0 的数的个数
    // 另外还得计算 5 的 m(m>=2)次幂 的个数
    // 这里就出现了递归计算,也就是要不停计算幂的数量并累加
    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
    //检查实际情况
    public static void test (int n){
        BigInteger res= BigInteger.valueOf(1);
        for (long i = 1; i <= n; i++) {
            BigInteger bigInteger = BigInteger.valueOf(i);
            res = res.multiply(bigInteger);
        }
        System.out.println(res);
    }
}
