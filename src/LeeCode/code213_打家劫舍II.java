package LeeCode;

public class code213_打家劫舍II {
    public static void main(String[] args) {
        //你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
        // 这个地方所有的房屋都 围成一圈 ，意味着第一个房屋和最后一个房屋是紧挨着的。
        // 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
        //给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
    }
    //用动态规划
    //我们知道如果房子不成圈,那么 如果知道完美偷了前 n-1和前n-2 个房子的钱,记为dp[n-1],dp[n-2], 那么是否偷第n个房子取决于 dp[n-1] 与dp[n-2]+第n个房子中的钱数
    //现在房屋成圈,说明第一间房和最后一间房只能偷其中一个
    //那么只要算出完美偷第 2~n 间房的钱数与 偷 1~n-1间房钱数的取大即可
    public int rob(int[] nums) {
        int len=nums.length;
        if (len==0) return 0;
        else if (len==1) return nums[0];
        else if (len==2) return Math.max(nums[0],nums[1]);
        int [] dp=new int[len-1],dp1=new int[len-1];
        dp[0]=nums[0];
        dp1[0]=nums[1];
        dp[1]=Math.max(nums[0],nums[1]);
        dp1[1]=Math.max(nums[1],nums[2]);
        for (int i = 2; i < nums.length-1; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i+1]);
        }
        return Math.max(dp[len-1],dp1[len-1]);
    }
}
