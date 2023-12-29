package LeeCode;

public class code377_组合总和IV {
    public static void main(String[] args) {
        //给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
        //
        //题目数据保证答案符合 32 位整数范围。
        int[] nums={1,2,3};
        int tar=4;
        System.out.println(combinationSum4(nums, tar));
    }
    //动态规划
    //用 dp[x] 表示选取的元素之和等于 x 的方案数 故目标为dp[tar],初始值为dp[0]=1,即什么都不选,只有一种方案
    //如果存在排列 num_1+num_2+..+num_k=tar,那么 所有的这种排列的和就是dp[tar]
    //例如:   nums={1,2,3},tar=4. 那么 dp[4]=dp[4-1]+dp[4-2]+dp[4-3]=dp[3-1]+dp[3-2]+dp[3-3]+dp[2-1]+dp[2-2]+dp[1-1]=..=7
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/combination-sum-iv/solutions/740581/zu-he-zong-he-iv-by-leetcode-solution-q8zv/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    //回溯法,但是会超时...
    //这个题乍一看是回溯,但其实用数学的方式找规律显然更有效些
    static int res=0;
    public static int combinationSum4(int[] nums, int target) {
        trackBack(nums,target,0);
        return res;
    }
    public static void trackBack(int[]nums,int target,int sum){
        if (sum>target)return;//剪枝
        if (sum==target) {//结束条件
            res++;
            return;
        }
        for (int num : nums) {
            sum+=num;
            trackBack(nums,target,sum);
            sum-=num;//回溯
        }
    }
}
