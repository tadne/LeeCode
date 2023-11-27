package LeeCode;

import java.util.Arrays;

public class code204_计数质数 {
    public static void main(String[] args) {
        //给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
    }
    //从小到大往上筛选,把不是质数的都筛掉,剩下的都是质数
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans++;
                for (int j = i; j < n; j += i) {//清除当前数 i 的倍数
                    isPrime[j] = 0;
                }
            }
        }
        return ans;
    }
}
