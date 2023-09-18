package LeeCode;

import java.util.Arrays;

public class code823 {
    public static void main(String[] args) {
        //给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] > 1。
        //
        //用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
        //
        //满足条件的二叉树一共有多少个？答案可能很大，返回 对 10^9 + 7 取余 的结果。

        // arr = [2, 4]         输出: 3
        //arr = [2, 4, 5, 10]   输出: 7
        //arr =[15,13,22,7,11]  输出: 5
        //arr =[18,3,6,2]   输出:12
        //arr =[45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,
        //      21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48] 输出:777
        //arr =[18865777,36451879,36878647] 输出: 5
        int[] arr={18865777,36451879,36878647};
        System.out.println((long) 36451879*18865777);
        //       [0, 1, 1, 2, 1, 3, 1, 5, 2,  3, 1,  11,  1,  3,  3,  14, 1, 11, 1,  11,  3,  3,  1, 45,  2,  3,  5,  11, 1,
        //       19, 1, 49,  3,  3, 3,  58, 1,  3,  3,  45,  1,  19, 1, 11, 11, 3,  1, 193,  2,  7,  181]
        System.out.println(numFactoredBinaryTrees(arr));
    }
    //啊啊啊啊啊,这个题写了快两个小时,晕了要
    //可能还是我太菜了吧

    //先排序
    //线性规划,用dp[i]来作为当前这个数作为根节点满足条件的树的个数
    //然后全部加起来返回
    public static int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long sum=1;
        long[] dp=new long[arr.length+1];//dp[i]: 当前这个数作为根节点满足条件的树的个数
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=getNumOfBTree(arr,i-1,dp);
            sum+=dp[i];
        }
        return (int) (sum%1000000007);
    }
    //获取对应数值
    public static long getNumOfBTree(int [] arr,int idx, long[] dp){
        int l=0,r=idx-1;
        long num=1;
        while (r >= l) {
            if ((long) arr[l] * arr[r] > arr[idx]) r--;
            else if ((long)arr[l] * arr[r] < arr[idx]) l++;
            else if (arr[r]< Math.sqrt(arr[idx])) break;//剪枝
            else {
                if (l==r) num += dp[l + 1] * dp[r + 1];
                else num += ( dp[l + 1] * dp[r + 1])*2;
                l++;
            }
        }
        return num;
    }
}
