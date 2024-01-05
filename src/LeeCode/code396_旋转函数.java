package LeeCode;

import java.util.Arrays;

public class code396_旋转函数 {
    public static void main(String[] args) {
        //给定一个长度为 n 的整数数组 nums 。
        //
        //假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
        //
        //F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
        //返回 F(0), F(1), ..., F(n-1)中的最大值 。
        //
        //生成的测试用例让答案符合 32 位 整数。
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
    //0*a1+1*a2+..+(n-1)*an  = (n-1)*a1+0*a2+..+(n-2)*an - (n-1)*a1+1*a2+1*a3+..+1*an
    // 也就是说, dp[0]=dp[1]-nums[0]*(n-1)+sum(nums)-nums[0] = dp[1]-n*nums[0]+sum(nums)
    // dp[1]=dp[0]+n*nums[0]-sum
    //同理可推,dp[n]=dp[n-1]+n*nums[n-1]-sum
    //动态规划
    public static int maxRotateFunction(int[] nums) {
        //准备参数
        int max=0,sum=0;
        int n = nums.length, tmp = 0;
        int num=0;//可能得结果

        //获取第一个
        while (tmp < n) {
            sum+=nums[tmp];
            num += tmp * nums[tmp++];
        }
        max=num;
        //用第n-1个推导第n个,并比较
        tmp=0;
        while (tmp++<n){
            num += n*nums[tmp-1]-sum;
            max=Math.max(max,num);
        }
        return max;
    }
}
