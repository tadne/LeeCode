package LeeCode;

import java.util.PriorityQueue;

public class code313_超级丑数 {
    public static void main(String[] args) {
        //超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
        //
        //给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
        //
        //题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
    }

    //丑数都是按照已有丑数*质数获得
    //所以可以先初始化一些丑数,然后利用小根堆进行遍历,循环与已获取的丑数相乘得到新的丑数,维护丑数的排序
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        //动态规划初始化
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{primes[i], i, 0});//(值val,primes下标i,丑数下标idx),val=ans[idx]*primes[i]
        }
        int[] ans = new int[n];
        ans[0] = 1;
        //根据已有丑数获取新的丑数
        for (int j = 1; j < n; ) {
            int[] poll = queue.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            if (val != ans[j - 1]) ans[j++] = val;
            queue.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
        }
        return ans[n - 1];
    }
//    作者：宫水三叶
//    链接：https://leetcode.cn/problems/super-ugly-number/solutions/924673/gong-shui-san-xie-yi-ti-shuang-jie-you-x-jyow/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //暴力破解,就是将所有的丑数都求出来再排序
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        while (n-- > 0) {
            int x = queue.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) queue.add(k * x);
                if (x % k == 0) break;
            }
        }
        return 0;
    }
}
