package Week359;

import java.util.List;

public class code6450 {
    public static void main(String[] args) {
        //给你两个整数 n 和 k 。
        //
        //对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
        //
        //返回长度为 n 的 k-avoiding 数组的可能的最小总和。
        //1 <= n, k <= 50
        System.out.println(minimumSum(2, 6));
    }
    public static int minimumSum(int n, int k) {
        int count=0;
        int res=0;
        int val=1;
        while (val<=k/2&&count<n){
            res+=val;
            val++;
            count++;
        }
        val=k;
        while (count<n){
            res+=val;
            val++;
            count++;
        }
        return res;
    }


}
