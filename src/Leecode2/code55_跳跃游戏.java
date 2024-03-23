package Leecode2;

public class code55_跳跃游戏 {
    public static void main(String[] args) {
        //给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
        //
        //判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
        int[]arr={0,2,3};
        System.out.println(canJump(arr));
    }
    //可以发现，一个点跳到另一个点最远可以跳到 i+nums[i]
    //这样只要推算当前能跳的最远距离即可知道能不能到达目的地
    public static boolean canJump(int[] nums) {
        int len=nums.length;
        boolean[] dp=new boolean[nums.length];//dp[i]表示是否能从0跳到位置i
        int max=nums[0];//表示当前能跳到的最远位置
        dp[0]=true;
        for (int i = 1; i < nums.length; i++) {
            if (max<i) return false;//如果当前最远跳不过位置i，直接返回false
            dp[i]= true;
            max=Math.max(max,i+nums[i]);
        }
        return dp[nums.length-1];
    }

}
